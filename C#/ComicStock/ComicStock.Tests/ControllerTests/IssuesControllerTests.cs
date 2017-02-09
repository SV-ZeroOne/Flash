using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ComicStock.Data.IRepositories;
using Moq;
using System.Collections.Generic;
using System.Linq;
using ComicStock.WebAPI.Controllers;
using ComicStock.Domain;
using System.Web.Http;
using System.Web.Http.Results;
using ComicStock.WebAPI.Models;

namespace ComicStock.Tests.ControllerTests
{
    [TestClass]
    public class IssuesControllerTests
    {
        [TestMethod]
        public void GetReturnsIssueWithSameId()
        {
            int testID = 1;

            var mockRepository = new Mock<IIssueRepository>();
            mockRepository.Setup(x => x.GetById(testID))
                .Returns(new Issue { ID = testID });

            var controller = new IssuesController(mockRepository.Object);

            IHttpActionResult actionResult = controller.Get(testID);
            var contentResult = actionResult as OkNegotiatedContentResult<IssueDTO>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(testID, contentResult.Content.Id);

        }

        [TestMethod]
        public void PostReturnsIssueIDAddRepository()
        {
            var mockRepository = new Mock<IIssueRepository>();
            var controller = new IssuesController(mockRepository.Object);

            IHttpActionResult actionResult = controller.Post(new IssueDTO {});
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);

        }

    }
}
