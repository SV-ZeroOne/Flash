package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Controller
public class HelloWorldController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody String getHelloWorldRest(ModelMap modelMap) {
        modelMap.addAttribute("greeting", "Hello World");
        return "Hello, world!";
    }
}
