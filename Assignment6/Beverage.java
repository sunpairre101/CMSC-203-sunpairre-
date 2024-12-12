/*Class: CMSC203 CRN 20932
 Program: Assignment #5
 Instructor: Professor Ahmed Tarek 
 Summary of Description: Assignment 6
 Due Date: 12/11/24
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student’s Name: Sunpairre Tamene
*/
public abstract class Beverage {
    protected String name;
    protected TYPE type;
    protected SIZE size;
    
    // Constants for base price and size price increments
    public static final double BASE_PRICE = 2.0;
    public static final double SIZE_PRICE = 1.0;

    // Constructor to initialize the beverage with name, type, and size
    public Beverage(String name, TYPE type, SIZE size) {
        if (name == null || type == null || size == null) {
            throw new IllegalArgumentException("Name, type, and size cannot be null");
        }
        this.name = name;
        this.type = type;
        this.size = size;
    }

    // Abstract method to be implemented by subclasses for calculating the price
    public abstract double calcPrice();

    // Method to calculate and add the price based on the size
    public double addSizePrice() {
        double totalPrice = BASE_PRICE;
        
        // Add size-based price increment
        if (size == SIZE.MEDIUM) {
            totalPrice += SIZE_PRICE;
        } else if (size == SIZE.LARGE) {
            totalPrice += SIZE_PRICE * 2; // Larger sizes add more to the cost
        }
        
        return totalPrice;
    }

    // Method to represent the beverage as a string (including name and size)
    @Override
    public String toString() {
        return name + " (" + size + ")";
    }

    // Overridden equals method to compare two beverage objects based on name, type, and size
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Beverage beverage = (Beverage) obj;
        return name.equals(beverage.name) && type == beverage.type && size == beverage.size;
    }

    // Getter for beverage name
    public String getBevName() {
        return name;
    }

    // Getter and Setter for beverage name
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for beverage type
    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    // Getter and Setter for beverage size
    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }

    // Getter for base price
    public double getBasePrice() {
        return BASE_PRICE;
    }
}
