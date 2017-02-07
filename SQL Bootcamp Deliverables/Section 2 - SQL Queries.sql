--Question 1
SELECT i.Publisher AS Publisher, 
	SUM(s.Price) AS TotalValue 
FROM Issues AS i 
INNER JOIN Stock AS s ON i.IssueID = s.IssueID
GROUP BY i.Publisher;

--Question 2
SELECT s.Name, 
	SUM(o.Total) As TotalValue 
FROM Orders AS o 
INNER JOIN Suppliers AS s ON o.SupplierID = s.SupplierID
WHERE o.DeliveryStatus = 'Pending' 
GROUP BY s.Name;

--Question 3
SELECT TOP(1)
	i.Title, 
	(SUM(s.Price * s.AvailableQty)) AS TotalValue 
FROM Issues AS i 
INNER JOIN Stock AS s ON i.IssueID = s.IssueID 
GROUP BY i.Title 
ORDER BY TotalValue DESC;

--Question 4
WITH	MostFrequentlyOrderedIssue 
			AS (SELECT TOP(1) i.Title, COUNT(DISTINCT(i.SeriesNumber)) AS TotalSeries, COUNT(o.OrderID) AS TotalOrdered 
				FROM Issues AS i INNER JOIN Orders AS o ON i.IssueID = o.IssueID
				GROUP BY i.Title
				ORDER BY TotalOrdered DESC)
SELECT i.Title, i.SeriesNumber, COUNT(o.OrderID) AS QtyOrdered, SUM(o.Total) AS TotalCostOfAllOrders
FROM Issues AS i
INNER JOIN Orders AS o ON i.IssueID = o.IssueID 
WHERE i.Title = (SELECT mfoi.Title FROM MostFrequentlyOrderedIssue AS mfoi)
GROUP BY i.Title, i.SeriesNumber;


--Question 5
SELECT s.StockReferenceID, 
	   s.IssueID, 
	   s.AvailableQty, 
	   sc.Price AS SupplierQuotePrice, 
	   ((20-s.AvailableQty) * sc.Price) AS CostToRestock
FROM Stock AS s 
INNER JOIN SupplierQuotes AS sc ON s.IssueID = sc.IssueID
WHERE s.Condition = 'Very Fine' AND s.AvailableQty < 20;

--Question 6 
WITH	TopContributingCreator
			AS (SELECT TOP(1) cc.CreatorID, COUNT(*) AS TotalContributions FROM ComicCreators AS cc
				GROUP BY cc.CreatorID
				ORDER BY TotalContributions DESC)
SELECT TOP(10) 
	(SELECT c.Name FROM Creators AS c WHERE c.CreatorID = cc.CreatorID) AS CreatorName, 
	cc.CreatorRole, 
	cc.IssueID, 
	i.Title, 
	i.PublicationDate  
FROM ComicCreators AS cc
INNER JOIN Issues AS i ON cc.IssueID = i.IssueID
WHERE cc.CreatorID = (SELECT c.CreatorID FROM Creators c
					  WHERE c.CreatorID = (SELECT tcc.CreatorID FROM TopContributingCreator AS tcc))
ORDER BY i.PublicationDate DESC;

--Question 7
WITH HighestTotalComicsPerTitle 
    AS (SELECT i.Publisher, 
             i.Title, 
             COUNT(DISTINCT(i.SeriesNumber)) AS TotalSeries,
             RANK() OVER (PARTITION BY i.Publisher ORDER BY COUNT(DISTINCT(i.SeriesNumber)) DESC) AS PublisherRank              
      FROM Issues AS i
      GROUP BY i.Publisher, i.Title)
SELECT htcpt.Publisher, htcpt.Title, htcpt.TotalSeries 
FROM HighestTotalComicsPerTitle AS htcpt 
WHERE PublisherRank = 1 
ORDER BY TotalSeries DESC;

--Question 8
SELECT TOP(5) i.Title, i.SeriesNumber, i.PublicationDate, SUM(s.AvailableQty) AS QtyInStock
FROM Issues AS i
INNER JOIN Stock AS s ON i.IssueID = s.IssueID
WHERE i.Title LIKE '%Star Wars%'
GROUP BY i.Title, i.SeriesNumber, i.PublicationDate 
ORDER BY i.PublicationDate DESC;

--Question 9
SELECT  i.IssueID,
        i.Title, 
        i.SeriesNumber,
        SUM(o.QtyOrdered) AS QtyOrdered,
        s.AvailableQty
FROM Issues AS i
INNER JOIN Orders AS o ON i.IssueID = o.IssueID
INNER JOIN Stock AS s ON i.IssueID = s.IssueID
WHERE i.Title LIKE '%Star Wars%' AND o.DeliveryStatus != 'Delivered'
GROUP BY i.IssueID, i.Title, i.SeriesNumber, s.AvailableQty
ORDER BY i.Title, i.SeriesNumber;
