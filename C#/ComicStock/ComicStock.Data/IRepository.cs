using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data
{
    public interface IRepository<TEntity>
        where TEntity :class
    {

        //IQueryable<TEntity> GetAll();
        IEnumerable<TEntity> GetPage(int page, int pageSize);
        void Add(TEntity entity);
        void Update(TEntity entity);
        void Delete(int key);

    }
}
