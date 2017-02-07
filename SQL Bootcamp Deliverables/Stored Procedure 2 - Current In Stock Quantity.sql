--====================================================
--Write a stored procedure which returns a list of stock items for which the current 
--in-stock quantity is less than the total quantity in all current customers shopping carts combined.

Create PROCEDURE CurrentInStockQuantity
AS
RETURN SELECT * FROM Stock AS s
INNER JOIN ShoppingCart AS sc ON s.StockReferenceID = sc.StockReferenceID
WHERE s.AvailableQty < count(sc.Quantity)  
GO