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
    public class CreatorControllerTests
    {
        [TestMethod]
        public void GetReturnsIssueWithSameId()
        {
            int testID = 1;

            var mockRepository = new Mock<ICreatorRepository>();
            mockRepository.Setup(x => x.GetById(testID))
                .Returns(new Creator { ID = testID });

            var controller = new CreatorController(mockRepository.Object);

            IHttpActionResult actionResult = controller.Get(testID);
            var contentResult = actionResult as OkNegotiatedContentResult<CreatorDTO>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(testID, contentResult.Content.Id);

        }

        [TestMethod]
        public void PostReturnsCreatorIDAddRepository()
        {
            var mockRepository = new Mock<ICreatorRepository>();
            var controller = new CreatorController(mockRepository.Object);

            IHttpActionResult actionResult = controller.Post(new CreatorDTO { });
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);

        }
    }
}
