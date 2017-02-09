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

        [TestMethod]
        public void PostReturnsVoucherIDAddRepository()
        {
            var mockRepository = new Mock<IVoucherRepository>();
            var controller = new VoucherController(mockRepository.Object);

            IHttpActionResult actionResult = controller.Post(new VoucherDTO { });
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);

        }

        [TestMethod]
        public void PutReturnsUpdatedVoucherDTO()
        {

            var mockRepository = new Mock<IVoucherRepository>();
            mockRepository.Setup(x => x.GetById(4))
                .Returns(new Voucher
                {
                    ID = 4,
                    Code = "Test Code",
                    RedeemDate = new DateTime(2000, 10, 23),
                    Value = 100,
                });
            var controller = new VoucherController(mockRepository.Object);

            Voucher testVoucher = new Voucher
            {
                ID = 4,
                Code = "Test Code Updated",
                RedeemDate = new DateTime(2009, 4, 13),
                Value = 200,

            };

            VoucherDTO testVoucherDTO = new VoucherDTO(testVoucher);

            // Act  
            IHttpActionResult actionResult = controller.Put(4, testVoucherDTO);
            var contentResult = actionResult as OkNegotiatedContentResult<VoucherDTO>;

            Assert.IsNotNull(contentResult);
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(4, contentResult.Content.Id);
            Assert.AreEqual("Test Code Updated", contentResult.Content.Code);
            Assert.AreEqual(new DateTime(2009, 4, 13), contentResult.Content.RedeemDate);
            Assert.AreEqual(200, contentResult.Content.Value);


        }
    }
}
