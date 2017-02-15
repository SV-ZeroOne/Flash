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
    using Data.Repositories;

    [TestFixture]
    public class StockControllerTests
    {

        private IStockRepository stockRepository;
        private StockController stockController;
        private IIssueRepository issueRepository;


        [SetUp]
        public void init()
        {
            stockRepository = new StockRepository(new Data.ComicContext());
            issueRepository = new IssueRepository(new Data.ComicContext());
            stockController = new StockController(stockRepository, issueRepository);
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
