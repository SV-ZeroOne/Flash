using ComicStock.Data;
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

        IssueRepository issueRepository;
   
        [ResponseType(typeof(IEnumerable<IssueDTO>))]
        public IHttpActionResult Get()
        {
            issueRepository = new IssueRepository();
            
            return Ok(issueRepository.GetAll());
        }


  
        public IHttpActionResult Get(int id)
        {
            issueRepository = new IssueRepository();
            return Ok(issueRepository.GetById(id));
        }

    }
}
