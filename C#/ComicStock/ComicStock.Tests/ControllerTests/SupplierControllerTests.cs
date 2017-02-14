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
    using Data;
    using System.Collections.Generic;
    using System.Linq;

    [TestFixture]
    public class SupplierControllerTests
    {
        private ISupplierRepository supplierRepository;
        private SupplierController supplierController;

        [SetUp]
        public void init()
        {
            supplierRepository = new SupplierRepository(new Data.ComicContext());
            supplierController = new SupplierController(supplierRepository);
        }

        [Test]
        public void GetReturnsSupplierWithSameId()
        {
            int testID = 3;
            IHttpActionResult actionResult = supplierController.Get(testID);
            var contentResult = actionResult as OkNegotiatedContentResult<SupplierDTO>;

            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(testID, contentResult.Content.Id);

        }

        [Test]
        public void PostReturnsSupplierIDAddRepository()
        {
            Supplier testSupplier =
            new Supplier
            {
                Name = "supplier test",
                City = "test city",
                ReferenceNumber = "test ref",
            };

            SupplierDTO testSupplierDTO = new SupplierDTO(testSupplier);

            IHttpActionResult actionResult = supplierController.Post(testSupplierDTO);
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            int testID = contentResult.Content;
            Assert.IsNotNull(contentResult.Content);

            testSupplierDTO.Id = testID;
            testSupplierDTO.Name = "supplier test put";
            testSupplierDTO.City = "test supplier put";
            testSupplierDTO.RefNum = "ref put";

            IHttpActionResult actionResultPut = supplierController.Put(testID, testSupplierDTO);
            var contentResultPut = actionResultPut as OkNegotiatedContentResult<SupplierDTO>;

            Assert.IsNotNull(contentResultPut.Content);
            Assert.AreEqual("supplier test put", contentResultPut.Content.Name);
            Assert.AreEqual("test supplier put", contentResultPut.Content.City);
            Assert.AreEqual("ref put", contentResultPut.Content.RefNum);


            actionResult = supplierController.Delete(testID);
            Assert.IsNotNull(actionResult);

        }
        [Test]
        public void GetReturnsSuppliersGetPage()
        {
            int page = 1;
            int size = 10;
            IHttpActionResult actionResult = supplierController.Get(page, size);
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<SupplierDTO>>;
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(size, contentResult.Content.Count());

        }

        [Test]
        public void GetReturnsSupplierGetPageSearch()
        {
            int page = 1;
            int size = 10;
            String search = "Unerazz";
            IHttpActionResult actionResult = supplierController.Get(search, page, size);
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<SupplierDTO>>;
            Assert.IsNotNull(contentResult);

            //StringAssert.Contains(search, contentResult.Content.First().RefNum);

            Assert.AreEqual("R9F3R5XWZ1R56KI", contentResult.Content.First().RefNum);
            Assert.AreEqual("Virginia Beach", contentResult.Content.First().City);

        }
    }
}
