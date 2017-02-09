using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ComicStock.Data.IRepositories;
using Moq;
using ComicStock.Domain;
using ComicStock.WebAPI.Controllers;
using System.Web.Http;
using System.Web.Http.Results;
using ComicStock.WebAPI.Models;

namespace ComicStock.Tests.ControllerTests
{
    [TestClass]
    public class OrderControllerTests
    {
        [TestMethod]
        public void GetReturnsOrderWithSameId()
        {
            // Arrange
            /*var mockRepository = new Mock<IOrderRepository>();
            mockRepository.Setup(x => x.GetById(3))
                .Returns(new Order { ID = 3 });

            var controller = new OrderController(mockRepository.Object);

            // Act
            IHttpActionResult actionResult = controller.Get(3);
            var contentResult = actionResult as OkNegotiatedContentResult<OrderDTO>;

            // Assert
            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(3, contentResult.Content.Id);*/

        }

        /*[TestMethod]
        public void PostReturnsOrderIDAddRepository()
        {
            var mockRepository = new Mock<IOrderRepository>();
            var controller = new OrderController(mockRepository.Object);

            IHttpActionResult actionResult = controller.Post(new OrderDTO { });
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);

        }*/
    }
}
