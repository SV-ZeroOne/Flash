﻿using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.API.Services
{
    public interface IThirdPartyPayment
    {
        Order makePayment(Order order);
    }
}
