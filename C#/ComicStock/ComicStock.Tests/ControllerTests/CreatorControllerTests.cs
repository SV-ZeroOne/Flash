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

        [TestMethod]
        public void PutReturnsUpdatedCreatorDTO()
        {

            var mockRepository = new Mock<ICreatorRepository>();
            mockRepository.Setup(x => x.GetById(4))
                .Returns(new Creator
                {
                    ID = 4,
                    Name = "Test Name",
                    CountryOfResidence = "South Africa",
                    EmailAddress = "test@testdomain.com",
                    TaxReferenceNumber = null,
                });
            var controller = new CreatorController(mockRepository.Object);

            //Int32 taxRefTest = 5;
            Creator testCreator = new Creator
            {
                ID = 4,
                Name = "Test Name Updated",
                CountryOfResidence = "South Africa Updated",
                EmailAddress = "testupdated@testdomain.com",
                TaxReferenceNumber = null,

            };

            CreatorDTO testCreatorDTO = new CreatorDTO(testCreator);

            // Act  
            IHttpActionResult actionResult = controller.Put(4, testCreatorDTO);
            var contentResult = actionResult as OkNegotiatedContentResult<CreatorDTO>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(4, contentResult.Content.Id);
            Assert.AreEqual("Test Name Updated", contentResult.Content.Name);
            Assert.AreEqual("South Africa Updated", contentResult.Content.Country);
            Assert.AreEqual("testupdated@testdomain.com", contentResult.Content.Email);
            Assert.IsNull(contentResult.Content.TaxRef);

        }
        
    }
}
