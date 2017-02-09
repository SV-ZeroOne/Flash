using ComicStock.API;
using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using ComicStock.WebAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ComicStock.WebAPI.Controllers
{
    public class OrderController : ApiController
    {
        private readonly IOrderRepository orderRepository;
        private readonly SupplierOrder supplierOrder;

        public OrderController(IOrderRepository orderRepository, SupplierOrder supplierOrder)
        {
            this.orderRepository = orderRepository;
            this.supplierOrder = supplierOrder;
        }
        
        public IHttpActionResult Get(int page, int pageSize)
        {
            IEnumerable<OrderDTO> orders = orderRepository.GetPage(page, pageSize).Select(s => new OrderDTO(s));

            return Ok(orders);
        }

        public IHttpActionResult Get(int id)
        {
            Order order = this.orderRepository.GetById(id);
            if (order != null)
            {
                OrderDTO dto = new OrderDTO(order);
                dto.IssueOrders = order.IssueOrders.Select(io => new IssueOrderDTO(io) {
                    Issue = new IssueDTO(io.Issue),
                    SupplierQuote = new SupplierQuoteDTO(io.SupplierQuote)
                });
                dto.Supplier = new SupplierDTO(order.Supplier);

                return Ok(dto);
            }

            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Stock id: " + id + " not found")
                );
        }

        [HttpPost]
        public IHttpActionResult Post([FromBody]OrderDTO orderDTO)
        {
            Order order = orderDTO.CreateDomainObject(new Order());
            order.Supplier = orderDTO.Supplier.CreateDomainObject(new Supplier());
            order.IssueOrders = (ICollection<IssueOrder>)orderDTO.IssueOrders.Select(io => io.CreateDomainObject(new IssueOrder() {
                SupplierQuote = io.SupplierQuote.CreateDomainObject(new SupplierQuote()),
                Issue = io.Issue.CreateDomainObject(new Issue())
            }));

            order = supplierOrder.placeOrder(order);

            return Ok(order.ID);
        }
        [HttpPut]
        public IHttpActionResult Put(int id, [FromBody]OrderDTO orderDTO)
        {
            Order order = orderRepository.GetById(id);

            
            if (order != null)
            {
                order = orderDTO.CreateDomainObject(order);
                order.Supplier = orderDTO.Supplier.CreateDomainObject(order.Supplier);
                order.IssueOrders = (ICollection<IssueOrder>)orderDTO.IssueOrders.Select(io => io.CreateDomainObject(new IssueOrder()
                {
                    SupplierQuote = io.SupplierQuote.CreateDomainObject(new SupplierQuote()),
                    Issue = io.Issue.CreateDomainObject(new Issue())
                }));
            }
            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Stock id: " + id + " not found")
                );
        }

        //public IHttpActionResult Delete(int id)
        //{
        //    orderRepository.Delete(id);
        //    return Ok();
        //}
    }
}
