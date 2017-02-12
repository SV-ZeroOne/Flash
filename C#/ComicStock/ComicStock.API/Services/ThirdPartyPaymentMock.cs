using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.API.Services
{
    public class ThirdPartyPaymentMock : IThirdPartyPayment
    {
        public Order makePayment(Order order)
        {
            SupplierPayment supplierPayment = new SupplierPayment();

            supplierPayment.ProcessedDate = new DateTime();
            supplierPayment.Total = order.IssueOrders.Sum(x => x.SupplierQuote.Price);
            supplierPayment.Order = order;

            order.SupplierPayments.Add(supplierPayment);
            order.DeliveryStatus = "Pending";
            order.ShipmentRef = "MockRefNo";
            return order;
        }
    }
}
