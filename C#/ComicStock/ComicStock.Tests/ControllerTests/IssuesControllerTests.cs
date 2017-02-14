using System;
using ComicStock.Data.IRepositories;
using Moq;
using System.Collections.Generic;
using System.Linq;
using ComicStock.WebAPI.Controllers;
using ComicStock.Domain;
using System.Web.Http;
using System.Web.Http.Results;
using ComicStock.WebAPI.Models;
using System.Web.Http.Dependencies;
using ComicStock.Data.Repositories;

namespace ComicStock.Tests.ControllerTests
{
    using System;
    using NUnit.Framework;
    [TestFixture]
    public class IssuesControllerTests
    {
        private IIssueRepository issueRepository;
        private IssuesController issuesController;

        [SetUp]
        public void init()
        {
            issueRepository = new IssueRepository(new Data.ComicContext());
            issuesController = new IssuesController(issueRepository);
        }

        [Test]
        public void GetReturnsIssueWithSameId()
        {
            int testID = 3;
            IHttpActionResult actionResult = issuesController.Get(testID);
            var contentResult = actionResult as OkNegotiatedContentResult<IssueDTO>;

            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(testID, contentResult.Content.Id);

        }

        [Test]
        public void PostReturnsIssueIDAddRepository()
        {
            Issue testIssue =
            new Issue
            {
                
                Title = "issue test",
                PublicationDate = new DateTime(2011, 11, 11),
                Publisher = "test publisher",
                SeriesNumber = 11,
                Description = "issue test"
            };

            IssueDTO testIssueDTO = new IssueDTO(testIssue);

            IHttpActionResult actionResult = issuesController.Post(testIssueDTO);
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            int testID = contentResult.Content;
            Assert.IsNotNull(contentResult.Content);

            testIssueDTO.Id = testID;
            testIssueDTO.Title = "issue put";
            testIssueDTO.Publisher = "test publisher put";
            testIssueDTO.Description = "issue put";

            IHttpActionResult actionResultPut = issuesController.Put(testID, testIssueDTO);
            var contentResultPut = actionResultPut as OkNegotiatedContentResult<IssueDTO>;

            Assert.IsNotNull(contentResultPut.Content);
            Assert.AreEqual("issue put", contentResultPut.Content.Title);
            Assert.AreEqual("test publisher put", contentResultPut.Content.Publisher);
            Assert.AreEqual("issue put", contentResultPut.Content.Description);


            actionResult = issuesController.Delete(testID);
            Assert.IsNotNull(actionResult);

        }
        [Test]
        public void GetReturnsIssuesGetPage()
        {
            int page = 1;
            int size = 10;
            IHttpActionResult actionResult = issuesController.Get(page, size);
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<IssueDTO>>;
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(size, contentResult.Content.Count());

        }

        [Test]
        public void GetReturnsIssuesGetPageSearch()
        {
            int page = 1;
            int size = 10;
            String search = "1st Issue Special";
            IHttpActionResult actionResult = issuesController.Get(search, page, size);
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<IssueDTO>>;
            Assert.IsNotNull(contentResult);
            foreach (var item in contentResult.Content)
            {
                StringAssert.Contains(search, item.Title);
            }
            Assert.AreEqual(size, contentResult.Content.Count());

        }
    }
}
