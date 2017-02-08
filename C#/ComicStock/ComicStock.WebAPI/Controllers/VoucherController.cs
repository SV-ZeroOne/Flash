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
            Voucher voucher = voucherRepository.GetById(id);
            VoucherDTO dto = new VoucherDTO(voucher);

            return Ok(dto);
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

        // PUT: api/Voucher/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Voucher/5
        public void Delete(int id)
        {

        }
    }
}
