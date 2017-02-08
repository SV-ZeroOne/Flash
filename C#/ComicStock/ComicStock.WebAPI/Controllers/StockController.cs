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

namespace ComicStock.WebAPI.Controllers
{
    public class StockController : ApiController { 
    StockRepository stockRepository;


    [ResponseType(typeof(IQueryable<StockDTO>))]
    public IHttpActionResult Get()
    {
        stockRepository = new StockRepository();
            var stocks = from s in stockRepository.GetAll()
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
        stockRepository = new StockRepository();
            Stock s = stockRepository.GetById(id);
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

        
        public IHttpActionResult Post([FromBody]StockDTO stock)
        {
            return Ok();
        }

    }
}
