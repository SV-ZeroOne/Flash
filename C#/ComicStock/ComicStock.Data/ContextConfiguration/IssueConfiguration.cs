using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.ContextConfiguration
{
    class IssueConfiguration : EntityTypeConfiguration<Issue>
    {
        public IssueConfiguration()
        {
            this.Property(e => e.Title)
                .IsUnicode(false);

            this.Property(e => e.Publisher)
                .IsUnicode(false);

            this.Property(e => e.Description)
                .IsUnicode(false);

            this.HasMany(e => e.Stocks)
                .WithRequired(e => e.Issue)
                .WillCascadeOnDelete(false);

            this.HasMany(e => e.ComicCreators)
                .WithRequired(e => e.Issue)
                .WillCascadeOnDelete(false);

            this.HasMany(e => e.SupplierQuotes)
                .WithRequired(e => e.Issue)
                .WillCascadeOnDelete(false);

            this.HasMany(e => e.IssueOrders)
                .WithRequired(e => e.Issue)
                .WillCascadeOnDelete(false);
        }
    }
}
