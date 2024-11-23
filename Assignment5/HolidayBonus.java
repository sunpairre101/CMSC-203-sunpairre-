public class HolidayBonus {

    // Constants for bonus amounts
    private static final double HIGH_BONUS = 5000.0; 
    private static final double LOW_BONUS = 1000.0;  
    private static final double OTHER_BONUS = 2000.0; 

    
    public static double[] calculateHolidayBonus(double[][] sales) {
        double[] bonuses = new double[sales.length];

        for (int col = 0; col < getMaxColumns(sales); col++) {
            double highest = TwoDimRaggedArrayUtility.getHighestInColumn(sales, col);
            double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(sales, col);

            for (int row = 0; row < sales.length; row++) {
                if (col < sales[row].length) {
                    double sale = sales[row][col];

                    if (sale < 0) {
                        // No bonus for negative sales
                        continue;
                    } else if (sale == highest) {
                        bonuses[row] += HIGH_BONUS;
                    } else if (sale == lowest) {
                        bonuses[row] += LOW_BONUS;
                    } else {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }

        return bonuses;
    }

  
    public static double calculateTotalHolidayBonus(double[][] sales) {
        double totalBonus = 0;
        double[] bonuses = calculateHolidayBonus(sales);

        for (double bonus : bonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }

   
    private static int getMaxColumns(double[][] sales) {
        int maxColumns = 0;
        for (double[] row : sales) {
            if (row.length > maxColumns) {
                maxColumns = row.length;
            }
        }
        return maxColumns;
    }
}
