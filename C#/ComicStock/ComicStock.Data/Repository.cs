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

        public virtual int Count()
        {
            return context.Set<TEntity>().Count();
        }

        protected int Count(IQueryable<TEntity> entity)
        {
            return entity.Count();
        }

        public virtual void Create(TEntity entity)
        {
            context.Set<TEntity>().Attach(entity);
            context.SaveChanges();
        }

        public abstract void Delete(int id);
      

        protected IEnumerable<TEntity> GetPage(IQueryable<TEntity> entity, int page, int pageSize)
        {
            int count = entity.Count();

            return entity
                .Skip(pageSize * (page-1))
                .Take((page * pageSize) > count 
                        ? (pageSize * page) - (pageSize * page - count) 
                        : pageSize
                )
                .ToList();
        }

        protected Page<TEntity> GetPaging(IQueryable<TEntity> entity, int page, int pageSize)
        {
            int count = entity.Count();

            page = (page * pageSize) > count
                        ? (count / pageSize) + 1
                        : page;
            

            return new Page<TEntity>( entity
                .Skip(pageSize * (page-1))
                .Take((page * pageSize) > count
                        ? (pageSize * page) - (pageSize * page - count)
                        : pageSize
                )
                .ToList(), page, count);
        }

        public void Update(TEntity entity)
        {
            context.Entry(entity).State = EntityState.Modified;
            context.SaveChanges();
        }
    }
}
