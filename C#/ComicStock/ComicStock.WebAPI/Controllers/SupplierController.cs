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
            SupplierDTO dto = new SupplierDTO(supplier);
       
            return Ok(dto);
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

        // DELETE: api/Supplier/5
        public void Delete(int id)
        {
        }
    }
}
