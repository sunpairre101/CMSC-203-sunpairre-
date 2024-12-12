/*Class: CMSC203 CRN 20932
 Program: Assignment #5
 Instructor: Professor Ahmed Tarek 
 Summary of Description: Assignment 6
 Due Date: 12/11/24
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student’s Name: Sunpairre Tamene
*/
/**
 * Represents a customer with a name and age.
 */
public class Customer {
    private String name;
    private int age;

    /**
     * Constructor to initialize the name and age.
     * @param name the name of the customer
     * @param age the age of the customer
     */
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Copy constructor to create a new Customer from another Customer.
     * @param other the customer to copy
     */
    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }

    /**
     * Getter for the name.
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name.
     * @param name the new name of the customer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the age.
     * @return the age of the customer
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter for the age.
     * @param age the new age of the customer
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Checks if the customer is eligible for alcohol.
     * @return true if the customer is 21 or older, false otherwise
     */
    public boolean isEligibleForAlcohol() {
        return age >= 21;
    }

    /**
     * Returns a string representation of the Customer object.
     * @return a string representation of the Customer
     */
    @Override
    public String toString() {
        return name + " (Age: " + age + ")";
    }

    /**
     * Checks if this customer is equal to another object.
     * @param obj the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return age == customer.age && name.equals(customer.name);
    }

    /**
     * Returns a hash code value for the Customer object.
     * @return a hash code value for the Customer
     */
    
    
}
