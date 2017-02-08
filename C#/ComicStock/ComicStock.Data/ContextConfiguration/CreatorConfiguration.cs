using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.ContextConfiguration
{
    class CreatorConfiguration : EntityTypeConfiguration<Creator>
    {
        public CreatorConfiguration()
        {
            this.Property(e => e.Name)
                .IsUnicode(false);

            this.Property(e => e.CountryOfResidence)
                .IsUnicode(false);

            this.Property(e => e.EmailAddress)
                .IsUnicode(false);

            this.HasMany(e => e.ComicCreators)
                 .WithRequired(e => e.Creator)
                 .WillCascadeOnDelete(false);
        }
    }
}
