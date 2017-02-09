using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.IRepositories
{
    public interface ISupplierRepository : IRepository<Supplier>
    {
        Supplier GetById(int id);
        IEnumerable<Supplier> GetPage(string search, int page, int pageSize);
    }

}
