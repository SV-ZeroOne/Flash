using ComicStock.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class PageDTO<TEntity, TEntityDTO>
    {
        public IEnumerable<TEntityDTO> list { get; set; }
        public int pageNo { get; set; }
        public int count { get; set; }

        public PageDTO(Page<TEntity> pageObj)
        {
            pageNo = pageObj.pageNo;
            count = pageObj.count;
        }
    }
}