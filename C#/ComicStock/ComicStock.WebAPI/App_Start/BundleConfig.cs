using System.Drawing;
using System.Web;
using System.Web.Optimization;

namespace ComicStock.WebAPI
{
    public class BundleConfig
    {
        // For more information on bundling, visit http://go.microsoft.com/fwlink/?LinkId=301862
        public static void RegisterBundles(BundleCollection bundles)
        {

            bundles.Add(new ScriptBundle("~/assets/js").Include(
                      "~/app/assets/js/jquery.min.js",
                      "~/app/assets/js/bootstrap.min.js",
                      "~/app/assets/js/sweetalert2.min.js",
                      "~/app/assets/js/bootstrap-select.min.js",
                      "~/app/assets/js/jquery.min.js",
                      "~/app/assets/js/jquery.dataTables.min.js",
                      "~/app/assets/js/fileinput.js",
                      "~/app/assets/js/main.js"
                ));


            bundles.Add(new ScriptBundle("~/angular/js").Include(
                      "~/app/assets/js/angular.min.js",
                      "~/app/assets/js/angular-route.min.js",
                      "~/app/assets/js/angular-messages.js",
                      "~/app/assets/js/swx-session-storage.min.js",
                      "~/app/assets/js/angular-modal-service.min.js",
                      "~/app/modules/supplier/supplier.module.js",
                      "~/app/modules/creatorRole/role.module.js",
                      "~/app/modules/creator/creator.module.js",
                      "~/app/modules/stock/stock.module.js",
                      "~/app/modules/voucher/voucher.module.js",
                      "~/app/modules/issue/issue.module.js",
                      "~/app/modules/placeOrder/placeOrder.module.js",
                      "~/app/modules/viewOrders/viewOrders.module.js",
                      "~/app/modules/dashboard/dashboard.module.js",
                      "~/app/app.js"

                ));

            bundles.Add(new StyleBundle("~/assets/css").Include(
                      "~/app/assets/css/bootstrap.min.css",
                       "~/app/assets/css/font-awesome.min.css",
                      "~/app/assets/css/jquery.dataTables.min.css",
                      "~/app/assets/css/bootstrap-social.css",
                      "~/app/assets/css/bootstrap-select.css",
                      "~/app/assets/css/fileinput.min.css",
                      "~/app/assets/css/sweetalert2.min.css",
                      "~/app/assets/css/awesome-bootstrap.checkbox.css",
                      "~/app/assets/css/style.less",
                      "~/app/assets/css/style.css",
                      "~/app/assets/css/bootstrap.css",
                      "~/app/assets/css/vars.css",
                      "~/app/assets/css/bootstrap-select.css",
                      "~/app/assets/css/vars.less",
                      "~/app/assets/css/components.less"
                ));
        }
    }
}
