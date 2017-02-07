namespace ComicStock.Domain
{
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;

    public partial class Creator
    {
        public Creator()
        {
            ComicCreators = new HashSet<ComicCreator>();
        }

        public int CreatorID { get; set; }

        [StringLength(50)]
        public string Name { get; set; }

        [StringLength(25)]
        public string CountryOfResidence { get; set; }

        [MaxLength(512)]
        public byte[] TaxReferenceNumber { get; set; }

        [StringLength(256)]
        public string EmailAddress { get; set; }

        public virtual ICollection<ComicCreator> ComicCreators { get; set; }
    }
}
