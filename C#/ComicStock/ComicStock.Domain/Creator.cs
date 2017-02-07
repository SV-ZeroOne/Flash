namespace ComicStock.Data
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class Creator
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Creator()
        {
            ComicCreators = new HashSet<ComicCreator>();
        }

        public int ID { get; set; }

        [StringLength(50)]
        public string Name { get; set; }

        [StringLength(25)]
        public string CountryOfResidence { get; set; }

        [MaxLength(512)]
        public byte[] TaxReferenceNumber { get; set; }

        [StringLength(256)]
        public string EmailAddress { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<ComicCreator> ComicCreators { get; set; }
    }
}
