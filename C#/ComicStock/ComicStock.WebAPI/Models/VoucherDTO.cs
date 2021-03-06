﻿using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ComicStock.WebAPI.Models
{
    public class VoucherDTO
    {
        public int Id { get; set;}
        public string Code { get; set; }
        public DateTime? RedeemDate { get; set; }
        public decimal Value { get; set; }

        public VoucherDTO() { }

        public VoucherDTO(Voucher voucher)
        {
            this.Id = voucher.ID;
            this.Code = voucher.Code;
            this.RedeemDate = voucher.RedeemDate;
            this.Value = voucher.Value;
        }

        public Voucher CreateDomainObject(Voucher voucher)
        {
            voucher.Code = this.Code;
            voucher.RedeemDate = this.RedeemDate;
            voucher.Value = this.Value;
            return voucher;
        }
    }
}