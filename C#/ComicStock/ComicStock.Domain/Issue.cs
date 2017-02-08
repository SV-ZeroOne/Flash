namespace ComicStock.Domain
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    public partial class Issue
    {
        public Issue()
        {
            ComicCreators = new HashSet<ComicCreator>();
            Stocks = new HashSet<Stock>();
            SupplierQuotes = new HashSet<SupplierQuote>();
            IssueOrders = new HashSet<IssueOrder>();
        }

        public int ID { get; set; }

        [StringLength(500)]
        public string Title { get; set; }

        [Column(TypeName = "date")]
        public DateTime? PublicationDate { get; set; }

        [StringLength(50)]
        public string Publisher { get; set; }

        public short? SeriesNumber { get; set; }

        public string Description { get; set; }

        public virtual ICollection<ComicCreator> ComicCreators { get;  }

        public virtual ICollection<Stock> Stocks { get; set; }

        public virtual ICollection<SupplierQuote> SupplierQuotes { get;  }

        public virtual ICollection<IssueOrder> IssueOrders { get; }
    }
}
