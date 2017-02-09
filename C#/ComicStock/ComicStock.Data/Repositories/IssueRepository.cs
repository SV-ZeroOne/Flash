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
    internal class IssueRepository : Repository<ComicContext, Issue>, IIssueRepository
    {
        public IssueRepository(ComicContext context): base(context)
        {

        }
        public IEnumerable<Issue> GetPage(int page, int pageSize)
        {
            var issues = this.context.Issues.AsQueryable().OrderBy(x => x.Title);
            return base.GetPage(issues, page, pageSize);
        }

        public IEnumerable<Issue> GetPage(string search, int page, int pageSize)
        {
            var issues = this.context.Issues.AsQueryable()
                .OrderBy(x => x.Title)
                .Where((x => x.Title.Contains(search) ||  x.Publisher.Contains(search)));
            return base.GetPage(issues, page, pageSize);
        }

        public Issue GetById(int issueID)
        {
            var query = context.Issues.FirstOrDefault(i => i.ID == issueID);
            return query;
        }

        public override void Delete(int id)
        {
            var issue = context.Issues.First(i => i.ID == id);
            context.Issues.Remove(issue);
        }

        

    }
}
