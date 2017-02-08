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
using System.Web.Http.Results;

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
            IssueDTO dto =null;
            Issue issue = issueRepository.GetById(id);
            if (issue != null)
            {
                dto = new IssueDTO(issue)
                {
                    Stock = from x in issue.Stocks
                            select new StockDTO(x)
                };
            }
            if (issue != null)
            {
                return Ok(dto);
            }
            String message = "Issue Not Found";
            return new ResponseMessageResult(
                Request.CreateErrorResponse(
                    (HttpStatusCode)204, message
                )
            );
        }

        [HttpPost]
        public IHttpActionResult Post([FromBody]IssueDTO issue,StockDTO stock)
        {

            Issue newIssue = new Issue();
            newIssue.ID = issue.Id;
            newIssue.Title = issue.Title;
            newIssue.PublicationDate = issue.PublicationDate;
            newIssue.Publisher = issue.Publisher;
            newIssue.SeriesNumber = issue.SeriesNumber;
            newIssue.Description = issue.Description;

            this.issueRepository.Add(newIssue);

            return Ok(newIssue.ID);
        }

        public IHttpActionResult Delete(int id)
        {
            issueRepository.Delete(id);
            return Ok();
        }


    }
}
