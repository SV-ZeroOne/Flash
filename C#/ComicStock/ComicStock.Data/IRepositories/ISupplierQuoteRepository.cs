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
        IEnumerable<SupplierQuote> GetPage(string search, int page, int pageSize);
    }
}
