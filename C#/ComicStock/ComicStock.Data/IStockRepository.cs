﻿using ComicStock.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data
{ 
    public interface IStockRepository : IRepository<Stock>
{
    
}
}