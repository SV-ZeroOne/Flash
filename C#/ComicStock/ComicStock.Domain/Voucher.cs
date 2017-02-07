namespace ComicStock.Data
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class Voucher
    {
        [Key]
        [Column(Order = 0)]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int ID { get; set; }

        [Key]
        [Column(Order = 1, TypeName = "date")]
        public DateTime RedeemDate { get; set; }

        [Key]
        [Column(Order = 2)]
        [StringLength(100)]
        public string Code { get; set; }
    }
}
