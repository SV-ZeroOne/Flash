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
            var supplierQuotes = this.context.SupplierQuotes.AsQueryable()
                .OrderBy(x => x.Issue.Title).Where(x => x.Supplier.ID == id);
            return base.GetPage(supplierQuotes, page, pageSize); 
        }

        public IEnumerable<SupplierQuote> GetPage(string search, int id, int page, int pageSize)
        {
            var suppliers = this.context.SupplierQuotes.AsQueryable()
                .OrderBy(x => x.Issue.Title)
                .Where(x => (x.Issue.Title.Contains(search) || x.Issue.Publisher.Contains(search)) && x.Supplier.ID == id); // || x.Issue.SeriesNumber == Int16.Parse(search)

            return base.GetPage(suppliers, page, pageSize);
        }

        public Page<SupplierQuote> GetPaging(string search, int id, int page, int pageSize)
        {
            if (search == "")
            {
                return base.GetPaging(this.context.SupplierQuotes.AsQueryable()
                    .OrderBy(x => x.Issue.Title)
                    .Where(x => x.Supplier.ID == id),
                    page, pageSize);
            }
            return base.GetPaging(this.context.SupplierQuotes.AsQueryable()
                    .OrderBy(x => x.Issue.Title)
                    .Where(x => (x.Issue.Title.Contains(search) || x.Issue.Publisher.Contains(search)) && x.Supplier.ID == id),
                    page, pageSize);

        }

        public int Count(int id)
        {
            var suppliers = this.context.SupplierQuotes.AsQueryable()
                .OrderBy(x => x.ID)
                .Where(x => x.Supplier.ID == id);

            return base.Count(suppliers);
        }

        public int Count(int id, string search)
        {
            var issues = this.context.SupplierQuotes.AsQueryable()
                .OrderBy(x => x.ID)
                .Where(x => (x.Issue.Title.Contains(search) || x.Issue.Publisher.Contains(search)) && x.Supplier.ID == id);

            return base.Count(issues);
        }

        public SupplierQuote GetCheapest(int id)
        {
            SupplierQuote supplierQuote = this.context.SupplierQuotes.AsQueryable()
                .OrderBy(x => x.Price)
                .Where(x => x.Issue.ID == id).FirstOrDefault();

            return supplierQuote;
        }
    }
}
