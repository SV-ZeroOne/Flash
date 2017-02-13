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
                      "~/app/assets/js/bootstrap-select.min.js",
                      "~/app/assets/js/bootstrap.min.js",
                      "~/app/assets/js/dataTables.bootstrapmin.js",
                      "~/app/assets/js/fileinput.js",
                      "~/app/assets/js/jquery.dataTables.min.js",
                      "~/app/assets/js/jquery.min.js",
                      "~/app/assets/js/main.js"
                ));

            bundles.Add(new ScriptBundle("~/angular/js").Include(
                      "~/app/assets/js/angular.min.js",
                      "~/app/assets/js/angular-route.min.js",
                      "~/app/assets/js/app.js",
                      "~/app/assets/js/Controller.js"
                ));

            bundles.Add(new StyleBundle("~/Content/css").Include(
                      "~/Content/bootstrap.min.css",
                       "~/Content/font-awesome.min.css",
                      "~/Content/jquery.dataTables.min.css",
                      "~/Content/bootstrap-social.css",
                      "~/Content/bootstrap-select.css",
                      "~/Content/fileinput.min.css",
                      "~/Content/awesome-bootstrap.checkbox.css",
                      "~/Content/style.less",
                      "~/Content/style.css",
                      "~/Content/bootstrap.css",
                      "~/Content/css/vars.css",
                      "~/Content/bootstrap-select.css",
                      "~/Content/vars.less",
                      "~/Content/components.less"
                ));
        }
    }
}
