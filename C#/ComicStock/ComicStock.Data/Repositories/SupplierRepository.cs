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
            var suppliers = this.context.Suppliers.AsQueryable().OrderBy(x => x.Name).Where(x => x.IsActivated == true);
            return base.GetPage(suppliers, page, pageSize);
        }

        public IEnumerable<Supplier> GetPage(string search, int page, int pageSize)
        {
            var suppliers = this.context.Suppliers.AsQueryable()
                .OrderBy(x => x.Name)
                .Where(x => (x.Name.Contains(search)||x.City.Contains(search)) && x.IsActivated == true);

            return base.GetPage(suppliers, page, pageSize);
        }

        public Page<Supplier> GetPaging(string search, int page, int pageSize)
        {
            if (search == "")
            {
                return base.GetPaging(this.context.Suppliers.AsQueryable()
                    .OrderBy(x => x.Name)
                    .Where(x => x.IsActivated == true), 
                    page, pageSize);
            }
            return base.GetPaging(this.context.Suppliers.AsQueryable()
                    .OrderBy(x => x.Name)
                    .Where(x => (x.Name.Contains(search) || x.City.Contains(search)) && x.IsActivated == true),
                    page, pageSize);

        }

        public override int Count()
        {
            var suppliers = this.context.Suppliers.AsQueryable()
                .OrderBy(x => x.Name)
                .Where(x => x.IsActivated == true);

            return base.Count(suppliers);
        }

        public int Count(string search)
        {
            var suppliers = this.context.Suppliers.AsQueryable()
                .OrderBy(x => x.Name)
                .Where(x => (x.Name.Contains(search) || x.City.Contains(search)) && x.IsActivated == true);

            return base.Count(suppliers);
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

