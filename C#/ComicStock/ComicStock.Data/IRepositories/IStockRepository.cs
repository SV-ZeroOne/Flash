﻿using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data.IRepositories
{ 
    public interface IStockRepository : IRepository<Stock>
    {
        Stock GetById(int stockID);
        IEnumerable<Stock> GetPage(string search, int page, int pageSize);
    }
}
