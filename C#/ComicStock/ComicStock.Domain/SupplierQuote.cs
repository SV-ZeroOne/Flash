namespace ComicStock.Domain
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
   

    public partial class SupplierQuote
    {
        public SupplierQuote()
        {
            IssueOrders = new HashSet<IssueOrder>();
        }

        [Key]
        public int QuoteID { get; set; }

        public int IssueID { get; set; }

        public int SupplierID { get; set; }

        [Column(TypeName = "numeric")]
        public decimal Price { get; set; }

        public DateTime EffectiveDate { get; set; }

        public virtual Issue Issue { get; set; }

        public virtual Supplier Supplier { get; set; }

        public virtual ICollection<IssueOrder> IssueOrders { get; set; }
    }
}
