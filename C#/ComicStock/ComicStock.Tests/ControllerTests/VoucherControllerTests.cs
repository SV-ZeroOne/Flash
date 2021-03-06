﻿using System;
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
    using System;
    using NUnit.Framework;
    using Data.Repositories;

    [TestFixture]
    public class VoucherControllerTests
    {
        private IVoucherRepository voucherRepository;
        private VoucherController voucherController;

        [SetUp]
        public void init()
        {
            voucherRepository = new VoucherRepository(new Data.ComicContext());
            voucherController = new VoucherController(voucherRepository);
        }

        [Test]
        public void GetReturnsVoucherWithSameId()
        {
            int testID = 2;
            IHttpActionResult actionResult = voucherController.Get(testID);
            var contentResult = actionResult as OkNegotiatedContentResult<VoucherDTO>;

            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(testID, contentResult.Content.Id);

        }

        [Test]
        public void PostReturnsVoucherIDAddRepository()
        {
            Voucher testVoucher =
            new Voucher
            {
                Code = "test Code",
                RedeemDate = new DateTime(2011, 11, 11),
                Value = 100,
            };

            VoucherDTO testVoucherDTO = new VoucherDTO(testVoucher);

            IHttpActionResult actionResult = voucherController.Post(testVoucherDTO);
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            int testID = contentResult.Content;
            Assert.IsNotNull(contentResult.Content);

            testVoucherDTO.Id = testID;
            testVoucherDTO.Code = "new code put";
            testVoucherDTO.Value = 150;

            IHttpActionResult actionResultPut = voucherController.Put(testID);
            var contentResultPut = actionResultPut as OkNegotiatedContentResult<int>;

            Assert.IsNotNull(contentResultPut.Content);


            actionResult = voucherController.Delete(testID);
            Assert.IsNotNull(actionResult);

        }
        [Test]
        public void GetReturnsVouchersGetPage()
        {
            int page = 1;
            int size = 1;
            IHttpActionResult actionResult = voucherController.Get(page, size);
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<VoucherDTO>>;
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(size, contentResult.Content.Count());

        }
 
    }
}
