using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.API
{
    public interface ISupplierOrder
    {
        Order placeOrder(Order order);
    }
}
