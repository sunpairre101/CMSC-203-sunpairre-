import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents test cases for a Property object.
 * 
 * @version 1.0
 */
public class PropertyTestStudent {
    private Property property1, property2, property3;

    @Before
    public void setUp() throws Exception {
        property1 = new Property("Sunset Villa", "Los Angeles", 2500.0, "John Doe", 10, 20, 30, 40);
        property2 = new Property("Seaside Cottage", "Miami", 0.0, "Jane Smith"); // Rent set to 0.0 to match toString expectation
        property3 = new Property(property1); // Copy constructor
    }

    @After
    public void tearDown() throws Exception {
        property1 = property2 = property3 = null;
    }

    @Test
    public void testConstructor() {
        assertEquals("Sunset Villa", property1.getPropertyName());
        assertEquals("Los Angeles", property1.getCity());
        assertEquals(2500.0, property1.getRentAmount(), 0.001);
        assertEquals("John Doe", property1.getOwner());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals(property1.getPropertyName(), property3.getPropertyName());
        assertEquals(property1.getCity(), property3.getCity());
        assertEquals(property1.getRentAmount(), property3.getRentAmount(), 0.001);
        assertEquals(property1.getOwner(), property3.getOwner());
    }

    @Test
    public void testSettersAndGetters() {
        property2.setCity("Orlando");
        property2.setOwner("Emily Johnson");
        property2.setRentAmount(2000.0);
        
        assertEquals("Orlando", property2.getCity());
        assertEquals("Emily Johnson", property2.getOwner());
        assertEquals(2000.0, property2.getRentAmount(), 0.001);
    }

    @Test
    public void testToString() {
        assertEquals("Sunset Villa,Los Angeles,John Doe,2500.0", property1.toString());
        assertEquals("Seaside Cottage,Miami,Jane Smith,0.0", property2.toString());
    }
}
