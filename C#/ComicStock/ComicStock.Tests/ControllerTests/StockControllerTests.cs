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
    [TestClass]
    public class StockControllerTests
    {
        [TestMethod]
        public void GetReturnsStockWithSameId()
        {
            //int testID = 1;

            //var mockRepository = new Mock<IStockRepository>();
            //mockRepository.Setup(x => x.GetById(testID))
            //    .Returns(new Stock { ID = testID });

            //var controller = new StockController(mockRepository.Object);

            //IHttpActionResult actionResult = controller.Get(testID);
            //var contentResult = actionResult as OkNegotiatedContentResult<StockDTO>;

            //Assert.IsNotNull(contentResult.Content.Issue.Id);
            //Assert.IsNotNull(contentResult.Content);
            //Assert.AreEqual(testID, contentResult.Content.Id);

        }

        [TestMethod]
        public void PostReturnsStockIDAddRepository()
        {
            var mockRepository = new Mock<IStockRepository>();
            var controller = new StockController(mockRepository.Object);

            IHttpActionResult actionResult = controller.Post(new StockDTO { });
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);

        }

        [TestMethod]
        public void PutReturnsUpdatedStockDTO()
        {

            short Qty = 10;
            var mockRepository = new Mock<IStockRepository>();
            mockRepository.Setup(x => x.GetById(4))
                .Returns(new Stock { ID = 4,
                    AvailableQty = Qty,
                    Condition = "Very Fine",
                    Price = 250,
                });
            var controller = new StockController(mockRepository.Object);

            short testQty = 5;
            Stock testStock = new Stock
            {
                ID = 4,
                AvailableQty = testQty,
                Condition = "Fine",
                Price = 100,

            };

            StockDTO testStockDTO = new StockDTO(testStock);

            // Act  
            IHttpActionResult actionResult = controller.Put(4, testStockDTO);
            var contentResult = actionResult as OkNegotiatedContentResult<StockDTO>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(4, contentResult.Content.Id);
            Assert.AreEqual(testQty, contentResult.Content.AvailableQuantity);
            Assert.AreEqual("Fine", contentResult.Content.Condition);
            Assert.AreEqual(100, contentResult.Content.Price);

        }
        [TestMethod]
        public void DeleteStock()
        {
            int testID = 1;

            var mockRepository = new Mock<IStockRepository>();
            mockRepository.Setup(x => x.GetById(testID))
                .Returns(new Stock { ID = testID });

            var controller = new StockController(mockRepository.Object);

            IHttpActionResult actionResult = controller.Delete(testID);
            var contentResult = actionResult as OkNegotiatedContentResult<StockDTO>;

            Assert.IsNull(contentResult);

        }
    }
}
