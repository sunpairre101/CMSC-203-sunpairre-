/*Class: CMSC203 CRN 20932
 Program: Assignment #6
 Instructor: Professor Ahmed Tarek 
 Summary of Description: Assignment 6
 Due Date: 12/11/24
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student’s Name: Sunpairre Tamene
*/

import java.util.Objects;

public class Smoothie extends Beverage {
    private int numberOfFruits;
    private boolean proteinPowder;

    // Cost Constants for fruits and protein powder
    public static final double FRUIT_COST = 0.5;
    public static final double PROTEIN_COST = 1.5;

    public Smoothie(String name, SIZE size, int numberOfFruits, boolean proteinPowder) {
        super(name, TYPE.SMOOTHIE, size);
        if (numberOfFruits < 0) {
            throw new IllegalArgumentException("Number of fruits cannot be negative.");
        }
        this.numberOfFruits = numberOfFruits;
        this.proteinPowder = proteinPowder;
    }

    // Calculate price based on size, number of fruits, and protein powder
    @Override
    public double calcPrice() {
        double price = BASE_PRICE + SIZE_PRICE * size.ordinal();  // Size-dependent price
        price += FRUIT_COST * numberOfFruits;  // Add fruit cost
        if (proteinPowder) price += PROTEIN_COST;  // Add protein powder cost
        return price;
    }

    // Convert the object to a readable string
    @Override
    public String toString() {
        return super.toString() + (proteinPowder ? " + Protein Powder" : "") 
               + " - Fruits: " + numberOfFruits 
               + " - $" + String.format("%.2f", calcPrice());
    }

    // Override equals method to compare Smoothie objects
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (this == obj) return true;
        Smoothie smoothie = (Smoothie) obj;
        return numberOfFruits == smoothie.numberOfFruits && proteinPowder == smoothie.proteinPowder;
    }

    // Override hashCode for consistency with equals
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfFruits, proteinPowder);
    }

    // Getters and Setters for the number of fruits and protein powder
    public int getNumOfFruits() {
        return numberOfFruits;
    }

    public void setNumOfFruits(int numberOfFruits) {
        if (numberOfFruits < 0) {
            throw new IllegalArgumentException("Number of fruits cannot be negative.");
        }
        this.numberOfFruits = numberOfFruits;
    }

    public boolean isProteinPowder() {
        return proteinPowder;
    }

    public void setProteinPowder(boolean proteinPowder) {
        this.proteinPowder = proteinPowder;
    }

    // The getAddProtien method now reflects the proteinPowder field
    public boolean getAddProtien() {
        return proteinPowder;
    }
}
