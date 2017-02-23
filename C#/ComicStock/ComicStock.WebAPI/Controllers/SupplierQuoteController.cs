using ComicStock.Data;
using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using ComicStock.WebAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace ComicStock.WebAPI.Controllers
{
    public class SupplierQuoteController : ApiController
    {
        private readonly ISupplierQuoteRepository supplierQuoteRepository;
        private readonly ISupplierRepository supplierRepository;

        public SupplierQuoteController(ISupplierQuoteRepository supplierQuoteRepository, ISupplierRepository supplierRepository)
        {
            this.supplierQuoteRepository = supplierQuoteRepository;
            this.supplierRepository = supplierRepository;
        }

        [Route("api/SupplierQuote")]
        public IHttpActionResult Get(int id, int page, int pageSize)
        {
            Supplier supplier = supplierRepository.GetById(id);
            IEnumerable<SupplierQuoteDTO> supplierQuotes = null;
            if (supplier != null)
            {
                    supplierQuotes = supplierQuoteRepository.GetPage(id, page, pageSize).Select(sq => new SupplierQuoteDTO(sq)
                    {
                        Qty = 0,
                        Cheapest = new SupplierQuoteDTO(supplierQuoteRepository.GetCheapest(sq.Issue.ID))
                        {
                            Supplier = new SupplierDTO(supplierQuoteRepository.GetCheapest(sq.Issue.ID).Supplier)
                        },
                        Issue = new IssueDTO(sq.Issue)
                        {
                            Stock = sq.Issue.Stocks.Select(s => new StockDTO(s)).Where(con => con.Condition == "Very Fine")
                        }

                    });
            }
            

            return Ok(supplierQuotes);
        }

        [Route("api/SupplierQuote/search")]
        public IHttpActionResult Get(int id, int page, int pageSize, string search = "")
        {
            Page<SupplierQuote> pageObj = supplierQuoteRepository.GetPaging(search, id, page, pageSize);
            PageDTO<SupplierQuote, SupplierQuoteDTO> res = new PageDTO<SupplierQuote, SupplierQuoteDTO>(pageObj)
            {
                list = pageObj.list.Select(sq => new SupplierQuoteDTO(sq)
                {
                    Qty = 0,
                    Cheapest = new SupplierQuoteDTO(supplierQuoteRepository.GetCheapest(sq.Issue.ID))
                    {
                        Supplier = new SupplierDTO(supplierQuoteRepository.GetCheapest(sq.Issue.ID).Supplier)
                    },
                    Issue = new IssueDTO(sq.Issue)
                    {
                        Stock = sq.Issue.Stocks.Select(s => new StockDTO(s)).Where(con => con.Condition == "Very Fine")
                    }
                })
            };

            return Ok(res);
        }

        [Route("api/SupplierQuote/count")]
        public IHttpActionResult Get(int id, string search = "")
        {
            if (search == "")
                return Ok(supplierQuoteRepository.Count(id));
            return Ok(supplierQuoteRepository.Count(id, search));
        }

        
    }
}