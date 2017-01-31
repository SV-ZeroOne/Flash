package za.co.entelect.bootcamp.flash.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class HelloWorldController {
    private IssueService issueService;

    @Autowired
    public HelloWorldController(IssueService issueService) {
        this.issueService = issueService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody String getHelloWorldRest(ModelMap modelMap) {
        Issues issue = issueService.getIssueByID(2);
        modelMap.addAttribute("content", issue.getTitle());
        return issue.getTitle();
    }
}
