using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using Moq;
using ComicStock.WebAPI.Controllers;
using System.Web.Http;
using System.Web.Http.Results;
using ComicStock.WebAPI.Models;
using System.Net;


namespace ComicStock.Tests.ControllerTests
{
    using System;
    using NUnit.Framework;
    using Data;
    using System.Collections.Generic;
    using System.Linq;

    [TestFixture]
    public class StockControllerTests
    {

        private IStockRepository stockRepository;
        private StockController stockController;

        [SetUp]
        public void init()
        {
            stockRepository = new StockRepository(new Data.ComicContext());
            stockController = new StockController(stockRepository);
        }


        [Test]
        public void GetReturnsStockWithSameId()
        {
            int testID = 3;
            IHttpActionResult actionResult = stockController.Get(testID);
            var contentResult = actionResult as OkNegotiatedContentResult<StockDTO>;

            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(testID, contentResult.Content.Id);

        }

        /*[Test]
        public void PostReturnsStockIDAddRepository()
        {
            Stock testStock =
            new Stock
            {
                IssueID = null,
                Condition = "testCon",
                AvailableQty = Int16.Parse("5"),
                Price = 100,
            };

            StockDTO testStockDTO = new StockDTO(testStock);

            IHttpActionResult actionResult = stockController.Post(testStockDTO);
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            int testID = contentResult.Content;
            Assert.IsNotNull(contentResult.Content);

            /*testIssueDTO.Title = "issue put";
            testIssueDTO.Publisher = "test publisher put";
            testIssueDTO.Description = "issue put";

            IHttpActionResult actionResultPut = issuesController.Put(testID, testIssueDTO);
            var contentResultPut = actionResultPut as OkNegotiatedContentResult<IssueDTO>;

            Assert.IsNotNull(contentResultPut.Content);
            Assert.AreEqual("issue put", contentResultPut.Content.Title);
            Assert.AreEqual("test publisher put", contentResultPut.Content.Publisher);
            Assert.AreEqual("issue put", contentResultPut.Content.Description);
            

            actionResult = stockController.Delete(testID);
            Assert.IsNotNull(actionResult);

            IHttpActionResult actionResultUpdate = stockController.Get(testID);
            var contentResultUpdate = actionResultUpdate as OkNegotiatedContentResult<StockDTO>;

            Assert.AreEqual(Int16.Parse("0"), contentResultUpdate.Content.AvailableQuantity);

        }*/
        [Test]
        public void GetReturnsStockGetPage()
        {
            int page = 1;
            int size = 10;
            IHttpActionResult actionResult = stockController.Get(page, size);
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<StockDTO>>;
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(size, contentResult.Content.Count());

        }

        [Test]
        public void GetReturnsIssuesGetPageSearch()
        {
            int page = 1;
            int size = 10;
            String search = "Very Fine";
            IHttpActionResult actionResult = stockController.Get(search, page, size);
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<StockDTO>>;
            Assert.IsNotNull(contentResult);
            foreach (var item in contentResult.Content)
            {
                StringAssert.Contains(search, item.Condition);
            }
            Assert.AreEqual(size, contentResult.Content.Count());

        }
    }
}
