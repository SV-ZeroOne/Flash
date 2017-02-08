using ComicStock.Domain;
using System.Data.Entity.ModelConfiguration;
namespace ComicStock.Data
{
    class ComicCreatorConfiguration : EntityTypeConfiguration<ComicCreator>
    {
        public ComicCreatorConfiguration()
        {
            this.Property(e => e.CreatorRole)
                .IsUnicode(false);
        }
    }
}
