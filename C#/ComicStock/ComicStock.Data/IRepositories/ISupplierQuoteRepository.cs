using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.IRepositories
{
    public interface ISupplierQuoteRepository : IRepository<SupplierQuote>
    {
        IEnumerable<SupplierQuote> GetPage(string search, int id, int page, int pageSize);
        IEnumerable<SupplierQuote> GetPage(int id, int page, int pageSize);
        int Count(int id);
        int Count(int id, string search);
    }
}
