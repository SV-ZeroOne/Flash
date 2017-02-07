using ComicStock.WebAPI.Controllers;
using ComicStock.WebAPI.Models;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Tests.Contollers
{
    [TestFixture]
    class IssueControllerTest
    {
        [Test]
        public void GetIssueTest()
        {
            var controller = new IssuesController();

            var issueDTO = new IssueDTO();// controller.Get(1);

            Assert.IsNotNull(issueDTO);
            Assert.AreEqual(1, issueDTO);


        }
    }
}
