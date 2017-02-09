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
            IEnumerable<IssueDTO> issues = issueRepository.GetPage(page, pageSize).Select(i => new IssueDTO(i)
            {
                Stock = i.Stocks.Select(s => new StockDTO(s))
            });

            return Ok(issues);
        }

        public IHttpActionResult Get(int id)
        {
            Issue issue = issueRepository.GetById(id);
            if (issue != null)
            {
                IssueDTO dto = new IssueDTO(issue);
                dto.Stock = issue.Stocks.Select(s => new StockDTO(s));
                return Ok(dto);
            }
            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Stock id: " + id + " not found")
                );
        }

        public IHttpActionResult Post([FromBody]IssueDTO issueDTO)
        {
            Issue issue = issueDTO.CreateDomainObject(new Issue());

            this.issueRepository.Add(issue);

            return Ok(issue.ID);
        }
    }
}
