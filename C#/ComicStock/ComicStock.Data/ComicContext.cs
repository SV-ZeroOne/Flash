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

            modelBuilder.Configurations.Add(new OrderConfiguration());

            modelBuilder.Configurations.Add(new StockConfiguration());



            modelBuilder.Configurations.Add(new SupplierPaymentConfiguration());

            modelBuilder.Configurations.Add(new SupplierQuoteConfiguration());

            modelBuilder.Configurations.Add(new SupplierConfiguration());

            modelBuilder.Configurations.Add(new VoucherConfiguration());
        }
    }
}
