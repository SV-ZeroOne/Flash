using ComicStock.Data.IRepositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ComicStock.WebAPI.Models;
using System.Web.Http.Description;
using ComicStock.Domain;

namespace ComicStock.WebAPI.Controllers
{
    public class CreatorController : ApiController
    {

        private readonly ICreatorRepository creatorRepository;
        private readonly IIssueRepository issueRepository;

        public CreatorController(ICreatorRepository creatorRepository, IIssueRepository issueRepository)
        {
            this.creatorRepository = creatorRepository;
            this.issueRepository = issueRepository;
        }

        public IHttpActionResult Get(int page, int pageSize)
        {
            var creatorsDomain = creatorRepository.GetPage(page, pageSize);

            IEnumerable<CreatorDTO> creators = creatorsDomain.Select(c => new CreatorDTO(c));

            return Ok(creators);
        }

        public IHttpActionResult Get(int id)
        {
            Creator creator = creatorRepository.GetById(id);
            if (creator != null)
            {
                CreatorDTO dto = new CreatorDTO(creator);
                dto.Issues = creator.ComicCreators.Select(cc => new IssueDTO(cc.Issue,cc.CreatorRole));
               
                return Ok(dto);
            }
            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Creator id: " + id + " not found")
                );
        }
 

        [Route("api/Creator/search")]
        public IHttpActionResult Get(string search, int page, int pageSize)
        {
            IEnumerable<CreatorDTO> creators = creatorRepository.GetPage(search, page, pageSize).Select(c => new CreatorDTO(c)
            {
                Issues = c.ComicCreators.Select(cc => new IssueDTO(cc.Issue))
            });

            return Ok(creators);
        }
        [HttpPost]
        public IHttpActionResult Post([FromBody]CreatorDTO creator)
        {
            Creator newCreator = creator.CreateDomainObject(new Creator());

            this.creatorRepository.Add(newCreator);

            return Ok(newCreator.ID);
        }

        [HttpPut]
        public IHttpActionResult Put(int id, [FromBody]CreatorDTO creatorDTO)
        {
            Creator creator = creatorRepository.GetById(id);
            if (creator != null)
            {
                creatorRepository.Update(creatorDTO.CreateDomainObject(creator));
                return Ok(creatorDTO);
            }
            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Creator id: " + id + " not found")
                );
        }

        [Route("api/Creator/count")]
        public IHttpActionResult Get()
        {
            return Ok(creatorRepository.Count());
        }

        public IHttpActionResult Delete(int id)
        {
            Creator creator = creatorRepository.GetById(id);
            if (creator != null)
            {
                creatorRepository.Delete(id);
                return Ok(id);
            }
            else
            {
                return BadRequest();
            }

        }

    }
}
