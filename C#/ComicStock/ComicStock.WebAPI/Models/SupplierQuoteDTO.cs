using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class SupplierQuoteDTO
    {
        public int Id { get; set; }
        
        public decimal Price { get; set; }

        public DateTime EffectiveDate { get; set; }

        public virtual IssueDTO Issue { get; set; }

        public virtual SupplierDTO Supplier { get; set; }

        public virtual ICollection<IssueOrderDTO> IssueOrders { get; set; }

        public SupplierQuoteDTO() { }

        public SupplierQuoteDTO(SupplierQuote supplierQuote)
        {
            this.Id = supplierQuote.ID;
            this.Price = supplierQuote.Price;
            this.EffectiveDate = supplierQuote.EffectiveDate;
        }

        public SupplierQuote CreateDomainObject(SupplierQuote supplierQuote)
        {
            supplierQuote.ID = this.Id;
            supplierQuote.Price = this.Price;
            supplierQuote.EffectiveDate = this.EffectiveDate;
            return supplierQuote;
        }

    }
}