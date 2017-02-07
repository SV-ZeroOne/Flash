namespace ComicStock.Data
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;
    using Domain;

    public partial class ComicContext : DbContext
    {
        public ComicContext()
            : base("name=ComicContext")
        {
        }

        public virtual DbSet<ComicCreator> ComicCreators { get; set; }
        public virtual DbSet<Creator> Creators { get; set; }
        public virtual DbSet<Issue> Issues { get; set; }
        public virtual DbSet<Order> Orders { get; set; }
        public virtual DbSet<Stock> Stocks { get; set; }
        public virtual DbSet<SupplierPayment> SupplierPayments { get; set; }
        public virtual DbSet<SupplierQuote> SupplierQuotes { get; set; }
        public virtual DbSet<Supplier> Suppliers { get; set; }
        public virtual DbSet<IssueOrder> IssueOrders { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<ComicCreator>()
                .Property(e => e.CreatorRole)
                .IsUnicode(false);

            modelBuilder.Entity<Creator>()
                .Property(e => e.Name)
                .IsUnicode(false);

            modelBuilder.Entity<Creator>()
                .Property(e => e.CountryOfResidence)
                .IsUnicode(false);

            modelBuilder.Entity<Creator>()
                .Property(e => e.EmailAddress)
                .IsUnicode(false);

            modelBuilder.Entity<Creator>()
                .HasMany(e => e.ComicCreators)
                .WithRequired(e => e.Creator)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<Issue>()
                .Property(e => e.Title)
                .IsUnicode(false);

            modelBuilder.Entity<Issue>()
                .Property(e => e.Publisher)
                .IsUnicode(false);

            modelBuilder.Entity<Issue>()
                .Property(e => e.Description)
                .IsUnicode(false);

            modelBuilder.Entity<Issue>()
                .HasMany(e => e.ComicCreators)
                .WithRequired(e => e.Issue)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<Issue>()
                .HasMany(e => e.SupplierQuotes)
                .WithRequired(e => e.Issue)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<Issue>()
                .HasMany(e => e.IssueOrders)
                .WithRequired(e => e.Issue)
                .WillCascadeOnDelete(false);

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

            modelBuilder.Entity<SupplierQuote>()
                .Property(e => e.Price)
                .HasPrecision(8, 2);

            modelBuilder.Entity<SupplierQuote>()
                .HasMany(e => e.IssueOrders)
                .WithRequired(e => e.SupplierQuote)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<Supplier>()
                .Property(e => e.Name)
                .IsUnicode(false);

            modelBuilder.Entity<Supplier>()
                .Property(e => e.City)
                .IsUnicode(false);

            modelBuilder.Entity<Supplier>()
                .Property(e => e.ReferenceNumber)
                .IsUnicode(false);

            modelBuilder.Entity<Supplier>()
                .HasMany(e => e.SupplierQuotes)
                .WithRequired(e => e.Supplier)
                .WillCascadeOnDelete(false);
        }
    }
}
