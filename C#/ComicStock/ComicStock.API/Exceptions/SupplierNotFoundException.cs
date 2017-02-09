using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.API.Exceptions
{
    public class SupplierNotFoundException : Exception
    {
        public override string Message
        {
            get
            {
                return "SupplierNotFoundException";
            }
        }
    }
}
