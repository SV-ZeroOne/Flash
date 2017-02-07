--====================================================
--Write a table-valued function that takes a customer, 
--start date and end date as parameters and 
--returns the list of items they purchased in that period. 
--An item should only appear once, with a total of how many were purchased.

CREATE FUNCTION purchaseList(@customerID INT, @startDate Date, @endDate Date)
RETURNS  @purchase TABLE 
(
    -- Columns returned by the function
    DetailID int PRIMARY KEY NOT NULL, 
	Title varchar(500) NOT NULL,
    DetailPrice numeric(8,2) NULL, 
    DetailQuantity smallint NULL,
	Condition smallint NOT NULL, 
    Total numeric(8,2) NULL
)
AS BEGIN
     DECLARE 
		@DetailID INT,
		@Title varchar(500),
        @DetailPrice numeric(8,2), 
        @DetailQuantity smallint, 
		@Condidtion varchar(10),
        @Total numeric(8,2); 
 
    -- Get information
    SELECT DISTINCT
        @DetailID = od.DetailD,
		@Title = i.Title,
		@DetailPrice = s.Price,
		@DetailQuantity = od.DetailQuantity,
		@Condidtion = s.Condition,
		@Total = (od.DetailQuantity*s.Price)
    FROM OrderDetails AS od 
    INNER JOIN CustomerOrders AS co ON od.CustomerOrderID = co.CustomerOrderID
	INNER JOIN Stock AS s ON od.StockReferenceID = s.StockReferenceID
	INNER JOIN Issues AS i ON i.Description = s.IssueID
	WHERE co.OrderDate BETWEEN @startDate AND @endDate
    RETURN;
END
GO

-- To Run the purchaseList function
SELECT *
FROM purchaseList(500,'2002-11-11','2017-11-11');
GO