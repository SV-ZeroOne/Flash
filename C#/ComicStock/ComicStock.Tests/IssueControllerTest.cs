using ComicStock.WebAPI.Controllers;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;
using System.Web.Http.Description;

namespace ComicStock.Tests.Contollers
{
    [TestFixture]
    class IssueControllerTest
    {
        [Test]
        public void GetIssueTest()
        {
            var controller = new IssuesController();

            var issueDTO = controller.Get(1);

            Assert.IsNotNull(IssueDTO);
            Assert.AreEqual(1, issueDTO);


        }
    }
}
