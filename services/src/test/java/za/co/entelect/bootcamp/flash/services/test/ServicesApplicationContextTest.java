package za.co.entelect.bootcamp.flash.services.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import za.co.entelect.bootcamp.flash.domain.Issues;
import za.co.entelect.bootcamp.flash.services.StockOrderPlacement;

/**
 * Created by kevin.gouws on 2017/01/28.
 */
/*public class ServicesApplicationContextTest {

    private ApplicationContext applicationContext;
    private StockOrderPlacement stockOrderPlacement;

    @Before
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext("services-configuration.xml");
        stockOrderPlacement = applicationContext.getBean(StockOrderPlacement.class);
    }

    @Test
    public void testGetOrderFromDB() {
        Issues firstIssue = stockOrderPlacement.getIssue(2);
        Assert.assertTrue(firstIssue != null);
        System.out.println(firstIssue.toString());
    }

    @After
    public void tearDown() {

    }

}*/
