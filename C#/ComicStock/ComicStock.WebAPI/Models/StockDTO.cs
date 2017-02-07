using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class StockDTO
    {
        public int Id { get;  set; }
        public int Condition { get; set; }
   
        public int AvailableQuantity { get; set; }
        public double Price { get; set; }
    }
}