namespace ComicStock.Data
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;


    public class Page<TEntity>
    {
        public Page(IEnumerable<TEntity> list, int pageNo, int count)
        {
            this.list = list;
            this.pageNo = pageNo;
            this.count = count;
        }

        public IEnumerable<TEntity> list {get; set;}
        public int pageNo {get; set;}
        public int count {get; set;}
    }
}