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
        public override void Delete(int id)
        {
            var voucher = context.Vouchers.First(v => v.ID == id);
            context.Vouchers.Remove(voucher);
            context.SaveChanges();
        }

        public Voucher GetById(int voucherID)
        {
            var query = context.Vouchers.FirstOrDefault(v => v.ID == voucherID);
            return query;
        }

        public IEnumerable<Voucher> GetPage(int page, int pageSize)
        {
            var vouchers = this.context.Vouchers.AsQueryable().OrderBy(x => x.Code).Where(v => v.IsActivated == true);
            return base.GetPage(vouchers, page, pageSize);
        }





    }
}
