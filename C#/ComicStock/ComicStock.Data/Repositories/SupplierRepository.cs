using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ComicStock.Domain;
using ComicStock.Data.IRepositories;

namespace ComicStock.Data
{
    public class SupplierRepository : Repository<ComicContext, Supplier>, ISupplierRepository
    {
        public SupplierRepository(ComicContext context): base(context)
        {

        }
        public IEnumerable<Supplier> GetPage(int page, int pageSize)
        {
            var suppliers = this.context.Suppliers.AsQueryable().OrderBy(x => x.Name);
            return base.GetPage(suppliers, page, pageSize);
        }
    }
}

