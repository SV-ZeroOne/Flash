using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public abstract class Repository<TKey, TEntity> : IRepository<TKey, TEntity>
    {
        public void create(TEntity entity)
        {
            throw new NotImplementedException();
        }

        public void delete(TEntity entity)
        {
            throw new NotImplementedException();
        }

        public TEntity getById(TKey id)
        {
            throw new NotImplementedException();
        }

        public List<TEntity> getList()
        {
            throw new NotImplementedException();
        }

        public TEntity update(TEntity entity)
        {
            throw new NotImplementedException();
        }
    }
}