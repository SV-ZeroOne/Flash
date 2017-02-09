using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.IRepositories
{
    public interface ICreatorRepository : IRepository<Creator>
    {
        Creator GetById(int creatorID);
        IEnumerable<Creator> GetPage(string search, int page, int pageSize);
    }
    
}
