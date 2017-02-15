using ComicStock.API;
using ComicStock.API.Exceptions;
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

        [Route("api/Order/count")]
        public IHttpActionResult Get()
        {
            return Ok(orderRepository.Count());
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
                dto.SupplierPayments = order.SupplierPayments.Select(sp => new SupplierPaymentDTO(sp));

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
            order.IssueOrders = orderDTO.IssueOrders.Select(io => io.CreateDomainObject(new IssueOrder()
            {
                SupplierQuote = io.SupplierQuote.CreateDomainObject(new SupplierQuote()),
                Issue = io.Issue.CreateDomainObject(new Issue())
            })).ToList();
            

            try
            {
                order = supplierOrder.placeOrder(order);
            }
            catch (HttpException httpEx)
            {
                return ResponseMessage(Request.CreateErrorResponse(
                httpEx.httpStatusCode,
                "Error placing the order: " + httpEx.Message)
                );
            }
            catch (Exception ex)
            {
                return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Error placing the order: " + ex.Message)
                );
            }

            OrderDTO dto = new OrderDTO(order);
            dto.IssueOrders = order.IssueOrders.Select(io => new IssueOrderDTO(io)
            {
                Issue = new IssueDTO(io.Issue),
                SupplierQuote = new SupplierQuoteDTO(io.SupplierQuote)
            });
            dto.Supplier = new SupplierDTO(order.Supplier);
            dto.SupplierPayments = order.SupplierPayments.Select(sp => new SupplierPaymentDTO(sp));

            return Ok(dto);
        }
        [HttpPut]
        public IHttpActionResult Put(int id, [FromBody]OrderDTO orderDTO)
        {
            Order order = orderRepository.GetById(id);
            if (order != null)
            {

        
                orderRepository.Update(orderDTO.CreateDomainObject(order));
                return Ok(orderDTO);
               //
                //order.IssueOrders = orderDTO.IssueOrders.Select(io => io.CreateDomainObject(new IssueOrder()
                //{
                //    SupplierQuote = io.SupplierQuote.CreateDomainObject(new SupplierQuote()),
                //    Issue = io.Issue.CreateDomainObject()
                //})).ToList();
            }
            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Not implemented exception")
                );
        }

        public IHttpActionResult Delete(int id)
        {
            Order supplier = orderRepository.GetById(id);
            if (supplier != null)
            {
                orderRepository.Delete(id);
                return Ok(id);
            }
            else
            {
                return BadRequest();
            }

        }
    }
}
