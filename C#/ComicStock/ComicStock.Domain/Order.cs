namespace ComicStock.Data
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class Order
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Order()
        {
            SupplierPayments = new HashSet<SupplierPayment>();
            IssueOrders = new HashSet<IssueOrder>();
        }

        public int ID { get; set; }

        [Column(TypeName = "datetime2")]
        public DateTime? OrderDate { get; set; }

        public short? QtyOrdered { get; set; }

        [Column(TypeName = "numeric")]
        public decimal? Total { get; set; }

        [StringLength(10)]
        public string ShipmentRef { get; set; }

        [Column(TypeName = "date")]
        public DateTime? ShipmentDate { get; set; }

        [StringLength(20)]
        public string DeliveryStatus { get; set; }

        public int? SupplierID { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<SupplierPayment> SupplierPayments { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<IssueOrder> IssueOrders { get; set; }

        public virtual Supplier Supplier { get; set; }
    }
}
