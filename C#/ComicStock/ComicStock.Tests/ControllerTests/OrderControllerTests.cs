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
    [TestClass]
    public class OrderControllerTests
    {
        //[TestMethod]
        //public void GetReturnsOrderWithSameId()
        //{
        //    int testID = 1;

        //    var mockRepository = new Mock<IOrderRepository>();
        //    mockRepository.Setup(x => x.GetById(testID))
        //        .Returns(new Order { ID = testID });

        //    var controller = new OrderController(mockRepository.Object);

        //    IHttpActionResult actionResult = controller.Get(testID);
        //    var contentResult = actionResult as OkNegotiatedContentResult<OrderDTO>;

        //    Assert.IsNotNull(contentResult);
        //    Assert.IsNotNull(contentResult.Content);
        //    Assert.AreEqual(testID, contentResult.Content.Id);

        //}

        //[TestMethod]
        //public void PostReturnsOrderIDAddRepository()
        //{
        //    var mockRepository = new Mock<IOrderRepository>();
        //    var controller = new OrderController(mockRepository.Object);

        //    IHttpActionResult actionResult = controller.Post(new OrderDTO{ });
        //    var contentResult = actionResult as OkNegotiatedContentResult<int>;

        //    Assert.IsNotNull(contentResult);
        //    Assert.IsNotNull(contentResult.Content);

        //}

        //[TestMethod]
        //public void PutReturnsUpdatedCreatorDTO()
        //{

        //    var mockRepository = new Mock<IOrderRepository>();
        //    mockRepository.Setup(x => x.GetById(4))
        //        .Returns(new Order
        //        {
        //            ID = 4,
        //            Name = "Test Name",
        //            CountryOfResidence = "South Africa",
        //            EmailAddress = "test@testdomain.com",
        //            TaxReferenceNumber = null,
        //        });
        //    var controller = new OrderController(mockRepository.Object);

        //    //Int32 taxRefTest = 5;
        //    Creator testCreator = new Creator
        //    {
        //        ID = 4,
        //        Name = "Test Name Updated",
        //        CountryOfResidence = "South Africa Updated",
        //        EmailAddress = "testupdated@testdomain.com",
        //        TaxReferenceNumber = null,

        //    };

        //    OrderDTO testCreatorDTO = new OrderDTO(testCreator);

        //    // Act  
        //    IHttpActionResult actionResult = controller.Put(4, testCreatorDTO);
        //    var contentResult = actionResult as OkNegotiatedContentResult<OrderDTO>;

        //    Assert.IsNotNull(contentResult);
        //    Assert.IsNotNull(contentResult.Content);
        //    Assert.AreEqual(4, contentResult.Content.Id);
        //    Assert.AreEqual("Test Name Updated", contentResult.Content.Name);
        //    Assert.AreEqual("South Africa Updated", contentResult.Content.Country);
        //    Assert.AreEqual("testupdated@testdomain.com", contentResult.Content.Email);
        //    Assert.IsNull(contentResult.Content.TaxRef);

        //}
    }
}
