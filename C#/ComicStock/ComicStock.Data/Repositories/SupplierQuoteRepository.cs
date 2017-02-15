using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.Repositories
{
    class SupplierQuoteRepository : Repository<ComicContext, SupplierQuote>, ISupplierQuoteRepository
    {
        public SupplierQuoteRepository(ComicContext context) : base(context)
        {
        }

        public override void Delete(int id)
        {
            var supplierQuote = context.SupplierQuotes.First(i => i.ID == id);
            context.SupplierQuotes.Remove(supplierQuote);
        }

        public IEnumerable<SupplierQuote> GetPage(int page, int pageSize)
        {
            var supplierQuotes = this.context.SupplierQuotes.AsQueryable().OrderBy(x => x.ID);
            return base.GetPage(supplierQuotes, page, pageSize);
        }

        public IEnumerable<SupplierQuote> GetPage(int id, int page, int pageSize)
        {
            var supplierQuotes = this.context.SupplierQuotes.AsQueryable().OrderBy(x => x.ID).Where(x => x.Supplier.ID == id);
            return base.GetPage(supplierQuotes, page, pageSize); 
        }

        public IEnumerable<SupplierQuote> GetPage(string search, int id, int page, int pageSize)
        {
            var suppliers = this.context.SupplierQuotes.AsQueryable()
                .OrderByDescending(x => x.ID)
                .Where(x => x.Issue.Title.Contains(search) && x.Supplier.ID == id); // || x.Issue.SeriesNumber == Int16.Parse(search)

            return base.GetPage(suppliers, page, pageSize);
        }

        public int Count(int id)
        {
            var suppliers = this.context.SupplierQuotes.AsQueryable()
                .OrderBy(x => x.ID)
                .Where(x => x.Supplier.ID == id);

            return base.Count(suppliers);
        }

        public override int Count()
        {
            var suppliers = this.context.SupplierQuotes.AsQueryable()
                .OrderBy(x => x.ID);

            return base.Count(suppliers);
        }

        public int Count(string search)
        {
            var issues = this.context.SupplierQuotes.AsQueryable()
                .OrderBy(x => x.ID)
                .Where(x => x.Issue.Title.Contains(search) || x.Issue.SeriesNumber == Int16.Parse(search));

            return base.Count(issues);
        }
    }
}
