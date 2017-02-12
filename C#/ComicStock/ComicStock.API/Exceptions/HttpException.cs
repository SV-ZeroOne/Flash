using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.API.Exceptions
{
    public class HttpException : Exception
    {
        public HttpStatusCode httpStatusCode = HttpStatusCode.NotFound;
    }
}
