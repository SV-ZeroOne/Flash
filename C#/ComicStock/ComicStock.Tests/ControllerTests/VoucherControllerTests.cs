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
    public class VoucherControllerTests
    {
        [TestMethod]
        public void GetReturnsVoucherWithSameId()
        {
            int testID = 1;

            var mockRepository = new Mock<IVoucherRepository>();
            mockRepository.Setup(x => x.GetById(testID))
                .Returns(new Voucher { ID = testID });

            var controller = new VoucherController(mockRepository.Object);

            IHttpActionResult actionResult = controller.Get(testID);
            var contentResult = actionResult as OkNegotiatedContentResult<VoucherDTO>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(testID, contentResult.Content.Id);

        }
    }
}
