namespace ComicStock.Data
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class SupplierPayment
    {
        [Key]
        public int PaymentID { get; set; }

        public int? OrderID { get; set; }

        [Column(TypeName = "numeric")]
        public decimal Total { get; set; }

        [Column(TypeName = "date")]
        public DateTime? ProcessedDate { get; set; }

        public virtual Order Order { get; set; }
    }
}
