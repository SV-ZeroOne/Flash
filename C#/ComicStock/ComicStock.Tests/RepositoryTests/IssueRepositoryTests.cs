using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ComicStock.Domain;

namespace ComicStock.Tests
{
    [TestClass]
    public class IssueRepositoryTests
    {
       /* [TestMethod]
        public void GetPagePagination()   //Normal page 
        {
            int page;
            int pageSize;
        }
        public void GetPageSearch()   //Search page
        {
        }
        public void GetById()
        {

            var issueTest = new Issue();
            issueTest.ID = 1;
            issueTest.Title = "testTitle";
            issueTest.PublicationDate = ;
            issueTest.Publisher = "testPublisher";
            issueTest.SeriesNumber = 2;
            issueTest.Description = "testDescription";




        }
        public void Delete()
        {
        }
        */
    }
}

//public IEnumerable<Issue> GetPage(int page, int pageSize)
//{
//    var issues = this.context.Issues.AsQueryable().OrderBy(x => x.Title);
//    return base.GetPage(issues, page, pageSize);
//}

//public IEnumerable<Issue> GetPage(string search, int page, int pageSize)
//{
//    var issues = this.context.Issues.AsQueryable()
//        .OrderBy(x => x.Title)
//        .Where((x => x.Title.Contains(search) || x.Publisher.Contains(search)));
//    return base.GetPage(issues, page, pageSize);
//}

//public Issue GetById(int issueID)
//{
//    var query = context.Issues.FirstOrDefault(i => i.ID == issueID);
//    return query;
//}

//public override void Delete(int id)
//{
//    var issue = context.Issues.First(i => i.ID == id);
//    context.Issues.Remove(issue);
//}
