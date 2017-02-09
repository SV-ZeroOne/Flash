using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity.ModelConfiguration;
using ComicStock.Domain;

namespace ComicStock.Data.ContextConfiguration
{
    class OrderConfiguration : EntityTypeConfiguration<Order>
    {
        public OrderConfiguration()
        {
            this.Property(e => e.Total)
                .HasPrecision(8, 2);

            this.Property(e => e.ShipmentRef)
                .IsFixedLength()
                .IsUnicode(false);

            this.Property(e => e.DeliveryStatus)
                   .IsUnicode(false);

            this.HasMany(e => e.IssueOrders)
                   .WithRequired(e => e.Order)
                   .WillCascadeOnDelete(false);

            this.HasMany(e => e.SupplierPayments)
                   .WithRequired(e => e.Order)
                   .WillCascadeOnDelete(false);
            
        }

    }
}

