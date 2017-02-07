using ComicStock.WebAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.WebAPI.Models
{
    interface IRepository<TKey, TEntity>
    {
        TEntity getById(TKey id);
        List<TEntity> getList();
        void create(TEntity entity);
        TEntity update(TEntity entity);
        void delete(TEntity entity);
            

    }
}
