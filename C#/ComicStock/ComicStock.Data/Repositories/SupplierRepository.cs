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

    }
}

