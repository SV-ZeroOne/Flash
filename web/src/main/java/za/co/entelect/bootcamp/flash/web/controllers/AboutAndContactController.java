package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by steve.velcev on 2017/02/02.
 */
@Controller
public class AboutAndContactController {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String showAbout() {
        return "about";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String showContact() {
        return "contact";
    }

}
