using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.Repositories
{
    public class CreatorRepository : Repository<ComicContext, Creator>, ICreatorRepository
    {
    }
}

