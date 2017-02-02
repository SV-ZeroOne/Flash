package za.co.entelect.bootcamp.flash.services;

import sun.swing.BakedArrayList;
import za.co.entelect.bootcamp.flash.domain.Issues;
import za.co.entelect.bootcamp.flash.persistence.Implementation.IssueRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public class IssueService {

    private IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public Issues getIssueByID(int id) {
        return issueRepository.read(id);
    }

    public List<Issues> getAllIssues() {
        return issueRepository.readAll();
    }

//    public List<Issues> getNextIssueSet(int start, int end)
//    {
////        ArrayList<Issues> issueSet = new ArrayList<Issues>();
////        for (int issue = start; issue < end; issue++)
////        {
////            if(issue < issueRepository.readAll().size() && end >= 0) {
////                issueSet.add(issueRepository.read(issue));
////            }
////        }
////
////        return issueSet;
//        return issueRepository.getNextIssueSet(start, end);
//    }
//
//    public List<Issues> getFilterList(String filter)
//    {
//        return issueRepository.getFilterList(filter);
//    }
//
//    public List<Issues> getNext(List<Issues> inList, int start, int end)
//    {
//        ArrayList<Issues> issueSet = new ArrayList<Issues>();
//        for (int issue = start; issue < end; issue++)
//        {
//            if(issue < inList.size() && end >= 0) {
//                issueSet.add(inList.get(issue));
//            }
//        }
//        return issueSet;
//    }


}
