/*Class: CMSC203 CRN 20932
 Program: Assignment #4 
 Instructor: Professor Ahmed Tarek 
 Summary of Description: Assignment 4
 Due Date: 10/30/2024
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student’s Name: Sunpairre Tamene
*/
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
    Property p1, p2, p3, p4, p5, p6;
    ManagementCompany m;

    @Before
    public void setUp() throws Exception {
        p1 = new Property("Almost Aspen", "Glendale", 4844.00, "Sammy Smith", 2, 1, 2, 2);
        p2 = new Property("Ambiance", "Lakewood", 4114, "Tammy Taylor", 4, 1, 2, 2);
        p3 = new Property("Bear Creek Lodge", "Peninsula", 4905, "Bubba Burley", 6, 1, 2, 2);

        m = new ManagementCompany("Railey", "555555555", 6);

        m.addProperty(p1);
        m.addProperty(p2);
        m.addProperty(p3);
    }

    @After
    public void tearDown() throws Exception {
        p1 = p2 = p3 = p4 = p5 = p6 = null;
        m = null;
    }

    @Test
    public void testGetMAX_PROPERTY() {
        assertEquals(5, ManagementCompany.MAX_PROPERTY);
    }

    @Test
    public void testAddProperty() {
        p4 = new Property("Sunsational", "Beckman", 2613, "BillyBob Wilson", 2, 5, 2, 2);
        p5 = new Property("Mystic Cove", "Lakepointe", 5327, "Joey BagODonuts", 4, 5, 2, 2);
        p6 = new Property("Too Many Properties", "Lakepointe", 1000, "Joey BagODonuts", 6, 5, 2, 2);

        assertEquals(3, m.addProperty(p4), 0);
        assertEquals(4, m.addProperty(p5), 0);
        assertEquals(-1, m.addProperty(p6), 0); // Exceeds array size; should return -1
    }

    @Test
    public void testTotalRent() {
        assertEquals(13863.0, m.getTotalRent(), 0);
    }

    @Test
    public void testMaxRentProperty() {
        String maxRentString = m.getHighestRentPropperty().toString();
        assertTrue(maxRentString.contains("4905.0"));
    }

    /*
    @Test
    public void testDisplayPropertyAtIndex() {
        // Find and print the third property
        String prop = m.displayPropertyAtIndex(2);
        // Split the toString into an array
        String[] propArray = prop.split(" ");
        // Test that the last element of the toString is the rent of the third property
        assertEquals("4905.0", propArray[propArray.length - 1]);
    }
    */
}
