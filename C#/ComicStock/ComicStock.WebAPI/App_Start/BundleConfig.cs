using System.Web;
using System.Web.Optimization;

namespace ComicStock.WebAPI
{
    public class BundleConfig
    {
        // For more information on bundling, visit http://go.microsoft.com/fwlink/?LinkId=301862
        public static void RegisterBundles(BundleCollection bundles)
        {

            bundles.Add(new ScriptBundle("~/bundles/javascript").Include(
                      "~/Scripts/bootstrap-select.js",
                       "~/Scripts/angular.min.js",
                      "~/Scripts/Controller.js",
                      "~/Scripts/bootstrap-select.min.js",
                      "~/Scripts/bootstrap.js",
                      "~/Scripts/bootstrap.min.js",
                      "~/Scripts/Chart.min.js",
                      "~/Scripts/chartData.js",
                      "~/Scripts/dataTables.bootstrapmin.js",
                      "~/Scripts/fileinput.js",
                      "~/Scripts/jquery.dataTables.min.js",
                      "~/Scripts/jquery.min.js",
                      "~/Scripts/main.js"
                     

                ));


            bundles.Add(new StyleBundle("~/Content/css").Include(
                      "~/Content/style.less",
                      "~/Content/style.css",
                      "~/Content/bootstrap-social.css",
                      "~/Content/jquery.dataTables.min.css",
                      "~/Content/font-awesome.min.css",
                      "~/Scripts/fileinput.min.css",
                      "~/Content/dataTables.min.css",
                      "~/Content/bootstrap-select.css",
                      "~/Content/bootstrap.css",
                      "~/Scripts/awesome-bootstrap.checkbox.css",
                      "~/Scripts/bootstrap.min.css",
                      "~/Scripts/css/vars.css",
                      "~/Scripts/less/components.less",
                      "~/Scripts/less/vars.less"

                      ));
  
        }
    }
}
