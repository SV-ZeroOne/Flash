package za.co.entelect.bootcamp.flash.services;

import za.co.entelect.bootcamp.flash.domain.Issue;

/**
 * Created by byron.dinkelmann on 2017/01/16.
 */
@Deprecated
public class IssueOrderDTOAdapterFactory {

    public IssueOrderDTOAdapter createIssueOrderDTOAdapter(Issue issue, int quantity) {
        return new IssueOrderDTOAdapter(issue, quantity);
    }
}
