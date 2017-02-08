using ComicStock.Domain;
using System.Data.Entity.ModelConfiguration;

namespace ComicStock.Data.ContextConfiguration
{
    class StockConfiguration : EntityTypeConfiguration<Stock>
    {
        public StockConfiguration()
        {
            this.Property(e => e.Condition)
                .IsUnicode(false);

            this.Property(e => e.Price)
                .HasPrecision(8, 2);

          
        }
    }
}

