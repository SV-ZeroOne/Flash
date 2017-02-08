using Microsoft.Practices.Unity;
using System.Web.Http;
using Unity.WebApi;
using ComicStock.Data;
using ComicStock.Data.IRepositories;
using ComicStock.Data.Repositories;

namespace ComicStock.WebAPI
{
    public static class UnityConfig
    {
        public static void RegisterComponents()
        {
			var container = new UnityContainer();
            
            // register all your components with the container here
            // it is NOT necessary to register your controllers
            
             container.RegisterType<IIssueRepository, IssueRepository>();
             GlobalConfiguration.Configuration.DependencyResolver = new UnityDependencyResolver(container);
        }
    }
}