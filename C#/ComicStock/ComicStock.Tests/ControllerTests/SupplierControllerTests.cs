using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using Moq;
using ComicStock.WebAPI.Controllers;
using System.Web.Http;
using System.Web.Http.Results;
using ComicStock.WebAPI.Models;

namespace ComicStock.Tests.ControllerTests
{
    [TestClass]
    public class SupplierControllerTests
    {
        [TestMethod]
        public void GetReturnsSupplierWithSameId()
        {
            int testID = 1;

            var mockRepository = new Mock<ISupplierRepository>();
            mockRepository.Setup(x => x.GetById(testID))
                .Returns(new Supplier { ID = testID });

            var controller = new SupplierController(mockRepository.Object);

            IHttpActionResult actionResult = controller.Get(testID);
            var contentResult = actionResult as OkNegotiatedContentResult<SupplierDTO>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(testID, contentResult.Content.Id);

        }

        [TestMethod]
        public void PostReturnsSupplierIDAddRepository()
        {
            var mockRepository = new Mock<ISupplierRepository>();
            var controller = new SupplierController(mockRepository.Object);

            IHttpActionResult actionResult = controller.Post(new SupplierDTO { });
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);

        }
    }
}
