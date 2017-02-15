﻿using ComicStock.Data.IRepositories;
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
    public class VoucherController : ApiController
    {

        private readonly IVoucherRepository voucherRepository;

        public VoucherController(IVoucherRepository voucherRepository)
        {
            this.voucherRepository = voucherRepository;
        }

        [ResponseType(typeof(IEnumerable<VoucherDTO>))]
        public IHttpActionResult Get(int page, int pageSize)
        {
            var vouchersDomain = voucherRepository.GetPage(page, pageSize);

            IEnumerable<VoucherDTO> vouchers = vouchersDomain.Select(v => new VoucherDTO(v));

            return Ok(vouchers);
        }

        public IHttpActionResult Get(int id)
        {
            Voucher voucher = voucherRepository.GetById(id);
            if (voucher != null)
            {
                VoucherDTO dto = new VoucherDTO(voucher);
                return Ok(dto);
            }

            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Stock id: " + id + " not found")
                );
        }

        [HttpPost]
        public IHttpActionResult Post([FromBody]VoucherDTO voucherDTO)
        {

            Voucher voucher = voucherDTO.CreateDomainObject(new Voucher());

            this.voucherRepository.Add(voucher);

            return Ok(voucher.ID);
        }

        [HttpPut]
        public IHttpActionResult Put(int id, [FromBody]VoucherDTO voucherDTO)
        {
            Voucher voucher = voucherRepository.GetById(id);
            if (voucher != null)
            {
                voucherRepository.Update(voucherDTO.CreateDomainObject(voucher));
                return Ok(voucherDTO);
            }
            return ResponseMessage(Request.CreateErrorResponse(
                HttpStatusCode.NotFound,
                "Voucher id: " + id + " not found")
                );
        }

        [Route("api/Voucher/count")]
        public IHttpActionResult Get()
        {
            return Ok(voucherRepository.Count());
        }


        public IHttpActionResult Delete(int id)
        {
            voucherRepository.Delete(id);
            return Ok();
        }
    }
}
