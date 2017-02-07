namespace ComicStock.Domain
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    public partial class Issue
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
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

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<ComicCreator> ComicCreators { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Stock> Stocks { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<SupplierQuote> SupplierQuotes { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<IssueOrder> IssueOrders { get; set; }
    }
}
