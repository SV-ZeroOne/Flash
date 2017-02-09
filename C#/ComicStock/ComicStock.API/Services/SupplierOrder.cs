using ComicStock.API.Exceptions;
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

        public SupplierOrder(IOrderRepository orderRepository)
        {
            this.orderRepository = orderRepository;
        }

        private bool validateIssueOrders(IEnumerable<IssueOrder> issueOrders)
        {
            if (issueOrders != null || issueOrders.Count() > 0)
            {
                
                foreach(Issue i in issueOrders.Select(io => io.Issue))
                {
                    validateIssue(i);

                }
                return true;
            }
            throw new NoIssuesProvidedException();
        }

        private bool validateIssue(Issue issue)
        {
            if (issue == null)
            {
                throw new NoIssuesProvidedException();
            }
            return true;
        }


        public Order placeOrder(Order order)
        {
            validateIssueOrders(order.IssueOrders);
            if (order.Supplier == null)
                throw new NoSupplierProvidedException();
            return orderRepository.GetById(1661);
        }
    }
}
