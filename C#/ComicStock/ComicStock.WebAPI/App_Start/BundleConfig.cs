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


            bundles.Add(new StyleBundle("~/assets/css").Include(

                      "~/app/assets/css/style.less",
                      "~/app/assets/css/style.css",
                      "~/app/assets/css/bootstrap.css",
                      "~/app/assets/css/bootstrap-social.css",
                      "~/app/assets/css/jquery.dataTables.min.css",
                      "~/app/assets/css/font-awesome.min.css",
                      "~/app/assets/css/fileinput.min.css",
                      "~/app/assets/css/dataTables.min.css",
                      "~/app/assets/css/bootstrap-select.css",
                      "~/app/assets/css/bootstrap.css",
                      "~/app/assets/css/awesome-bootstrap.checkbox.css",
                      "~/app/assets/css/bootstrap.min.css",
                      "~/app/assets/css/css/vars.css",
                      "~/app/assets/css/dataTables.min.css",
                      "~/app/assets/css/bootstrap-select.css",
                      "~/app/assets/css/less/vars.less",
                      "~/app/assets/css/less/components.less"


                      ));
  
        }
    }
}
