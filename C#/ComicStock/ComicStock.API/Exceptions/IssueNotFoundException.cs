using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.API.Exceptions
{
    public class IssueNotFoundException : HttpException
    {
        public IssueNotFoundException()
        {
            httpStatusCode = System.Net.HttpStatusCode.PartialContent;
        }
        public override string Message
        {
            get
            {
                return "IssueNotFoundException";
            }
        }
    }
}
