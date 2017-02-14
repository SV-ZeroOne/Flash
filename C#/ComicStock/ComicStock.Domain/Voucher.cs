namespace ComicStock.Domain
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;


    public partial class Voucher
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int ID { get; set; }

        public DateTime? RedeemDate { get; set; }

        [StringLength(100)]
        public string Code { get; set; }

        [Column(TypeName = "numeric")]
        public decimal Value { get; set; }


    }
}
