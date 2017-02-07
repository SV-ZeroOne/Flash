using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Runtime.Remoting.Contexts;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data
{
    public class IssueRepository : Repository<ComicContext, Issue>, IIssueRepository
    {
        Issue IIssueRepository.GetById(int issueID)
        {
            var query = context.Issues.FirstOrDefault(i => i.ID == issueID);
            return query;
        }
    }
}
