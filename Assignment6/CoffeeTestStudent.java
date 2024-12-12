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

public class CoffeeTestStudent {

    private Coffee coffee;

    @BeforeEach
    public void setUp() {
        // Set up a basic Coffee object before each test
        coffee = new Coffee("Latte", SIZE.MEDIUM, true, false);
    }

    @Test
    public void testCalcPrice() {
        // Base price + size price (medium size) + extra shot cost
        double expectedPrice = Coffee.BASE_PRICE + Coffee.SIZE_PRICE * SIZE.MEDIUM.ordinal() + Coffee.EXTRA_SHOT_COST;
        assertEquals(expectedPrice, coffee.calcPrice(), "The calculated price should match the expected price.");
    }

    @Test
    public void testToString() {
        // Expected string with extra shot and no extra syrup
        String expectedString = "Latte (Medium) - $5.5 + Extra Shot";
    }

    @Test
    public void testEquals() {
        Coffee anotherCoffee = new Coffee("Latte", SIZE.MEDIUM, true, false);
        assertTrue(coffee.equals(anotherCoffee), "The Coffee objects should be equal with the same attributes.");

        Coffee differentCoffee = new Coffee("Latte", SIZE.LARGE, true, false);
        assertFalse(coffee.equals(differentCoffee), "The Coffee objects should not be equal with different sizes.");
    }

    @Test
    public void testGetExtraShot() {
        assertTrue(coffee.getExtraShot(), "The coffee should have an extra shot.");
    }

    @Test
    public void testGetExtraSyrup() {
        assertFalse(coffee.getExtraSyrup(), "The coffee should not have extra syrup.");
    }

    @Test
    public void testSetExtraShot() {
        coffee.setExtraShot(false);
        assertFalse(coffee.getExtraShot(), "The coffee should not have an extra shot after being set to false.");
    }

    @Test
    public void testSetExtraSyrup() {
        coffee.setExtraSyrup(true);
        assertTrue(coffee.getExtraSyrup(), "The coffee should have extra syrup after being set to true.");
    }
}
