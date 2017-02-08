using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Newtonsoft.Json;

namespace ComicStock.WebAPI.Models
{
    public class StockMapper   
    {
        public StockMapper()
        {
            JsonConvert.SerializeObject<Stock>(json);
        }
    }
}