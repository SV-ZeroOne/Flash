using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ComicStock.Models;

namespace ComicStock.Models
{
    public class IssueDTO
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public int SeriesNumber { get; set; }
        public DateTime PublicationDate { get; set; }
        public string Publisher { get; set; }
        public List<CreatorDTO> Creators { get; set; }
        public List<StockDTO> Stock { get; set; }
    }
}

//{
//	"Id": 2,
//	"Title": "1st Issue Special",
//	"Description": null,
//	"SeriesNumber": 1,
//	"PublicationDate": "1975-04-01T00:00:00",
//	"Publisher": 0,
//	"Creators": [],
//	"Stock": [{
//		"Id": 1,
//		"Condition": 4,
//		"AvailableQuantity": 6,
//		"Price": 188.03
//	}, {
//		"Id": 24703,
//		"Condition": 6,
//		"AvailableQuantity": 34,
//		"Price": 175.35
//	}, {
//		"Id": 49405,
//		"Condition": 10,
//		"AvailableQuantity": 11,
//		"Price": 249.52
//	}, {
//		"Id": 74107,
//		"Condition": 13,
//		"AvailableQuantity": 9,
//		"Price": 226.46
//	}]
//}