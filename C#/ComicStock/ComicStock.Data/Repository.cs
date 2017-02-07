using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data
{
    public abstract class Repository<TContext, TEntity> : IRepository<TEntity>
          where TEntity : class where TContext : ComicContext, new()
    {
        private TContext entities = new TContext();
        public TContext context
        {
            get { return entities; }
            set { entities = value; }
        }

        public virtual void Add(TEntity entity)
        {
            entities.Set<TEntity>().Add(entity);
        }

        public virtual void Delete(int key)
        {
           // entities.Set<TEntity>().Remove(entity);
        }

        public virtual IQueryable<TEntity> GetAll()
        {
            IQueryable<TEntity> query = entities.Set<TEntity>();
            return query;
        }

        public IQueryable<TEntity> GetById(int id)
        {
            // IQueryable<TEntity> query = entities.Set<TEntity>()Where
            return null; 
        }

        public void Update(TEntity entity)
        {
         //   entities.Entry(entity).State = System.Data.EntityState.Modified;
        }
    }
}
