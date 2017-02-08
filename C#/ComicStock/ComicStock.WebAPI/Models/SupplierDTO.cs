using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class SupplierDTO
    {
        public int Id { get; set; }
        public string name { get; set; }
        public string city { get; set; }
        public string refNum { get; set; }
        private SupplierDTO() { }

        public SupplierDTO(Supplier supplier)
        {
            this.Id = supplier.ID;
            this.name = supplier.Name;
            this.city = supplier.City;
            this.refNum = supplier.ReferenceNumber;
        }

    }
}