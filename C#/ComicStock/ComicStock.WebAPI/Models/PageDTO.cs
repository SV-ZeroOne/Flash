using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class PageDTO<TEntity>
    {
        public IEnumerable<TEntity> list { get; set; }
        public int pageNo { get; set; }
        public int count { get; set; }
    }
}