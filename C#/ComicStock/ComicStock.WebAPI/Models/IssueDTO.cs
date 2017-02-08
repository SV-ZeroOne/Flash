﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class IssueDTO
    {

        public int Id { get; set; }
        public short? SeriesNumber { get; set; }

        public string Publisher { get; set; }
        public String Description { get; set; }

        public String Title { get; set; }

        public DateTime? PublicationDate { get; set; }

    //    public List<CreatorDTO> Creators { get; set; }

        public IEnumerable<StockDTO> Stock { get; set; }

    }

}