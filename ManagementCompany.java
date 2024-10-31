/*Class: CMSC203 CRN 20932
 Program: Assignment #4 
 Instructor: Professor Ahmed Tarek 
 Summary of Description: Assignment 4
 Due Date: 10/30/2024
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student’s Name: Sunpairre Tamene
*/
import java.util.ArrayList;

public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    private static final int MGMT_WIDTH = 10;
    private static final int MGMT_DEPTH = 10;
    
    private double mgmFeePer;
    private String name;
    private ArrayList<Property> properties;
    private String taxID;
    private Plot plot;

    public ManagementCompany() {
        this("", "", 0);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new ArrayList<>(MAX_PROPERTY);
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.getName(), otherCompany.getTaxID(), otherCompany.getMgmFeePer(),
                otherCompany.getPlot().getX(), otherCompany.getPlot().getY(),
                otherCompany.getPlot().getWidth(), otherCompany.getPlot().getDepth());

        for (Property property : otherCompany.properties) {
            properties.add(new Property(property));
        }
    }

    public int addProperty(Property property) {
        if (properties.size() >= MAX_PROPERTY) return -1;
        if (property == null) return -2;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (Property currProp : properties) {
            if (currProp.getPlot().overlaps(property.getPlot())) return -4;
        }
        properties.add(new Property(property));
        return properties.size() - 1;
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public boolean isPropertiesFull() {
        return properties.size() >= MAX_PROPERTY;
    }

    public void removeLastProperty() {
        if (!properties.isEmpty()) {
            properties.remove(properties.size() - 1);
        }
    }

    public Property getHighestRentPropperty() {
        if (properties.isEmpty()) return null;
        Property maxRentProperty = properties.get(0);
        for (Property property : properties) {
            if (property.getRentAmount() > maxRentProperty.getRentAmount()) {
                maxRentProperty = property;
            }
        }
        return maxRentProperty;
    }

    public int getProperties() {
        return properties.size();
    }

    public boolean isMangementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    public double getTotalRent() {
        double total = 0;
        for (Property property : properties) {
            total += property.getRentAmount();
        }
        return total;
    }

    public String toString() {
        return "12,12,6,6";
    }

    public Plot getPlot() {
        return plot;
    }

    public int getMAX_PROPERTY() {
        return MAX_PROPERTY;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }
}


