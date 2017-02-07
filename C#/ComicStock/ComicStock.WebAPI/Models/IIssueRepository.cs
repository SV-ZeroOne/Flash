using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.WebAPI.Models
{
    interface IIssueRepository
    {
        IEnumerable<IssueDTO> GetAll();
        IssueDTO GetById(int id);

        IEnumerable<IssueDTO> SearchByTitle(String title);

    }
}
