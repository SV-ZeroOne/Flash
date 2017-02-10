using ComicStock.Data;
using ComicStock.Data.IRepositories;
using ComicStock.Data.Repositories;
using Microsoft.Practices.Unity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.API
{
    public class APIUnityContainerExtension : UnityContainerExtension
    {
        protected override void Initialize()
        {
            this.Container.RegisterType<ComicContext>(new HierarchicalLifetimeManager());
            this.Container.RegisterType<ISupplierOrder, SupplierOrder>(new HierarchicalLifetimeManager());
        }
    }
}


