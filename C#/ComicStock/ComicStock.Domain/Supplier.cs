namespace ComicStock.Domain
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    

    public partial class Supplier
    {
        public Supplier()
        {
            Orders = new HashSet<Order>();
            SupplierQuotes = new HashSet<SupplierQuote>();
        }

        public int SupplierID { get; set; }

        [StringLength(50)]
        public string Name { get; set; }

        [StringLength(50)]
        public string City { get; set; }

        [StringLength(25)]
        public string ReferenceNumber { get; set; }

        public virtual ICollection<Order> Orders { get; set; }

        public virtual ICollection<SupplierQuote> SupplierQuotes { get; set; }
    }
}
