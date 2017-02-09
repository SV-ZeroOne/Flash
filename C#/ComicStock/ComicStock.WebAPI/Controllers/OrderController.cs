using ComicStock.Data.IRepositories;
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
        public OrderController(IOrderRepository orderRepository)
        {
            this.orderRepository = orderRepository;
        }


       /* [ResponseType(typeof(IEnumerable<OrderDTO>))]
        public IHttpActionResult Get(int page, int pageSize)
        {
            var ordersDomain = orderRepository.GetPage(page, pageSize);

            IEnumerable<OrderDTO> orders = ordersDomain.Select(c => new OrderDTO(c));

            return Ok(orders);
        }

        public IHttpActionResult Get(int id)
        {
            OrderDTO dto = null;

            Order c = this.orderRepository.GetById(id);
            if (c != null)
            {
                dto = new OrderDTO(c);
            }
            if (dto != null)
            {
                return Ok(dto);
            }

            return new System.Web.Http.Results.ResponseMessageResult(
                Request.CreateErrorResponse(
                    (HttpStatusCode)204,
                    new HttpError("Creator Not Found")
                )
            );
        }

        [HttpPost]
        public IHttpActionResult Post([FromBody]OrderDTO creator)
        {

            Order newCreator = new Order();
            newCreator.ID = creator.Id;
            newCreator.CountryOfResidence = creator.Country;
            newCreator.EmailAddress = creator.Email;
            newCreator.TaxReferenceNumber = creator.TaxRef;
            newCreator.Name = creator.Name;

            this.orderRepository.Add(newCreator);

            return Ok(newCreator.ID);
        }

        // PUT: api/Creator/5
        public void Put(int id, [FromBody]string value)
        {
        }
        */
    }
}
