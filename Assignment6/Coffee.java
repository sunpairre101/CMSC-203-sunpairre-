/*Class: CMSC203 CRN 20932
 Program: Assignment #6
 Instructor: Professor Ahmed Tarek 
 Summary of Description: Assignment 6
 Due Date: 12/11/24
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student’s Name: Sunpairre Tamene
*/
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;

    public static final double EXTRA_SHOT_COST = 0.5;
    public static final double EXTRA_SYRUP_COST = 0.5;

    public Coffee(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
        super(name, TYPE.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = BASE_PRICE + SIZE_PRICE * size.ordinal();
        if (extraShot) price += EXTRA_SHOT_COST;
        if (extraSyrup) price += EXTRA_SYRUP_COST;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + (extraShot ? " + Extra Shot" : "") + (extraSyrup ? " + Extra Syrup" : "") + " - $" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (this == obj) return true;
        Coffee coffee = (Coffee) obj;
        return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
    }

    // Getters and Setters
    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }

    // Adding the getAddProtein(), getExtraShot(), and getExtraSyrup() methods
    

    public boolean getExtraShot() {
        return extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }
}

