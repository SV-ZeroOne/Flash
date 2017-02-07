using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.Models
{
    public class StockDTO
    {
        public int Id { get; set; }
        public int Condition { get; set; }
        public int AvailableQuantity { get; set; }
        public Decimal Price { get; set; }
    }
}

//		"Id": 1,
//		"Condition": 4,
//		"AvailableQuantity": 6,
//		"Price": 188.03
//	}