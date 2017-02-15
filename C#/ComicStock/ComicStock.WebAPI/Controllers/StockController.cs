using ComicStock.Data;
using ComicStock.Domain;
using ComicStock.WebAPI.Models;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using Newtonsoft;
using System.Web.Http;
using System.Web.Http.Description;
using Newtonsoft.Json;
using ComicStock.Data.Repositories;
using ComicStock.Data.IRepositories;

namespace ComicStock.WebAPI.Controllers
{
    public class StockController : ApiController
    {
        private readonly IStockRepository stockRepository;

        public StockController(IStockRepository stockRepository)
        {
            this.stockRepository = stockRepository;
        }

        [ResponseType(typeof(IQueryable<StockDTO>))]
        public IHttpActionResult Get(int page, int pageSize)
        {
            IEnumerable<StockDTO> issues = stockRepository.GetPage(page, pageSize).Select(i => new StockDTO(i)
            {
                Issue = new IssueDTO(i.Issue)
            });

            return Ok(issues);
        }

        public IHttpActionResult Get(int id)
        {
            Stock stock = this.stockRepository.GetById(id);
            if (stock != null)
            {
                StockDTO dto = new StockDTO(stock);
                dto.Issue = new IssueDTO(stock.Issue);
                return Ok(dto);
            }

            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Stock id: " + id + " not found")
                );
        }

        [Route("api/Stocks/search")]
        public IHttpActionResult Get(string search, int page, int pageSize)
        {
            IEnumerable<StockDTO> stocks = stockRepository.GetPage(search, page, pageSize).Select(s => new StockDTO(s));
            
            return Ok(stocks);
        }

        [Route("api/Stock/count")]
        public IHttpActionResult Get()
        {
            return Ok(stockRepository.Count());
        }

        [HttpPost]
        public IHttpActionResult Post([FromBody]StockDTO stockDTO)
        {
            Stock stock = stockDTO.CreateDomainObject(new Stock());

            this.stockRepository.Add(stock);

            return Ok(stock.ID);
        }
        [HttpPut]
        public IHttpActionResult Put(int id, [FromBody]StockDTO stockDTO)
        {
            Stock stock = stockRepository.GetById(id);
            if (stock != null)
            {
                stockRepository.Update(stockDTO.CreateDomainObject(stock));
                return Ok(stockDTO);
            }
            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Stock id: " + id + " not found")
                );
        }

        public IHttpActionResult Delete(int id)
        {
            Stock stock = stockRepository.GetById(id);
            if (stock != null)
            {
                stockRepository.Delete(id);
                return Ok(id);
            }
            else
            {
                return BadRequest();
            }

        }

    }
}
