using System;
using System.Web.Http;
using System.Web.Mvc;
using ComicStock.WebAPI;


namespace ComicStock.WebAPI.Controllers
{

    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
    }
}
