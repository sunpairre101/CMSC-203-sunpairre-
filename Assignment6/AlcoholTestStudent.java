/*Class: CMSC203 CRN 20932

 Program: Assignment #6
 Instructor: Professor Ahmed Tarek 
 Summary of Description: Assignment 6
 Due Date: 12/11/2024
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student’s Name: Sunpairre Tamene
*/
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlcoholTestStudent {

    @Test
    public void testAlcoholConstructorWithWeekend() {
        Alcohol drink = new Alcohol("Beer", SIZE.MEDIUM, true);
        assertNotNull(drink);
        assertEquals("Beer", drink.getBevName());
        assertEquals(SIZE.MEDIUM, drink.getSize());
        assertTrue(drink.isWeekend());
    }

    @Test
    public void testAlcoholConstructorWithoutWeekend() {
        Alcohol drink = new Alcohol("Wine", SIZE.LARGE);
        assertNotNull(drink);
        assertEquals("Wine", drink.getBevName());
        assertEquals(SIZE.LARGE, drink.getSize());
        assertFalse(drink.isWeekend());
    }

    @Test
    public void testCalcPriceWithWeekendAndLargeSize() {
        Alcohol drink = new Alcohol("Whiskey", SIZE.LARGE, true);
        double expectedPrice = drink.getBasePrice() + 2.0 + 0.6; // Large size + weekend charge
        assertEquals(expectedPrice, drink.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceWithoutWeekendAndMediumSize() {
        Alcohol drink = new Alcohol("Vodka", SIZE.MEDIUM);
        double expectedPrice = drink.getBasePrice() + 1.0; // Medium size charge
        assertEquals(expectedPrice, drink.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Alcohol drink = new Alcohol("Beer", SIZE.MEDIUM, true);
        String expectedString = String.format("Alcohol [Name=Beer, Size=MEDIUM, Weekend Special=Yes, Price=%.2f]", 
                                              drink.calcPrice());
        assertEquals(expectedString, drink.toString());
    }

    @Test
    public void testEqualsTrue() {
        Alcohol drink1 = new Alcohol("Beer", SIZE.MEDIUM, true);
        Alcohol drink2 = new Alcohol("Beer", SIZE.MEDIUM, true);
        assertTrue(drink1.equals(drink2));
    }

    @Test
    public void testEqualsFalse() {
        Alcohol drink1 = new Alcohol("Beer", SIZE.MEDIUM, true);
        Alcohol drink2 = new Alcohol("Wine", SIZE.LARGE, false);
        assertFalse(drink1.equals(drink2));
    }
}
