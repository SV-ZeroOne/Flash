using ComicStock.Data;
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
                dto.SupplierQuotes = supplier.SupplierQuotes.Select(sq => new SupplierQuoteDTO(sq)
                {
                });
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
            if (pageSize < 1 || page < 1)
                return BadRequest();

            IEnumerable<SupplierDTO> suppliers = supplierRepository.GetPage(page, pageSize).Select(i => new SupplierDTO(i));

            return Ok(suppliers);
        }

        [Route("api/Supplier/search")]
        public IHttpActionResult Get(int page, int pageSize, string search = "")
        {
            Page<Supplier> pageObj = supplierRepository.GetPaging(search, page, pageSize);
            PageDTO<Supplier, SupplierDTO> res = new PageDTO<Supplier, SupplierDTO>(pageObj)
            {
                list = pageObj.list.Select(l => new SupplierDTO(l))
            };

            return Ok(res);
        }

        [Route("api/Supplier/count")]
        public IHttpActionResult Get()
        {
            return Ok(supplierRepository.Count());
        }

        [HttpPost]
        public IHttpActionResult Post([FromBody]SupplierDTO supplierDTO)
        {
            Supplier supplier = supplierDTO.CreateDomainObject(new Supplier());
            supplier.IsActivated = true;

            this.supplierRepository.Add(supplier);

            return Ok(supplier.ID);
        }

        [Route("api/Supplier/deactivate")]
        public IHttpActionResult Put(int id)
        {
            Supplier supplier = supplierRepository.GetById(id);
            if (supplier != null)
            {
                supplier.IsActivated = false;
                supplierRepository.Update(supplier);
                return Ok();
            }
            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Issue id: " + id + " not found")
                );
        }

        [HttpPut]
        public IHttpActionResult Put(int id, [FromBody]SupplierDTO supplierDTO)
        {
            Supplier supplier = supplierRepository.GetById(id);
            if (supplier != null)
            {
                supplierRepository.Update(supplierDTO.CreateDomainObject(supplier));
                return Ok(supplierDTO);
            }
            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Supplier id: " + id + " not found")
                );
        }

        public IHttpActionResult Delete(int id)
        {
            Supplier supplier = supplierRepository.GetById(id);
            if (supplier != null)
            {
                supplierRepository.Delete(id);
                return Ok(id);
            }
            else
            {
                return BadRequest();
            }

        }

    }
}
