using ComicStock.Data;
using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;

namespace ComicStock.WebAPI.Controllers
{
    public class StockController : ApiController { 
    StockRepository stockRepository;


    [ResponseType(typeof(IEnumerable<Stock>))]
    public IHttpActionResult Get()
    {
        stockRepository = new StockRepository();

        return Ok(stockRepository.GetAll());
    }



    public IHttpActionResult Get(int id)
    {
        stockRepository = new StockRepository();
        return Ok(stockRepository.GetById(id));
    }

}
}
