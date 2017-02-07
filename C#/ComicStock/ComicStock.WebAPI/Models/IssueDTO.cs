using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class IssueDTO
    {

        public int Id { get; set; }
        public int SeriesNumber { get; set; }

        public int Publisher { get; set; }
        public String Description { get; set; }

        public String Title { get; set; }

        public DateTime PublicationDate { get; set; }

        public List<CreatorDTO> Creators { get; set; }

        public List<StockDTO> Stock { get; set; }

    }

}