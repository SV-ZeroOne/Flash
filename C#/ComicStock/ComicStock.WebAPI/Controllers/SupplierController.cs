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
            SupplierDTO dto = null;
            Supplier supplier = supplierRepository.GetById(id);
            if (supplier != null)
            {
                 dto = new SupplierDTO(supplier);
            }
            if (dto != null)
            {
                return Ok(dto);
            }

            return new System.Web.Http.Results.ResponseMessageResult(
                Request.CreateErrorResponse(
                    (HttpStatusCode)204,
                    new HttpError("Supplier Not Found")
                )
            );
        }

        [ResponseType(typeof(IEnumerable<SupplierDTO>))]
        public IHttpActionResult Get(int page, int pageSize)
        {
            var suppliersDomain = supplierRepository.GetPage(page, pageSize);
            IEnumerable<SupplierDTO> suppliers = suppliersDomain.Select(s => new SupplierDTO(s));
            return Ok(suppliers);
        }

        [HttpPost]
        public IHttpActionResult Post([FromBody]SupplierDTO supplier)
        {

            Supplier newSupplier = new Supplier();
            newSupplier.Name = supplier.name;
            newSupplier.City = supplier.city;
            newSupplier.ReferenceNumber = supplier.refNum;

            this.supplierRepository.Add(newSupplier);

            return Ok(newSupplier.ID);
        }



        // PUT: api/Supplier/5
        public void Put(int id, [FromBody]string value)
        {
        }

  
        public IHttpActionResult Delete(int id)
        {
            supplierRepository.Delete(id);
            return Ok();
        }
    }
}
