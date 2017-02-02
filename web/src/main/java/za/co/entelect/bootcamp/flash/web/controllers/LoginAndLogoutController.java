package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by steve.velcev on 2017/02/02.
 */
@Controller
public class LoginAndLogoutController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "/login";
    }

//    @RequestMapping(value="/loginError", method = RequestMethod.GET)
//    public String loginError(ModelMap model) {
//        model.addAttribute("error", "true");
//        return "/login?logout";
//    }

}
