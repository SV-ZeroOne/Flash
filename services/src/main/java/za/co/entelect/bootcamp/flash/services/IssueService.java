package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.Issues;
import za.co.entelect.bootcamp.flash.persistence.Implementation.IssueRepository;

import java.util.List;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class IssueService {

    private IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public IssueRepository getIssueRepository() {
        return issueRepository;
    }

    public void setIssueRepository(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }
}
