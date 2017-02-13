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
                      "~/Scripts/Controller.js",
                      "~/Scripts/bootstrap-select.js",

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
                      "~/Content/bootstrap.css",
                      "~/Content/bootstrap-social.css",
                      "~/Content/jquery.dataTables.min.css",
                      "~/Content/font-awesome.min.css",
                      "~/Content/fileinput.min.css",
                      "~/Content/dataTables.min.css",
                      "~/Content/bootstrap-select.css",
                      "~/Content/bootstrap.css",
                      "~/Content/awesome-bootstrap.checkbox.css",
                      "~/Content/bootstrap.min.css",
                   //   "~/Content/css/vars.css",
              
                      "~/Content/dataTables.min.css",
                      "~/Content/bootstrap-select.css",
                      "~/Content/less/vars.less",
                      "~/Content/less/components.less"


                      ));
  
        }
    }
}
