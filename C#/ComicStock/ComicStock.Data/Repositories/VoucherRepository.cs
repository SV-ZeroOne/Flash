using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.Repositories
{
    public class VoucherRepository : Repository<ComicContext, Voucher>, IVoucherRepository
    {
        public VoucherRepository(ComicContext context): base(context)
        {

        }
        public IEnumerable<Voucher> GetPage(int page, int pageSize)
        {
            var vouchers = this.context.Vouchers.AsQueryable().OrderBy(x => x.Code);
            return base.GetPage(vouchers, page, pageSize);
        }

    }
}
