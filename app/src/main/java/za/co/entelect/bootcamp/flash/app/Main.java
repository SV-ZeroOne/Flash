package za.co.entelect.bootcamp.flash.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.entelect.bootcamp.flash.persistence.Implementation.IssueRepository;

/**
 * @author kevin.gouws - Created on 2017/01/13.
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Application Executed.");
        logger.info("Running Logging on main class");
    }

}