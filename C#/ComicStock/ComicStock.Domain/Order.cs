namespace ComicStock.Domain
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
  

    public partial class Order
    {
        public Order()
        {
            SupplierPayments = new HashSet<SupplierPayment>();
            IssueOrders = new HashSet<IssueOrder>();
        }
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int ID { get; set; }

        [Column(TypeName = "datetime2")]
        public DateTime? OrderDate { get; set; }

        [Column(TypeName = "numeric")]
        public decimal? Total { get; set; }

        [StringLength(10)]
        public string ShipmentRef { get; set; }

        [Column(TypeName = "date")]
        public DateTime? ShipmentDate { get; set; }

        [StringLength(20)]
        public string DeliveryStatus { get; set; }

        public int? SupplierID { get; set; }

        public virtual ICollection<SupplierPayment> SupplierPayments { get;  }

        public virtual ICollection<IssueOrder> IssueOrders { get; set; }

        public virtual Supplier Supplier { get; set; }
    }
}
