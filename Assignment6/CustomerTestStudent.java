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

public class CustomerTestStudent {

    private Customer customer;

    @BeforeEach
    public void setUp() {
        // Initialize a Customer object before each test
        customer = new Customer("John Doe", 30);
    }

    @Test
    public void testConstructor() {
        // Test the constructor for name and age
        assertEquals("John Doe", customer.getName(), "The name should be correctly initialized.");
        assertEquals(30, customer.getAge(), "The age should be correctly initialized.");
    }

    @Test
    public void testCopyConstructor() {
        // Create a new customer using the copy constructor
        Customer copiedCustomer = new Customer(customer);
        assertEquals(customer.getName(), copiedCustomer.getName(), "The copied customer should have the same name.");
        assertEquals(customer.getAge(), copiedCustomer.getAge(), "The copied customer should have the same age.");
    }

    @Test
    public void testSetName() {
        customer.setName("Jane Doe");
        assertEquals("Jane Doe", customer.getName(), "The name should be correctly set.");
    }

    @Test
    public void testSetAge() {
        customer.setAge(25);
        assertEquals(25, customer.getAge(), "The age should be correctly set.");
    }

    @Test
    public void testToString() {
        String expectedString = "John Doe (Age: 30)";
        assertEquals(expectedString, customer.toString(), "The toString method should return the correct string representation.");
    }

    @Test
    public void testEquality() {
        Customer anotherCustomer = new Customer("John Doe", 30);

        Customer differentCustomer = new Customer("Jane Doe", 25);
        assertFalse(customer.equals(differentCustomer), "The customers should not be considered equal when they have different name or age.");
    }
}
