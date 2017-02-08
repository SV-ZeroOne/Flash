namespace ComicStock.Domain
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
   

    public partial class IssueOrder
    {
        [Key]
        [Column(Order = 0)]
        public int IssueID { get; set; }

        [Key]
        [Column(Order = 1)]
        public int OrderID { get; set; }

        [Key]
        [Column(Order = 2)]
        public int QuoteID { get; set; }

        [Key]
        [Column(Order = 3)]
        public short QuantityOrdered { get; set; }

        public virtual Issue Issue { get; set; }

        public virtual Order Order { get; set; }

        public virtual SupplierQuote SupplierQuote { get; set; }
    }
}
