using ComicStock.API.Exceptions;
using ComicStock.API.Services;
using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.API
{
    public class SupplierOrder : ISupplierOrder
    {
        IOrderRepository orderRepository;
        IIssueRepository issueRepository;
        ISupplierRepository supplierRepository;
        IStockRepository stockRepository;

        IThirdPartyPayment thirdPartyPayment;

        public SupplierOrder(IOrderRepository orderRepository, IIssueRepository issueRepository, 
            ISupplierRepository supplierRepository, IThirdPartyPayment thirdPartyPayment,
            IStockRepository stockRepository)
        {
            this.orderRepository = orderRepository;
            this.issueRepository = issueRepository;
            this.supplierRepository = supplierRepository;
            this.thirdPartyPayment = thirdPartyPayment;
            this.stockRepository = stockRepository;
        }

        private SupplierQuote validateIssue(Supplier supplier, SupplierQuote supplierQuote, Issue issue)
        {
            foreach (SupplierQuote i in issue.SupplierQuotes)
            {
                if (i.Supplier.ID == supplier.ID && supplierQuote.ID == i.ID)
                    return supplierQuote;
            }
            throw new IssueNotFoundException();
        }
        


        public Order placeOrder(Order order)
        {
            if (order.Supplier == null) throw new NullSupplierProvidedException();
            order.Supplier = supplierRepository.GetById(order.Supplier.ID);
            if (order.Supplier == null) throw new SupplierNotFoundException();
            order.SupplierID = order.Supplier.ID;
            order.OrderDate = DateTime.Now;

            if (order.IssueOrders != null || order.IssueOrders.Count() > 0)
            {
                foreach (IssueOrder i in order.IssueOrders)
                {
                    if (i.Issue == null) throw new NullIssueProvidedException();
                    if (i.SupplierQuote == null) throw new NullSupplierQuoteProvidedException();

                    i.Issue = issueRepository.GetById(i.Issue.ID);
                    if (order.IssueOrders == null) throw new IssueNotFoundException();
                    i.IssueID = i.Issue.ID;

                    i.SupplierQuote = i.Issue.SupplierQuotes.FirstOrDefault(x => x.ID == i.SupplierQuote.ID);
                    if (i.SupplierQuote == null) throw new NullSupplierQuoteProvidedException();
                    i.QuoteID = i.SupplierQuote.ID;

                    i.SupplierQuote = validateIssue(order.Supplier, i.SupplierQuote, i.Issue);
                    i.Order = order;
                }
            }
            else throw new NoIssuesProvidedException();
                
            thirdPartyPayment.makePayment(order);

            foreach (IssueOrder i in order.IssueOrders)
            {
                Stock s = i.Issue.Stocks.FirstOrDefault(x => x.Condition == "Very Fine");
                if (s == null) {
                    s = new Stock()
                    {
                        Issue = i.Issue,
                        IssueID = i.Issue.ID,
                        Condition = "Very Fine",
                        AvailableQty = i.QuantityOrdered,
                        Price = i.SupplierQuote.Price * (decimal)1.50
                    };
                    stockRepository.Add(s);
                }
                else
                {
                    s.AvailableQty += i.QuantityOrdered;
                    stockRepository.Update(s);
                }

            }

            orderRepository.Add(order);
            return order;
        }
    }
}
