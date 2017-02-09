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

        public IEnumerable<Supplier> GetPage(string search, int page, int pageSize)
        {
            var suppliers = this.context.Suppliers.AsQueryable()
                .OrderBy(x => x.Name)
                .Where(x => x.Name.Contains(search));

            return base.GetPage(suppliers, page, pageSize);
        }

        public Supplier GetById(int supplierID)
        {
            var query = context.Suppliers.FirstOrDefault(s => s.ID == supplierID);
            return query;
        }

        public override void Delete(int id)
        {
            var supplier = context.Suppliers.First(s => s.ID == id);
            context.Suppliers.Remove(supplier);
        }
    }
}

