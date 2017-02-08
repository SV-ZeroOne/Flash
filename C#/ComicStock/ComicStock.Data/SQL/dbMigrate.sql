USE SquareEyes

GO

-- START - Gregs code

CREATE TABLE SupplierQuotes (
	QuoteID INT IDENTITY PRIMARY KEY,
	IssueID INT FOREIGN KEY REFERENCES dbo.Issues (IssueID) NOT NULL,
	SupplierID INT FOREIGN KEY REFERENCES dbo.Suppliers (SupplierID) NOT NULL,
	Price NUMERIC(8,2) NOT NULL,
	EffectiveDate DATETIME NOT NULL
);

CREATE TABLE SupplierPayments (
	PaymentID INT IDENTITY PRIMARY KEY,
	OrderID INT FOREIGN KEY REFERENCES dbo.Orders (OrderID),
	Total NUMERIC(8,2) NOT NULL,
	ProcessedDate DATE
);

GO

WITH Starting AS (
SELECT TOP (70) PERCENT i.IssueID, SupplierID, i.PublicationDate, DATEDIFF(dd,PublicationDate, '2017-01-01') AS DaysSincePublication, s.Price
	FROM dbo.Issues i CROSS JOIN dbo.Suppliers 
		INNER JOIN dbo.Stock s ON s.IssueID = i.IssueID
	WHERE PublicationDate >= '2010/01/01'
		AND Condition = 'Very Fine'
	ORDER BY NEWID()
)
INSERT INTO dbo.SupplierQuotes
        (IssueID,
         SupplierID,
         Price,
         EffectiveDate
        )
SELECT IssueID, SupplierID, Price*(0.5 + RAND(CHECKSUM(NEWID()))*0.3), DATEADD(dd,RAND(CHECKSUM(NEWID())) * Starting.DaysSincePublication, Starting.PublicationDate) 
FROM Starting;

INSERT INTO dbo.SupplierPayments (OrderID, Total, ProcessedDate)
SELECT OrderID, Total, DATEADD(dd,-1*RAND(CHECKSUM(NEWID()))*DATEDIFF(dd,OrderDate, ShipmentDate), ShipmentDate) 
FROM dbo.Orders WHERE DeliveryStatus != 'Cancelled';

GO

-- END - Gregs code

CREATE TABLE dbo.IssueOrders
(
	OrderID INT FOREIGN KEY REFERENCES Orders(OrderID) NOT NULL,
	IssueID INT FOREIGN KEY REFERENCES Issues(IssueID) NOT NULL,
	QuoteID INT FOREIGN KEY REFERENCES SupplierQuotes(QuoteID) NOT NULL,
	QuantityOrdered SMALLINT NOT NULL
)

GO

INSERT INTO dbo.IssueOrders (OrderID, IssueID, QuoteID, QuantityOrdered)
SELECT o.OrderID, o.IssueID, sq.QuoteID, o.QtyOrdered
FROM dbo.Orders AS o
INNER JOIN dbo.SupplierQuotes AS sq
ON o.IssueID = sq.IssueID
WHERE o.SupplierID = sq.SupplierID;

GO

ALTER TABLE dbo.Orders DROP COLUMN IssueID, QtyOrdered, SupplierID;

GO

DROP TABLE dbo.Numbers