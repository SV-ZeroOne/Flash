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

        public CreatorController(ICreatorRepository creatorRepository)
        {
            this.creatorRepository = creatorRepository;
        }


        [ResponseType(typeof(IEnumerable<CreatorDTO>))]
        public IHttpActionResult Get(int page, int pageSize)
        {
            var creatorsDomain = creatorRepository.GetPage(page, pageSize);

            IEnumerable<CreatorDTO> creators = creatorsDomain.Select(c => new CreatorDTO(c));
         
            return Ok(creators);
        }

        public IHttpActionResult Get(int id)
        {
            CreatorDTO dto = null;

            Creator c = this.creatorRepository.GetById(id);
            if (c != null) { 
            dto = new CreatorDTO(c);
            }
           if(dto!=null)
           {
              return Ok(dto);
           }

            return new System.Web.Http.Results.ResponseMessageResult(
                Request.CreateErrorResponse(
                    (HttpStatusCode)204,
                    new HttpError("Creator Not Found")
                )
            );
        }

        [HttpPost]
        public IHttpActionResult Post([FromBody]CreatorDTO creator)
        {

            Creator newCreator = new Creator();
            newCreator.ID = creator.Id;
            newCreator.CountryOfResidence = creator.Country;
            newCreator.EmailAddress = creator.Email;
            newCreator.TaxReferenceNumber = creator.TaxRef;
            newCreator.Name = creator.Name;

            this.creatorRepository.Add(newCreator);

            return Ok(newCreator.ID);
        }

        // PUT: api/Creator/5
        public void Put(int id, [FromBody]string value)
        {
        }

        public IHttpActionResult Delete(int id)
        {
            creatorRepository.Delete(id);
            return Ok();
        }
    }
}
