using ComicStock.Data.IRepositories;
using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Runtime.Remoting.Contexts;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.Repositories
{
    public class IssueRepository : Repository<ComicContext, Issue>, IIssueRepository
    {
        public Issue GetById(int issueID)
        {
            var query = context.Issues.FirstOrDefault(i => i.ID == issueID);
            return query;
        }

    }
}
