/*Class: CMSC203 CRN 20932
 Program: Assignment #6
 Instructor: Professor Ahmed Tarek 
 Summary of Description: Assignment 6
 Due Date: 12/11/2024
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student’s Name: Sunpairre Tamene
*/
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class OrderTestStudent {

    private Order order1;
    private Order order2;
    private Customer customer1;
    private Customer customer2;

    @Before
    public void setUp() {
        // Set up customers
        customer1 = new Customer("John Doe", 30);
        customer2 = new Customer("Jane Smith", 25);

        // Set up orders
        order1 = new Order(12, DAY.MONDAY, customer1);
        order2 = new Order(15, DAY.SATURDAY, customer2);
    }

    @Test
    public void testAddNewBeverage_Coffee() {
        order1.addNewBeverage("Espresso", SIZE.SMALL, true, false);
        assertEquals("Number of items should be 1", 1, order1.getTotalItems());
        assertTrue("The beverage should be a Coffee", order1.getBeverage(0) instanceof Coffee);
    }

    @Test
    public void testAddNewBeverage_Alcohol() {
        order1.addNewBeverage("Wine", SIZE.MEDIUM);
        assertEquals("Number of items should be 1", 1, order1.getTotalItems());
        assertTrue("The beverage should be Alcohol", order1.getBeverage(0) instanceof Alcohol);
    }

    @Test
    public void testAddNewBeverage_Smoothie() {
        order1.addNewBeverage("Berry Smoothie", SIZE.LARGE, 3, true);
        assertEquals("Number of items should be 1", 1, order1.getTotalItems());
        assertTrue("The beverage should be a Smoothie", order1.getBeverage(0) instanceof Smoothie);
    }

    @Test
    public void testCalcOrderTotal() {
        order1.addNewBeverage("Espresso", SIZE.SMALL, true, false); // Adds coffee
        order1.addNewBeverage("Berry Smoothie", SIZE.LARGE, 3, true); // Adds smoothie
        double expectedTotal = 2.5 + 3.0; // Example values for price calculation
    }

    @Test
    public void testFindNumOfBeveType() {
        order1.addNewBeverage("Espresso", SIZE.SMALL, true, false); // Adds coffee
        order1.addNewBeverage("Wine", SIZE.MEDIUM); // Adds alcohol
        assertEquals("Number of coffee beverages should be 1", 1, order1.findNumOfBeveType(TYPE.COFFEE));
        assertEquals("Number of alcohol beverages should be 1", 1, order1.findNumOfBeveType(TYPE.ALCOHOL));
    }

    @Test
    public void testOrderComparison() {
        order1.addNewBeverage("Espresso", SIZE.SMALL, true, false);
        order2.addNewBeverage("Wine", SIZE.LARGE);
    }

    @Test
    public void testToString() {
        order1.addNewBeverage("Espresso", SIZE.SMALL, true, false);
        String expectedString = "Order #" + order1.getOrderNo() + "\t12\tMONDAY\nCustomer: John Doe\tAge: 30" 
                                + "Espresso + Extra Shot - $2.50" // Assuming prices
                                + "Total: $2.50"; // Assuming price of the beverage
    }

    @Test
    public void testIsWeekend() {
        assertTrue("The order on Saturday should be a weekend", order2.isWeekend());
        assertFalse("The order on Monday should not be a weekend", order1.isWeekend());
    }
}

