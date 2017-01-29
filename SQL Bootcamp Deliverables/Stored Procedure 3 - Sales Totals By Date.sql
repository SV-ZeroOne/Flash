--====================================================
--Write a stored procedure which takes a start date and an end date as parameters 
--returns the sales totals for that period per title. There should also be a total per publisher and a grand total.

Create PROCEDURE SalesTotalsByDate(@startDate Date, @endDate Date)
AS
SELECT i.Title,
COUNT(od.DetailQuantity) AS QuantityTotals,
COUNT(od.DetailQuantity*s.Price) AS PriceTotals
(SELECT count(s2.) AS PublisherTotal FROM Stock s2)
FROM CustomerOrders AS co 
    INNER JOIN OrderDetails AS od ON od.CustomerOrderID = co.CustomerOrderID
	INNER JOIN Stock AS s ON od.StockReferenceID = s.StockReferenceID
	INNER JOIN Issues AS i ON i.Description = s.IssueID
	WHERE co.OrderDate BETWEEN @startDate AND @endDate

GO