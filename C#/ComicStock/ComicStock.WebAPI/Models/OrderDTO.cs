using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class OrderDTO
    {
        public int Id { get; set; }
        public DateTime? OrderDate { get; set; }
        public decimal? Total { get; set; }
        public string ShipmentRef { get; set; }
        public DateTime? ShipmentDate { get; set; }
        public string DeliveryStatus { get; set; }
        public SupplierDTO Supplier { get; set; }
        public IEnumerable<IssueOrderDTO> IssueOrders { get; set; }
        public IEnumerable<SupplierPaymentDTO> SupplierPayments { get; set; }

        private OrderDTO() { }

        public OrderDTO(Order order)
        {
            this.Id = order.ID;
            this.OrderDate = order.OrderDate;
            this.Total = order.Total;
            this.ShipmentRef = order.ShipmentRef;
            this.ShipmentDate = order.ShipmentDate;
            this.DeliveryStatus = order.DeliveryStatus;
        }

        public Order CreateDomainObject(Order order)
        {
            order.ID = this.Id;
            order.OrderDate = this.OrderDate;
            order.Total = this.Total;
            order.ShipmentRef = this.ShipmentRef;
            order.ShipmentDate = this.ShipmentDate;
            order.DeliveryStatus = this.DeliveryStatus;

            return order;
        }
    }
}