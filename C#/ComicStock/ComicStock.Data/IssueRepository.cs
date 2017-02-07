using ComicStock.Data;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class IssueRepository : IIssueRepository
    {

        //private List<IssueDTO> issues = new List<IssueDTO>();


        //public IEnumerable<IssueDTO> GetAll()
        //{
        //    loadJson();
        //    return issues;
        //}

        //public IEnumerable<IssueDTO> SearchByTitle(string title)
        //{
        //    loadJson();
        //    var query = issues.Where(i => i.Title.Contains(title));
        //    return query.ToList<IssueDTO>();

        //}

        //public IssueDTO GetById(int id)
        //{
        //    loadJson();
        //    var query = issues.Where(i => i.Id == id);
        //    return  query.Single();
        //}

        //public void loadJson()
        //{
        //    using (StreamReader r = new StreamReader(AppDomain.CurrentDomain.GetData("DataDirectory").ToString() + "\\Issues.json"))
        //    {
        //        string json = r.ReadToEnd();
        //        issues = JsonConvert.DeserializeObject<List<IssueDTO>>(json);
        //    }
        //}
    }
}