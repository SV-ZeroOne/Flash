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
    public class StockController : ApiController { 
    private readonly IStockRepository stockRepository;

        public StockController(IStockRepository stockRepository)
        {
            this.stockRepository = stockRepository;
        }

    [ResponseType(typeof(IQueryable<StockDTO>))]
    public IHttpActionResult Get(int page, int pageSize)
    {

            var stocks = from s in this.stockRepository.GetPage(page, pageSize)
                         select new StockDTO(s);
        return Ok(stocks);
    }

    public IHttpActionResult Get(int id)
    {
            StockDTO dto = null;
            Stock s = this.stockRepository.GetById(id);
            if (s != null)
            {
                dto = new StockDTO(s);
            }
            if (dto != null)
            {
                return Ok(dto);
            }

            return new System.Web.Http.Results.ResponseMessageResult(
                Request.CreateErrorResponse(
                    (HttpStatusCode)204,
                    new HttpError("Stock Not Found")
                )
            );
        }

        [HttpPost]
        public IHttpActionResult Post([FromBody]StockDTO stock)
        {
                     
            Stock newStock = new Stock();
            newStock.Condition = stock.Condition;
            newStock.IssueID = stock.issueID;
            newStock.Price = stock.Price;
            newStock.AvailableQty = stock.AvailableQuantity;
           
            this.stockRepository.Add(newStock);           

            return Ok(newStock.ID);
        }

        [HttpPut]
        public IHttpActionResult Put(int stockID, int availableQuantity, decimal price,string Condition)
        {

            this.stockRepository.GetById(stockID);
            var stock = stockRepository.GetById(stockID);
            StockDTO dto = new StockDTO(stock);
            if (availableQuantity != null)
            {

            }
            return Ok();

        }

        public IHttpActionResult Delete(int id)
        {
            stockRepository.Delete(id);
            return Ok();
        }

    }
}
