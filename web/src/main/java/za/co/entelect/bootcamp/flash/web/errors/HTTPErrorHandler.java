package za.co.entelect.bootcamp.flash.web.errors;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by byron.dinkelmann on 2017/02/03.
 */

@Controller
public class HTTPErrorHandler{
    String path = "/error";
    @RequestMapping(value="/400")
    public String error400(){
        System.out.println("custom error handler");
        return path+"/400";
    }
    @RequestMapping(value="/404")
    public String error404(){
        System.out.println("custom error handler");
        return path+"/404";
    }
    @RequestMapping(value="/500")
    public String error500(){
        System.out.println("custom error handler");
        return path+"/500";
    }
}