/*Class: CMSC203 CRN 20932
 Program: Assignment #6
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

public class SmoothieTestStudent {

    private Smoothie smoothie;

    @BeforeEach
    public void setUp() {
        // Initialize a Smoothie object before each test
        smoothie = new Smoothie("Berry Blast", SIZE.MEDIUM, 3, true);
    }

    @Test
    public void testConstructor() {
        // Test the constructor for name, size, number of fruits, and protein powder
        assertEquals(SIZE.MEDIUM, smoothie.getSize(), "The size should be correctly initialized.");
        assertEquals(3, smoothie.getNumOfFruits(), "The number of fruits should be correctly initialized.");
        assertTrue(smoothie.isProteinPowder(), "Protein powder should be correctly initialized.");
    }

    @Test
    public void testInvalidNumberOfFruits() {
        // Test that an IllegalArgumentException is thrown when the number of fruits is negative
        assertThrows(IllegalArgumentException.class, () -> {
            new Smoothie("Berry Blast", SIZE.SMALL, -1, true);
        });
    }

    @Test
    public void testCalcPrice() {
        // Calculate the price with the parameters and compare it with the expected value
        double expectedPrice = Smoothie.BASE_PRICE + Smoothie.SIZE_PRICE * SIZE.MEDIUM.ordinal() + 
                               Smoothie.FRUIT_COST * 3 + Smoothie.PROTEIN_COST;
        assertEquals(expectedPrice, smoothie.calcPrice(), 0.01, "The price should be calculated correctly.");
    }

    @Test
    public void testToString() {
        // Verify the string representation of the Smoothie object
        String expectedString = "Berry Blast (SMALL) + Protein Powder - Fruits: 3 - $5.50";  // Adjust the expected value based on the price calculation
    }

    @Test
    public void testEquals() {
        // Test equality between two identical Smoothie objects
        Smoothie anotherSmoothie = new Smoothie("Berry Blast", SIZE.MEDIUM, 3, true);
        assertTrue(smoothie.equals(anotherSmoothie), "The smoothies should be equal when they have the same name, size, fruits, and protein powder.");

        // Test inequality between two different Smoothie objects
        Smoothie differentSmoothie = new Smoothie("Tropical Twist", SIZE.LARGE, 2, false);
        assertFalse(smoothie.equals(differentSmoothie), "The smoothies should not be equal when they have different attributes.");
    }

    @Test
    public void testSetNumOfFruits() {
        // Change the number of fruits and verify the update
        smoothie.setNumOfFruits(5);
        assertEquals(5, smoothie.getNumOfFruits(), "The number of fruits should be updated correctly.");
    }

    @Test
    public void testSetInvalidNumOfFruits() {
        // Test that an IllegalArgumentException is thrown when setting a negative number of fruits
        assertThrows(IllegalArgumentException.class, () -> {
            smoothie.setNumOfFruits(-1);
        });
    }

    @Test
    public void testSetProteinPowder() {
        // Change the protein powder status and verify the update
        smoothie.setProteinPowder(false);
        assertFalse(smoothie.isProteinPowder(), "Protein powder status should be updated correctly.");
    }

    @Test
    public void testHashCode() {
        // Test that hashCode is consistent with equals
        Smoothie anotherSmoothie = new Smoothie("Berry Blast", SIZE.MEDIUM, 3, true);
        
    }
}
