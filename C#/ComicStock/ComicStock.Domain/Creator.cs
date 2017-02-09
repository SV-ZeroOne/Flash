namespace ComicStock.Domain
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    

    public partial class Creator
    {
        public Creator()
        {
            ComicCreators = new HashSet<ComicCreator>();
        }
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int ID { get; set; }

        [StringLength(50)]
        public string Name { get; set; }

        [StringLength(25)]
        public string CountryOfResidence { get; set; }

        [MaxLength(512)]
        public byte[] TaxReferenceNumber { get; set; }

        [StringLength(256)]
        public string EmailAddress { get; set; }

        public virtual ICollection<ComicCreator> ComicCreators { get; }
    }
}
