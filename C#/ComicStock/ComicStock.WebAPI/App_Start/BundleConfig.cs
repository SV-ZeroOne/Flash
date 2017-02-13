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

            bundles.Add(new ScriptBundle("~/bundles/javascript").Include(

                      "~/Scripts/jquery.min.js",
                      "~/Scripts/angular.min.js",
                      "~/Scripts/angular-route.min.js",
                      "~/Scripts/app.js",
                      "~/Scripts/bootstrap-select.js",
                      "~/Scripts/bootstrap.min.js",
                      "~/Scripts/jquery.dataTables.min.js",
                      "~/Scripts/dataTables.bootstrap.min.js",
                      "~/Scripts/paging.js",
                      "~/Scripts/Chart.min.js",
                      "~/Scripts/fileinput.js",
                      "~/Scripts/chartData.js",
                      "~/Scripts/main.js",
                      "~/Scripts/Controller.js",
                      "~/Scripts/bootstrap-select.min.js",
                      "~/Scripts/bootstrap.js"
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
