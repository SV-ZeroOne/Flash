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
            VoucherDTO dto = null;
            Voucher voucher = voucherRepository.GetById(id);
            if (voucher != null)
            {
             dto = new VoucherDTO(voucher);
            }
            if (dto != null)
            {
                return Ok(dto);
            }

            return new System.Web.Http.Results.ResponseMessageResult(
                Request.CreateErrorResponse(
                    (HttpStatusCode)204,
                    new HttpError("Voucher Not Found")
                )
            );
        }

        [HttpPost]
        public IHttpActionResult Post([FromBody]VoucherDTO voucher)
        {

            Voucher newVoucher = new Voucher();
            newVoucher.ID = voucher.Id;
            newVoucher.Code = voucher.Code;
            newVoucher.RedeemDate = voucher.RedeemDate;
            newVoucher.Value = voucher.Value;

            this.voucherRepository.Add(newVoucher);

            return Ok(newVoucher.ID);
        }

        [HttpPut]
        public IHttpActionResult Put([FromBody]VoucherDTO voucher)
        {
          

            return Ok();
        }


        public IHttpActionResult Delete(int id)
        {
            voucherRepository.Delete(id);
            return Ok();
        }
    }
}
