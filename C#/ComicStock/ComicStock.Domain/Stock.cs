namespace ComicStock.Domain
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;


    [Table("Stock")]
    public partial class Stock
    {
        public int ID { get; set; }

        public int? IssueID { get; set; }

        [StringLength(10)]
        public string Condition { get; set; }

        public short? AvailableQty { get; set; }

        [Column(TypeName = "numeric")]
        public decimal? Price { get; set; }

        public virtual Issue Issue { get; set; }
    }
}
