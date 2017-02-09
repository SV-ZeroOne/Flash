using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class CreatorDTO
    {

        public int Id { get; set; }
        public string Name { get; set; }
        public string Country { get; set; }
        public byte[] TaxRef { get; set; }
        public string Email { get; set; }

        public CreatorDTO() { }

        public CreatorDTO(Creator creator)
        {
            this.Id = creator.ID;
            this.Name = creator.Name;
            this.Country = creator.CountryOfResidence;
            this.Email = creator.EmailAddress;
            this.TaxRef = creator.TaxReferenceNumber;
        }

        public Creator CreateDomainObject()
        {
            Creator creator = new Creator();
            creator.Name = this.Name;
            creator.CountryOfResidence = this.Country;
            creator.TaxReferenceNumber = this.TaxRef;
            creator.EmailAddress = this.Email;
            return creator;
        }
    }
}