/*Class: CMSC203 CRN 20932
 Program: Assignment #6
 Instructor: Professor Ahmed Tarek 
 Summary of Description: Assignment 6
 Due Date: 12/11/2024
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student’s Name: Sunpairre Tamene
*/
public class Alcohol extends Beverage {
    private boolean isWeekend; // Indicates whether the drink is offered during the weekend

    // Constants for additional charges
    private static final double WEEKEND_COST = 0.6;
    private static final double MEDIUM_SIZE_COST = 1.0;
    private static final double LARGE_SIZE_COST = 2.0;

    // Constructor with all parameters
    public Alcohol(String bevName, SIZE size, boolean isWeekend) {
        super(bevName, TYPE.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    // Constructor with default value for isWeekend
    public Alcohol(String bevName, SIZE size) {
        this(bevName, size, false); // Default value for isWeekend is false
    }

    // Calculates the price of the alcohol
    @Override
    public double calcPrice() {
        double price = getBasePrice();
        
        // Add weekend cost if applicable
        if (isWeekend) {
            price += WEEKEND_COST;
        }
        
        // Add cost based on size
        switch (getSize()) {
            case MEDIUM:
                price += MEDIUM_SIZE_COST;
                break;
            case LARGE:
                price += LARGE_SIZE_COST;
                break;
            default:
                break; // No additional charge for small size
        }
        return price;
    }

    // String representation of the Alcohol beverage, includes name, size, weekend special, and price
    @Override
    public String toString() {
        // Format the price to two decimal places for consistency
        return String.format("Alcohol [Name=%s, Size=%s, Weekend Special=%s, Price=%.2f]", 
                             getBevName(), getSize(), (isWeekend ? "Yes" : "No"), calcPrice());
    }

    // Checks if this Alcohol object equals another beverage
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alcohol other = (Alcohol) obj;
        return super.equals(obj) && isWeekend == other.isWeekend;
    }

    // Checks if the alcohol is offered on the weekend
    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }
}

