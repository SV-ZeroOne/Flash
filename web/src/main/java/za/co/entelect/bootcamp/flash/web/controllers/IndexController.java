package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import za.co.entelect.bootcamp.flash.domain.Issues;
import za.co.entelect.bootcamp.flash.services.IssueService;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    private IssueService issueService;

    @Autowired
    public IndexController(IssueService issueService) {
        this.issueService = issueService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewHome(ModelMap model) {
        Issues firstIssue = issueService.getIssueByID(2);
        model.addAttribute("firstIssue", firstIssue);
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomeRedirect(Model model) {
        Issues firstIssue = issueService.getIssueByID(2);
        model.addAttribute("firstIssue", firstIssue);
        return "home";
    }

    // Returns a REST request value
    /*@RequestMapping(value = "/home", method = RequestMethod.GET)
    public @ResponseBody String getHomeRest(Model model) {
        Issues firstIssue = issueService.getIssueByID(2);
        model.addAttribute("firstIssue", firstIssue);
        return "home";
    }*/
}
