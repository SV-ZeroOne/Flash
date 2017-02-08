using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data
{
    public class StockRepository : Repository<ComicContext, Stock>, IStockRepository
    {
          public Stock GetById(int stockID)
        {
            var query = context.Stocks.FirstOrDefault(i => i.ID == stockID);
            return query;
        }
    }
}
