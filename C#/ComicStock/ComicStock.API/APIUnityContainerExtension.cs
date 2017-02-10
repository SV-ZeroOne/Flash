using ComicStock.API.Services;
using ComicStock.Data;
using Microsoft.Practices.Unity;

namespace ComicStock.API
{
    public class APIUnityContainerExtension : UnityContainerExtension
    {
        protected override void Initialize()
        {
            this.Container.RegisterType<ComicContext>(new HierarchicalLifetimeManager());
            this.Container.RegisterType<ISupplierOrder, SupplierOrder>(new HierarchicalLifetimeManager());
            this.Container.RegisterType<IThirdPartyPayment, ThirdPartyPaymentMock>(new HierarchicalLifetimeManager());
        }
    }
}


