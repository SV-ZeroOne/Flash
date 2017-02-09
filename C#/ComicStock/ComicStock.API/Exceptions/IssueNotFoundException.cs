﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.API.Exceptions
{
    public class IssueNotFoundException : Exception
    {
        public override string Message
        {
            get
            {
                return "IssueNotFoundException";
            }
        }
    }
}
