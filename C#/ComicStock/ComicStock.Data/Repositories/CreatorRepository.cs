using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.Repositories
{
    internal class CreatorRepository : Repository<ComicContext, Creator>, ICreatorRepository
    {
        public CreatorRepository(ComicContext context): base(context)
        {

        }
        public IEnumerable<Creator> GetPage(int page, int pageSize)
        {
            var creators = this.context.Creators.AsQueryable().OrderBy(x => x.Name);
            return base.GetPage(creators, page, pageSize);
        }

        public Creator GetById(int creatorID)
        {
            var query = context.Creators.FirstOrDefault(c => c.ID == creatorID);
            return query;
        }

        public override void Delete(int id)
        {
            var creator = context.Creators.First(c => c.ID == id);
            context.Creators.Remove(creator);

        }

    }
}

