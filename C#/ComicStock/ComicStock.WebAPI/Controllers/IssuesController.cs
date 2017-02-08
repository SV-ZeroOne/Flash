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

        public IssuesController(IssueRepository issueRepository)
        {
            this.issueRepository = issueRepository;
        }
   
        [ResponseType(typeof(IEnumerable<IssueDTO>))]
        public IHttpActionResult Get()
        {
            

            var issues = from i in issueRepository.GetAll()
                         select new IssueDTO()
                         {
                             Id = i.ID,
                             Description = i.Description,
                             PublicationDate = i.PublicationDate,
                             Publisher = i.Publisher,
                             SeriesNumber = i.SeriesNumber,
                             Title = i.Title,
                             Stock = from x in i.Stocks select new StockDTO()
                             {
                                 Id = x.ID,
                                 AvailableQuantity = x.AvailableQty,
                                 Condition = x.Condition,
                                 issueID = x.IssueID,
                                 Price = x.Price

                             },
                                                         

                         };

            return Ok(issues);
        }


  
        public IHttpActionResult Get(int id)
        {
           
            Issue issue = issueRepository.GetById(id);
            IssueDTO dto = new IssueDTO()
            {
                Id = issue.ID,
                Publisher = issue.Publisher,
                PublicationDate = issue.PublicationDate,
                SeriesNumber = issue.SeriesNumber,
                Description = issue.Description,
                Title = issue.Title,
                Stock = from x in issue.Stocks
                  select new StockDTO()
                   {
                      Id = x.ID,
                      AvailableQuantity = x.AvailableQty,
                      Condition = x.Condition,
                      issueID = x.IssueID,
                      Price = x.Price
                   },
            };
            return Ok(dto);
        }

       

    }
}
