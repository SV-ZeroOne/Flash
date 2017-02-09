using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data
{
    internal class StockRepository : Repository<ComicContext, Stock>, IStockRepository
    {
        public StockRepository(ComicContext context) :base(context)
        {
        }

        public override void Delete(int id)
        {
            Stock s = GetById(id);
            s.AvailableQty = 0;
            Update(s);
        }

        public Stock GetById(int stockID)
        {
            var query = context.Stocks.FirstOrDefault(i => i.ID == stockID);
            return query;
        }
        public IEnumerable<Stock> GetPage(int page, int pageSize)
        {
            var stock = this.context.Stocks.AsQueryable().OrderBy(x => x.ID);
            return base.GetPage(stock, page, pageSize);
        }
    }
}
