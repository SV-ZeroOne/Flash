using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class SupplierPaymentDTO
    {
        public int ID { get; set; }
        
        public decimal Total { get; set; }
        
        public DateTime? ProcessedDate { get; set; }

        public virtual OrderDTO Order { get; set; }
    }
}