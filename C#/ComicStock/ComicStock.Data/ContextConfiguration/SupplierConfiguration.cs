using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.ContextConfiguration
{
    class SupplierConfiguration : EntityTypeConfiguration<Supplier>
    {
        public SupplierConfiguration()
        {
            this.Property(e => e.Name)
                .IsUnicode(false);

            this.Property(e => e.City)
                .IsUnicode(false);

            this.Property(e => e.ReferenceNumber)
                .IsUnicode(false);

            this.HasMany(e => e.SupplierQuotes)
                .WithRequired(e => e.Supplier)
                .WillCascadeOnDelete(false);

            this.HasMany(e => e.Orders)
                .WithRequired(e => e.Supplier)
                .WillCascadeOnDelete(false);
        }
    }
}
