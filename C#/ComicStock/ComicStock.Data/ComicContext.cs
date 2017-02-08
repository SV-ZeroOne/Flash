namespace ComicStock.Data
{
    using System;
    using Domain;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;
    using System.Runtime.Remoting.Contexts;
    using ContextConfiguration;

    public partial class ComicContext : DbContext
    {
        public ComicContext()
            : base("name=ComicContext")
        {
        }

        public virtual DbSet<Creator> Creators { get; set; }
        public virtual DbSet<Issue> Issues { get; set; }
        public virtual DbSet<Order> Orders { get; set; }
        public virtual DbSet<Stock> Stocks { get; set; }
        public virtual DbSet<SupplierPayment> SupplierPayments { get; set; }
        public virtual DbSet<SupplierQuote> SupplierQuotes { get; set; }
        public virtual DbSet<Supplier> Suppliers { get; set; }
        public virtual DbSet<IssueOrder> IssueOrders { get; set; }
        public virtual DbSet<Voucher> Vouchers { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ComicCreatorConfiguration());

            modelBuilder.Configurations.Add(new IssueConfiguration());

            modelBuilder.Configurations.Add(new CreatorConfiguration());

            modelBuilder.Entity<Order>()
                .Property(e => e.Total)
                .HasPrecision(8, 2);

            modelBuilder.Entity<Order>()
                .Property(e => e.ShipmentRef)
                .IsFixedLength()
                .IsUnicode(false);

            modelBuilder.Entity<Order>()
                .Property(e => e.DeliveryStatus)
                .IsUnicode(false);

            modelBuilder.Entity<Order>()
                .HasMany(e => e.IssueOrders)
                .WithRequired(e => e.Order)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<Stock>()
                .Property(e => e.Condition)
                .IsUnicode(false);

            modelBuilder.Entity<Stock>()
                .Property(e => e.Price)
                .HasPrecision(8, 2);

            modelBuilder.Entity<SupplierPayment>()
                .Property(e => e.Total)
                .HasPrecision(8, 2);

            modelBuilder.Configurations.Add(new SupplierQuoteConfiguration());

            modelBuilder.Configurations.Add(new SupplierConfiguration());

            modelBuilder.Entity<Voucher>()
                .Property(e => e.Code)
                .IsUnicode(false);
        }
    }
}
