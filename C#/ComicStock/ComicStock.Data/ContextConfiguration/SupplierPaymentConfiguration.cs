using ComicStock.Domain;
using System.Data.Entity.ModelConfiguration;

namespace ComicStock.Data.ContextConfiguration
{
    class SupplierPaymentConfiguration : EntityTypeConfiguration<SupplierPayment>
    {
        public SupplierPaymentConfiguration()
        {
            this.Property(e => e.Total)
               .HasPrecision(8, 2);
        }
    }
}
