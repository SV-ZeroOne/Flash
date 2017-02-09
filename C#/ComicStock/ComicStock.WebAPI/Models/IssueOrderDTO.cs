using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class IssueOrderDTO
    {
        public short QuantityOrdered { get; set; }
        public virtual IssueDTO Issue { get; set; }
        public virtual OrderDTO Order { get; set; }
        public virtual SupplierQuoteDTO SupplierQuote { get; set; }

        public IssueOrderDTO() { }

        public IssueOrderDTO(IssueOrder issueOrder)
        {
            this.QuantityOrdered = issueOrder.QuantityOrdered;
        }

        public IssueOrder CreateDomainObject(IssueOrder issueOrder)
        {
            issueOrder.QuantityOrdered = this.QuantityOrdered;
            return issueOrder;
        }
    }
}