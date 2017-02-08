﻿using ComicStock.Data;
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
            issueRepository = new IssueRepository();
            return Ok(issueRepository.GetById(id));
        }

    }
}