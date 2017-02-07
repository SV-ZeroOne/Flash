using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web.Http;
using ComicStock.Models;

namespace ComicStock.Controllers
{
    public class IssuesController : ApiController
    {
        private IList<IssueDTO> Issues;

        public IssuesController()
        {
            string filePath = AppDomain.CurrentDomain.GetData("DataDirectory").ToString() + "\\Issues.json";
            //this.Issues = new JavaScriptSerializer().Deserialize<IList<IssueDTO>>(File.ReadAllText(filePath));
        }

        public IHttpActionResult get(string search)
        {
            return Ok(Issues.Where(x => x.Title.Contains(search)));
        }
        
        public IHttpActionResult get(int id)
        {
            return Ok(Issues.FirstOrDefault(x => x.Id == id));
        }

        public IHttpActionResult get()
        {
            return Ok(Issues);
        }
    }
}
