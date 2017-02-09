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
        public string Name { get; set; }
        public string City { get; set; }
        public string RefNum { get; set; }

        public SupplierDTO() { }

        public SupplierDTO(Supplier supplier)
        {
            this.Id = supplier.ID;
            this.Name = supplier.Name;
            this.City = supplier.City;
            this.RefNum = supplier.ReferenceNumber;
        }

        public Supplier CreateDomainObject(Supplier supplier)
        {
            supplier.ID = this.Id;
            supplier.Name = this.Name;
            supplier.City = this.City;
            supplier.ReferenceNumber = this.RefNum;
            return supplier;
        }

    }
}