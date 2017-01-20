package za.co.entelect.bootcamp.flash.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.entelect.bootcamp.flash.domain.Order;
import za.co.entelect.bootcamp.flash.domain.Stock;
import za.co.entelect.bootcamp.flash.persistence.Implementation.OrderRepository;
import za.co.entelect.bootcamp.flash.persistence.Implementation.StockRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kevin.gouws on 2017/01/13.
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static StockRepository stockRepository = new StockRepository();
    private static OrderRepository orderRepository = new OrderRepository();

    public static void main(String[] args) {
        System.out.println("Application Executed.");
        logger.info("Running Logging on main class");

        ArrayList<Stock> stock = (ArrayList<Stock>) stockRepository.readAll();
        String csvFile = "C:\\Users\\kevin.gouws\\Desktop\\orderlist.csv";
        String line;
        String cvsSplitBy = ",";
        Queue<Order> ordersToVerify = new LinkedList();
        Queue<Order> pendingOrders = new LinkedList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] orderString = line.split(cvsSplitBy);
                Order order = new Order();
                order.setIssueID(Integer.parseInt(orderString[0]));
                order.setQtyOrdered((short) Integer.parseInt(orderString[1]));
                order.setDeliveryStatus("Pending");
                ordersToVerify.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Order o : ordersToVerify) {
            for (Stock s : stock) {
                if (o.getIssueID() == s.getIssueID()) {
                    if (s.getAvailableQty() > o.getQtyOrdered()) {
                        logger.info("Creating Order in Order Table");
                        //orderRepository.create(o);
                        s.setAvailableQty((short) (s.getAvailableQty()+1));
                        logger.info("Updating Stock in Stock Table");
                        stockRepository.update(s);
                    } else {
                        logger.info("Not enough Stock for Order - Queueing Order");
                        pendingOrders.add(o);
                    }
                }
            }
        }
    }

}