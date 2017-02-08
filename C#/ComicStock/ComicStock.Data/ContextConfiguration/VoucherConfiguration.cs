using ComicStock.Domain;
using System.Data.Entity.ModelConfiguration;

namespace ComicStock.Data.ContextConfiguration
{
    class VoucherConfiguration : EntityTypeConfiguration<Voucher>
    {
        public VoucherConfiguration()
        {
            this.Property(e => e.Code)
                .IsUnicode(false);
        }
    }
}
