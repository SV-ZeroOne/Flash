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

        public StockController(StockRepository stockRepository)
        {
            this.stockRepository = stockRepository;
        }

    [ResponseType(typeof(IQueryable<StockDTO>))]
    public IHttpActionResult Get()
    {
     
            var stocks = from s in this.stockRepository.GetAll()
                         select new StockDTO()
                         {
                             Id = s.ID,
                             issueID = s.IssueID,
                             Condition = s.Condition,
                             Price = s.Price,
                             AvailableQuantity = s.AvailableQty
                         };
        return Ok(stocks);
    }

    public IHttpActionResult Get(int id)
    {
      
            Stock s = this.stockRepository.GetById(id);
            StockDTO dto = new StockDTO()
            {
                Id = s.ID,
                issueID =s.IssueID,
                Price =s.Price,
                Condition = s.Condition,
                AvailableQuantity =s.AvailableQty
            
            };
        return Ok(dto);
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

    }
}
