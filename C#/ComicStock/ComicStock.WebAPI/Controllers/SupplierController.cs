using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using ComicStock.WebAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;

namespace ComicStock.WebAPI.Controllers
{
    public class SupplierController : ApiController
    {
        private readonly ISupplierRepository supplierRepository;

        public SupplierController(ISupplierRepository supplierRepository)
        {
            this.supplierRepository = supplierRepository;
        }

        public IHttpActionResult Get(int id)
        {
            Supplier supplier = supplierRepository.GetById(id);
            if (supplier != null)
            {
                SupplierDTO dto = new SupplierDTO(supplier);
                return Ok(dto);
            }

            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Stock id: " + id + " not found")
                );
        }

        [ResponseType(typeof(IEnumerable<SupplierDTO>))]
        public IHttpActionResult Get(int page, int pageSize)
        {
            IEnumerable<SupplierDTO> suppliers = supplierRepository.GetPage(page, pageSize).Select(i => new SupplierDTO(i));

            return Ok(suppliers);
        }

        [Route("api/Suppliers/search")]
        public IHttpActionResult Get(string search, int page, int pageSize)
        {
            IEnumerable<SupplierDTO> suppliers = supplierRepository.GetPage(search, page, pageSize).Select(s => new SupplierDTO(s));

            return Ok(suppliers);
        }

        [HttpPost]
        public IHttpActionResult Post([FromBody]SupplierDTO supplierDTO)
        {
            Supplier supplier = supplierDTO.CreateDomainObject(new Supplier());

            this.supplierRepository.Add(supplier);

            return Ok(supplier.ID);
        }



        // PUT: api/Supplier/5
        public void Put(int id, [FromBody]string value)
        {
        }

    }
}
