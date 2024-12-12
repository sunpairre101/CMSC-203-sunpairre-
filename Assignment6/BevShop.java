

/*Class: CMSC203 CRN 20932


Program: Assignment #5
Instructor: Professor Ahmed Tarek 
Summary of Description: Assignment 6
Due Date: 12/11/2024
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Student’s Name: Sunpairre Tamene
*/
import java.util.ArrayList; 

public class BevShop implements BevShopInterfce { 
    private int numOfAlcoholicDrink = 0; 
    private final int MAX_ALCOHOL = 3; 
    private ArrayList<Order> orders; 
    private final int DRINKING_AGE = 21; 
    private Order currentOrder; 
    private int currentIndex = -1; 

    public BevShop() { 
        numOfAlcoholicDrink = 0; 
        orders = new ArrayList<>(); 
    } 

    public boolean validTime(int time) { 
        return time >= MIN_TIME && time <= MAX_TIME; 
    } 

    public boolean eligibleForMore() { 
        int count = currentOrder.findNumOfBeveType(TYPE.ALCOHOL); 
        return count < 3; 
    } 

    public boolean validAge(int age) { 
        return age > 21; 
    } 

    public boolean isValidAge(int age) { 
        return age >= DRINKING_AGE; 
    } 

    public boolean isEligibleForMore() { 
        return numOfAlcoholicDrink < MAX_ALCOHOL; 
    } 

    public void startNewOrder(int time, DAY day, String customerName, int customerAge) { 
        currentOrder = new Order(time, day, customerName, customerAge); 
        currentIndex++; 
        numOfAlcoholicDrink = 0; 
        orders.add(currentOrder); 
    } 

    public Order getCurrentOrder() { 
        return currentOrder; 
    } 

    public void processCoffeeOrder(String bevName, SIZE size, boolean shot, boolean syrup) { 
        orders.get(currentIndex).addNewBeverage(bevName, size, shot, syrup); 
    } 

    public void processAlcoholOrder(String bevName, SIZE size) { 
        orders.get(currentIndex).addNewBeverage(bevName, size); 
        numOfAlcoholicDrink++; 
    } 

    @Override 
    public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) { 
        if (isMaxFruit(numOfFruits)) { 
            throw new IllegalArgumentException("Number of fruits exceeds the maximum limit."); 
        } 
        getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein); 
    } 

    public int findOrder(int num) { 
        int ind = 0; 
        for (Order o : orders) { 
            if (o.getOrderNo() == num) 
                return ind; 
            ind++; 
        } 
        return -1; 
    } 

    public double totalOrderPrice(int num) { 
        int i = findOrder(num); 
        return orders.get(i).calcOrderTotal(); 
    } 

    public double totalMonthlySale() { 
        double total = 0; 
        for (Order o : orders) { 
            total += o.calcOrderTotal(); 
        } 
        return total; 
    } 

    public void sortOrders() { 
        for (int i = 0; i < orders.size(); i++) { 
            int min = i; 
            for (int j = i + 1; j < orders.size(); j++) { 
                if (orders.get(j).getOrderNo() < orders.get(min).getOrderNo()) { 
                    min = j; 
                } 
            } 
            Order temp = orders.get(min); 
            orders.set(min, orders.get(i)); 
            orders.set(i, temp); 
        } 
    } 

    public boolean isMaxFruit(int f) { 
        return f > 5; 
    } 

    public Order getOrderAtIndex(int i) { 
        return orders.get(i); 
    } 

    public int getNumOfAlcoholDrink() { 
        return numOfAlcoholicDrink; 
    } 

    public int getMaxOrderForAlcohol() { 
        return MAX_ALCOHOL; 
    } 

    public int getMinAgeForAlcohol() { 
        return DRINKING_AGE; 
    } 

    public int totalNumOfMonthlyOrders() { 
        return orders.size(); 
    } 

    public String toString() { 
        StringBuilder str = new StringBuilder(String.valueOf(totalMonthlySale())); 
        for (Order o : orders) { 
            str.append(o.getOrderNo()).append(o.toString()); 
        } 
        return str.toString(); 
    } 
}


