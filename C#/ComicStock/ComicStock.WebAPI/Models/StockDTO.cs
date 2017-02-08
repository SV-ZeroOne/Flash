using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class StockDTO
    {
     

        public int Id { get;  set; }
        public int? issueID { get; set; }
        public string Condition { get; set; }
        public short? AvailableQuantity { get; set; }
        public decimal? Price { get; set; }

        public StockDTO() { }

        public StockDTO(Stock stock)
        {
            this.Id = stock.ID;
            this.issueID = stock.IssueID;
            this.Condition = stock.Condition;
            this.AvailableQuantity = stock.AvailableQty;
            this.Price = stock.Price;
        }


    }
}