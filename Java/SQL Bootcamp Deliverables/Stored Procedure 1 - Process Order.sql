--Write a stored procedure to process an order. It should take the contents of a customer’s shopping cart, 
--create the appropriate order and order details entries as necessary, 
--reduce the in-stock quantity of the items purchased and empty the shopping cart. 
--Ensure that the entire process either completes correctly or rolls back entirely and throws a relevant error message.

Create PROCEDURE ProcessOrder(@ShoppingCartID INT)
AS
BEGIN TRANSACTION 

INSERT INTO CustomerOrders 
(
	[OrderAmount]
	,[OrderDate]
	,[OrderReference]
	,[OrderAddress1]
	,[OrderAddress2]
	,[OrderSuburb]
	,[OrderCity]
	,[OrderPostalCode]
	,[OrderPhone]
	,[OrderEmail]
	,[OrderShippedDate]
	,[OrderTrackingNumber]
	,[OrderDeliveryMethod]
	,[OrderStatus]
	,[CustomerID]
	,[VoucherID]
)  
SELECT  
	GETDATE(), 
	'randomValueGenerator', 
	'address1',
	'address2',
	'suburb',
	'0202',
	'0833436786',
	ca.Email,ca.CustomerID,
	NULL

FROM ShoppingCart AS sc 
INNER JOIN CustomerOrders AS co ON sc.CustomerID = co.CustomerID
INNER JOIN CustomerAccounts AS ca ON ca.CustomerID = sc.CustomerID
WHERE sc.CustomerID = @ShoppingCartID;


INSERT INTO OrderDetails
(
	[DetailD]
	,[DetailQuantity]
	,[CustomerOrderID]
	,[StockReferenceID]
)
SELECT 1000, s.Price, sc.Quantity, sc.CustomerID,s.StockReferenceID
FROM ShoppingCart AS sc 
INNER JOIN Stock AS s ON s.StockReferenceID = (SELECT sc.StockReferenceID FROM ShoppingCart AS sc WHERE sc.ShoppingCartID = @ShoppingCartID);

BEGIN TRY 
	UPDATE Stock 
	SET AvailableQty-= (SELECT sc.Quantity FROM ShoppingCart AS sc WHERE sc.ShoppingCartID = @ShoppingCartID)
END TRY  
BEGIN CATCH 
	ROLLBACK TRANSACTION;
	PRINT 'Cannot process order, not enough stock.';
	THROW;
END CATCH;
COMMIT TRANSACTION
GO
