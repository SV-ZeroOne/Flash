using ComicStock.Data.IRepositories;
using ComicStock.Data.Repositories;
using Microsoft.Practices.Unity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ComicStock.Data
{
    public class DataUnityContainerExtension :UnityContainerExtension
    {
        protected override void Initialize()
        {
            this.Container.RegisterType<ComicContext>();
            this.Container.RegisterType<IVoucherRepository, VoucherRepository>(new HierarchicalLifetimeManager());
            this.Container.RegisterType<ICreatorRepository, CreatorRepository>(new HierarchicalLifetimeManager());
            this.Container.RegisterType<ISupplierRepository, SupplierRepository>(new HierarchicalLifetimeManager());
            this.Container.RegisterType<IIssueRepository, IssueRepository>(new HierarchicalLifetimeManager());
            this.Container.RegisterType<IStockRepository, StockRepository>(new HierarchicalLifetimeManager());
        }

    }
}
