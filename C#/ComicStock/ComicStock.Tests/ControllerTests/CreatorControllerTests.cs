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
    using System;
    using NUnit.Framework;
    using Data.Repositories;
    using System.Collections.Generic;
    using System.Linq;

    [TestFixture]
    public class CreatorControllerTests
    {
        private ICreatorRepository creatorRepository;
        private CreatorController creatorController;

        [SetUp]
        public void init()
        {
            creatorRepository = new CreatorRepository(new Data.ComicContext());
            creatorController = new CreatorController(creatorRepository);
        }


        [TestMethod]
        public void GetReturnsCreatorWithSameId()
        {
            int testID = 3;
            IHttpActionResult actionResult = creatorController.Get(testID);
            var contentResult = actionResult as OkNegotiatedContentResult<CreatorDTO>;

            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(testID, contentResult.Content.Id);

        }

        [TestMethod]
        public void PostReturnsIssueIDAddRepository()
        {
            Creator testCreator =
            new Creator
            {
                ID = 4,
                Name = "Test Name",
                CountryOfResidence = "South Africa",
                EmailAddress = "test@testdomain.com",
                TaxReferenceNumber = null,
            };


            CreatorDTO testCreatorDTO = new CreatorDTO(testCreator);

            IHttpActionResult actionResult = creatorController.Post(testCreatorDTO);
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            int testID = contentResult.Content;
            Assert.IsNotNull(contentResult.Content);

            testCreatorDTO.Id = testID;
            testCreatorDTO.Name = "creator put";
            testCreatorDTO.Country = "test county put";
            testCreatorDTO.Email = "testput@testdomain.com";

            IHttpActionResult actionResultPut = creatorController.Put(testID, testCreatorDTO);
            var contentResultPut = actionResultPut as OkNegotiatedContentResult<CreatorDTO>;

            Assert.IsNotNull(contentResultPut.Content);
            Assert.AreEqual("creator put", contentResultPut.Content.Name);
            Assert.AreEqual("test county put", contentResultPut.Content.Country);
            Assert.AreEqual("testput@testdomain.com", contentResultPut.Content.Email);


            actionResult = creatorController.Delete(testID);
            Assert.IsNotNull(actionResult);

        }

        [Test]
        public void GetReturnsIssuesGetPage()
        {
            int page = 1;
            int size = 10;
            IHttpActionResult actionResult = creatorController.Get(page, size);
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<CreatorDTO>>;
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(size, contentResult.Content.Count());

        }

        [Test]
        public void GetReturnsCreatorGetPageSearch()
        {
            int page = 1;
            int size = 1;
            String search = "Nicole Franco";
            IHttpActionResult actionResult = creatorController.Get(search, page, size);
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<CreatorDTO>>;
            Assert.IsNotNull(contentResult);

            StringAssert.Contains(search, contentResult.Content.First().Name);
            Assert.AreEqual(size, contentResult.Content.Count());

        }





    }
}
