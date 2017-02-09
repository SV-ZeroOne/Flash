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
            container.AddExtension(new DataUnityContainerExtension());
            container.AddExtension(new DataUnityContainerExtension());
            GlobalConfiguration.Configuration.DependencyResolver = new UnityDependencyResolver(container);

        }
    }
}