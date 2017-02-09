using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data
{
    public abstract class Repository<TContext, TEntity>
          where TEntity : class
    {
        protected Repository(ComicContext context) {
            this.context = context;
        }
        protected ComicContext context;
  

        public virtual void Add(TEntity entity)
        {
            context.Set<TEntity>().Add(entity);
            context.SaveChanges();
        }

        public abstract void Delete(int id);
      

        protected IEnumerable<TEntity> GetPage(IQueryable<TEntity> entity, int page, int pageSize)
        {
            return entity
                .Skip(pageSize * page)
                .Take(pageSize)
                .ToList();
        }

        public void Update(TEntity entity)
        {
            context.Entry(entity).State = EntityState.Modified;
            context.SaveChanges();
        }
    }
}
