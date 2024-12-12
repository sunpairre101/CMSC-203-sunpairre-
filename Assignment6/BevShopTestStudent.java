/*Class: CMSC203 CRN 20932
 Program: Assignment #5
 Instructor: Professor Ahmed Tarek 
 Summary of Description: Assignment 6
 Due Date: 12/11/24
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student’s Name: Sunpairre Tamene
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BevShopTestStudent {

    private BevShop shop;
    private Order order1;
    private Order order2;

    @BeforeEach
    public void setUp() {
        shop = new BevShop();
        shop.startNewOrder(12, DAY.MONDAY, "Alice", 25); // Start an order for Alice
        order1 = shop.getCurrentOrder();
        shop.startNewOrder(14, DAY.TUESDAY, "Bob", 22); // Start another order for Bob
        order2 = shop.getCurrentOrder();
    }

   
 
    public void testEligibleForMore() {
        shop.processAlcoholOrder("Beer", SIZE.LARGE);
        shop.processAlcoholOrder("Whiskey", SIZE.MEDIUM);
        shop.processAlcoholOrder("Vodka", SIZE.SMALL);
        assertFalse(shop.eligibleForMore()); // Should not be eligible for more alcohol
    }

    @Test
    public void testIsValidAge() {
        assertTrue(shop.isValidAge(25)); // Valid age for alcohol purchase
        assertFalse(shop.isValidAge(20)); // Invalid age for alcohol purchase
    }

    @Test
    public void testValidTime() {
        assertTrue(shop.validTime(15)); // Valid time
        assertFalse(shop.validTime(25)); // Invalid time (should be within 0-24)
    }

    @Test
    public void testTotalOrderPrice() {
        shop.processCoffeeOrder("Latte", SIZE.MEDIUM, false, false);
        
    }

    @Test
    public void testTotalMonthlySale() {
        shop.processCoffeeOrder("Latte", SIZE.MEDIUM, false, false);
        shop.processAlcoholOrder("Beer", SIZE.LARGE);
        shop.startNewOrder(15, DAY.WEDNESDAY, "Charlie", 30); // Another order
        shop.processSmoothieOrder("Berry Smoothie", SIZE.SMALL, 3, true);
    }

    @Test
    public void testSortOrders() {
        shop.processCoffeeOrder("Latte", SIZE.MEDIUM, false, false);
        shop.processAlcoholOrder("Beer", SIZE.LARGE);
        shop.startNewOrder(15, DAY.WEDNESDAY, "Charlie", 30);
        shop.processSmoothieOrder("Berry Smoothie", SIZE.SMALL, 3, true);

        shop.sortOrders(); // Sort orders by order number

    }

    @Test
    public void testMaxFruit() {
        assertTrue(shop.isMaxFruit(6)); // 6 fruits is max
        assertFalse(shop.isMaxFruit(4)); // 4 fruits is valid
    }

    @Test
    public void testFindOrder() {
        shop.processCoffeeOrder("Latte", SIZE.MEDIUM, false, false);
        assertEquals(0, shop.findOrder(order1.getOrderNo())); // Should find the first order
        assertEquals(1, shop.findOrder(order2.getOrderNo())); // Should find the second order
        assertEquals(-1, shop.findOrder(9999)); // Non-existent order
    }

    @Test
    public void testTotalNumOfMonthlyOrders() {
        shop.processCoffeeOrder("Latte", SIZE.MEDIUM, false, false);
        shop.processAlcoholOrder("Beer", SIZE.LARGE);
        shop.startNewOrder(15, DAY.WEDNESDAY, "Charlie", 30);
        shop.processSmoothieOrder("Berry Smoothie", SIZE.SMALL, 3, true);

        assertEquals(3, shop.totalNumOfMonthlyOrders()); // Should have 3 orders
    }

    @Test
    public void testToString() {
        shop.processCoffeeOrder("Latte", SIZE.MEDIUM, false, false);
        shop.processAlcoholOrder("Beer", SIZE.LARGE);
        String result = shop.toString();
        assertTrue(result.contains("Latte")); // Check if the string contains beverage names
        assertTrue(result.contains("Beer"));
    }
}

