using ComicStock.Data;
using ComicStock.Data.IRepositories;
using ComicStock.Data.Repositories;
using ComicStock.Domain;
using ComicStock.WebAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;

namespace ComicStock.WebAPI.Controllers
{
    public class IssuesController : ApiController
    {

        private readonly IIssueRepository issueRepository;

        public IssuesController(IIssueRepository issueRepository)
        {
            this.issueRepository = issueRepository;
        }
   
        [ResponseType(typeof(IEnumerable<IssueDTO>))]
        public IHttpActionResult Get(int page, int pageSize)
        {

            var issuesDomain = issueRepository.GetPage(page, pageSize);

            IEnumerable<IssueDTO> issues = issuesDomain.Select(i => new IssueDTO(i)
            {
                Stock = i.Stocks.Select(s => new StockDTO(s))
            });

            return Ok(issues);
        }


  
        public IHttpActionResult Get(int id)
        {
           
            Issue issue = issueRepository.GetById(id);
            IssueDTO dto = new IssueDTO(issue)
            {
                Stock = from x in issue.Stocks
                  select new StockDTO(x)
            };
            return Ok(dto);
        }

       

    }
}
