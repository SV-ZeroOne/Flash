using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class SupplierPaymentDTO
    {
        public int Id { get; set; }
        
        public decimal Total { get; set; }
        
        public DateTime? ProcessedDate { get; set; }

        public virtual OrderDTO Order { get; set; }

        public SupplierPaymentDTO(SupplierPayment supplierPayment)
        {
            this.Id = supplierPayment.ID;
            this.Total = supplierPayment.Total;
            this.ProcessedDate = supplierPayment.ProcessedDate;
        }

        public SupplierPayment CreateDomainObject(SupplierPayment supplierPayment)
        {
            supplierPayment.ID = this.Id;
            supplierPayment.Total = this.Total;
            supplierPayment.ProcessedDate = this.ProcessedDate;
            return supplierPayment;
        }
    }
}