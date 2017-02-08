using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.ContextConfiguration
{
    class SupplierQuoteConfiguration : EntityTypeConfiguration<SupplierQuote>
    {
        public SupplierQuoteConfiguration()
        {
            this.Property(e => e.Price)
                .HasPrecision(8, 2);

            this.HasMany(e => e.IssueOrders)
                .WithRequired(e => e.SupplierQuote)
                .HasForeignKey(e => e.QuoteID)
                .WillCascadeOnDelete(false);
        }
    }
}
