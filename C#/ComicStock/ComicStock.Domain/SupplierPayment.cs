namespace ComicStock.Data
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class SupplierPayment
    {
        public int ID { get; set; }

        public int? OrderID { get; set; }

        [Column(TypeName = "numeric")]
        public decimal Total { get; set; }

        [Column(TypeName = "date")]
        public DateTime? ProcessedDate { get; set; }

        public virtual Order Order { get; set; }
    }
}
