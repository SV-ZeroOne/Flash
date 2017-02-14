using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ComicStock.Data.IRepositories;
using Moq;
using ComicStock.Domain;
using ComicStock.WebAPI.Controllers;
using System.Web.Http;
using System.Web.Http.Results;
using ComicStock.WebAPI.Models;


namespace ComicStock.Tests.ControllerTests
{
    using System;
    using NUnit.Framework;
    using Data.Repositories;
    using Data;
    using API;
    using API.Services;
    using System.Collections.Generic;
    using System.Linq;

    [TestFixture]
    public class OrderControllerTests
    {

        private IOrderRepository orderRepository;
        private IIssueRepository issueRepository;
        private ISupplierRepository supplierRepository;
        private IThirdPartyPayment thirdPartyPayment;
        private IStockRepository stockRepository;

        private OrderController orderController;

        private SupplierOrder supplierOrder;

        [SetUp]
        public void init()
        {
            orderRepository = new OrderRepository(new Data.ComicContext());
            issueRepository = new IssueRepository(new Data.ComicContext());
            supplierRepository = new SupplierRepository(new Data.ComicContext());
            stockRepository = new StockRepository(new Data.ComicContext());
            thirdPartyPayment = new ThirdPartyPaymentMock();
            supplierOrder = new SupplierOrder(orderRepository, issueRepository, supplierRepository,thirdPartyPayment, stockRepository);
            orderController = new OrderController(orderRepository, supplierOrder);
        }

        [Test]
        public void GetReturnsOrderWithSameId()
        {
            int testID = 3;
            IHttpActionResult actionResult = orderController.Get(testID);
            var contentResult = actionResult as OkNegotiatedContentResult<OrderDTO>;

            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(testID, contentResult.Content.Id);

        }

        [Test]
        public void PostReturnsOrderIDAddRepository()
        {
            /*Order testOrder =
            new Order
            {
                OrderDate = null,
                Total = 100,
                ShipmentRef = null,
                ShipmentDate = null,
                DeliveryStatus = "test",
            };

            OrderDTO testOrderDTO = new OrderDTO(testOrder);

            IHttpActionResult actionResult = orderController.Post(testOrderDTO);
            var contentResult = actionResult as OkNegotiatedContentResult<int>;

            int testID = contentResult.Content;
            Assert.IsNotNull(contentResult.Content);

            testOrderDTO.Id = testID;
            testOrderDTO.Total = 150;
            testOrderDTO.ShipmentRef = "test ref put";
            testOrderDTO.DeliveryStatus = "del put";

            IHttpActionResult actionResultPut = orderController.Put(testID, testOrderDTO);
            var contentResultPut = actionResultPut as OkNegotiatedContentResult<OrderDTO>;

            Assert.IsNotNull(contentResultPut.Content);
            Assert.AreEqual(150, contentResultPut.Content.Total);
            Assert.AreEqual("test ref put", contentResultPut.Content.ShipmentRef);
            Assert.AreEqual("del put", contentResultPut.Content.DeliveryStatus);
            

            actionResult = orderController.Delete(testID);
            Assert.IsNotNull(actionResult);*/

        }
        [Test]
        public void GetReturnsOrderGetPage()
        {
            int page = 1;
            int size = 10;
            IHttpActionResult actionResult = orderController.Get(page, size);
            var contentResult = actionResult as OkNegotiatedContentResult<IEnumerable<OrderDTO>>;
            Assert.IsNotNull(contentResult.Content);
            Assert.AreEqual(size, contentResult.Content.Count());

        }

    }
}
