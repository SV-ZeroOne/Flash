-- Populating CustomerAccounts
INSERT INTO CustomerAccounts (FirstName, Surname, Email, Password)
SELECT FirstName, Surname, EmailAddress, HASHBYTES('MD5', EmailAddress) AS Password FROM CustomerDetails;

-- Populating CustomerAddress
INSERT INTO CustomerAddress (CustomerID, Address1, Address2, Suburb, City, PostalCode, AddressType)
SELECT ca.CustomerID, 
	cad.AddressLine1, 
	cad.AddressLine2, 
	cad.Suburb, 
	cad.City, 
	cad.PostalCode, 
	cad.AddressType 
FROM CustomerAccounts AS ca
INNER JOIN CustomerAddressDetails AS cad ON ca.FirstName = cad.FirstName AND ca.Surname = cad.Surname;

-- Populating Voucher
INSERT INTO Vouchers (Amount, Code, DateIssued, Valid)
SELECT vd.Value, vd.VoucherNumber, vd.DateIssued, '1' AS Valid FROM VoucherDetails as vd;

-- Populating ShoppingCart
INSERT INTO ShoppingCart (Quantity, CustomerID, StockReferenceID)
SELECT csc.Quantity, ca.CustomerID, s.StockReferenceID FROM CustomerAccounts AS ca
INNER JOIN CustomerShoppingCart AS csc ON ca.FirstName = csc.FirstName AND ca.Surname = csc.Surname
INNER JOIN Issues AS i ON csc.Title = i.Title AND csc.SeriesNumber = i.SeriesNumber
INNER JOIN Stock AS s ON i.IssueID = s.IssueID;

-- Populating CustomerOrders
WITH	FirstAddress
		AS (SELECT  ca.CustomerAddressID, 
					cacc.CustomerID,
					ca.Address1,
					ca.Address2,
					ca.Suburb,
					ca.City,
					ca.PostalCode,
					RANK() OVER (PARTITION BY cacc.CustomerID ORDER BY ca.CustomerAddressID) AS AddressRank 
			FROM CustomerAddress ca
			INNER JOIN CustomerAccounts cacc ON ca.CustomerID = cacc.CustomerID),
		PreparationTable 
		AS (SELECT	fa.CustomerID,
					fa.Address1,
					fa.Address2,
					fa.Suburb,
					fa.City,
					fa.PostalCode,
					cacc.Email,
					cod.OrderNumber, 
					cod.DeliveryOption,
					SUM(CAST(cod.Quantity AS int)) AS TotalItemsOrdered, 
					SUM(CAST(cod.Price AS numeric(8,2))) AS SubTotal, 
					SUM((CAST(cod.Quantity AS int) * CAST(cod.Price AS numeric(8,2)))) AS OrderTotal 
			FROM FirstAddress AS fa
			INNER JOIN CustomerAccounts AS cacc ON fa.CustomerID = cacc.CustomerID
			INNER JOIN CustomerOrderDetails AS cod ON cacc.FirstName = cod.FirstName AND cacc.Surname = cod.Surname
			WHERE AddressRank = 1
			GROUP BY fa.CustomerID, 
					 fa.Address1, 
					 fa.Address2,
					 fa.Suburb,
					 fa.City,
					 fa.PostalCode,
					 cacc.Email, 
					 cod.OrderNumber, 
					 cod.DeliveryOption)
INSERT INTO CustomerOrders (OrderAmount, 
							OrderDate, 
							OrderReference, 
							OrderAddress1, 
							OrderAddress2, 
							OrderSuburb, 
							OrderCity, 
							OrderPostalCode, 
							OrderPhone, 
							OrderEmail, 
							OrderShippedDate, 
							OrderTrackingNumber, 
							OrderDeliveryMethod, 
							OrderStatus,
							CustomerID, 
							VoucherID)
SELECT  pt.OrderTotal, 
		NULL AS OrderDate, 
		pt.OrderNumber,
		pt.Address1,
		pt.Address2,
		pt.Suburb,
		pt.City,
		pt.PostalCode,
		NULL AS OrderPhone,
		pt.Email,
		NULL AS OrderShippedDate,
		NULL AS OrderTrackingNumber,
		pt.DeliveryOption,
		NULL AS OrderStatus,
		pt.CustomerID,
		NULL AS VoucherID 
FROM PreparationTable AS pt;

-- Populating OrderDetails
INSERT INTO OrderDetails (DetailQuantity, CustomerOrderID, StockReferenceID)
SELECT  cod.Quantity,
		co.CustomerOrderID,
		s.StockReferenceID 
FROM CustomerOrderDetails AS cod
INNER JOIN CustomerAccounts AS ca ON cod.FirstName = ca.FirstName AND cod.Surname = ca.Surname
INNER JOIN CustomerOrders AS co ON ca.CustomerID = co.CustomerID
INNER JOIN Issues AS i ON cod.Title = i.Title AND cod.SeriesNumber = i.SeriesNumber
INNER JOIN Stock AS s ON i.IssueID = s.IssueID;

-- Populating Invoice
INSERT INTO Invoice (InvoiceNumber, TotalAmount, Date, CustomerOrderID)
SELECT  co.OrderReference AS InvoiceNumber,
		co.OrderAmount,
		NULL AS Date,
		co.CustomerOrderID
FROM CustomerOrders AS co;