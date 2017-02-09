using ComicStock.Domain;
using ComicStock.Data.IRepositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.Repositories
{
    public class OrderRepository : Repository<ComicContext, Order>, IOrderRepository
    {

        public OrderRepository(ComicContext context) : base(context)
        {

        }
        public IEnumerable<Order> GetPage(int page, int pageSize)
        {
            var orders = this.context.Orders.AsQueryable().OrderBy(x => x.ID);
            return base.GetPage(orders, page, pageSize);
        }
        public Order GetById(int orderID)
        {
            var query = context.Orders.FirstOrDefault(i => i.ID == orderID);
            return query;
        }

        public override void Delete(int id)
        {
            var order = context.Orders.First(i => i.ID == id);
            context.Orders.Remove(order);
        }

    }
}
