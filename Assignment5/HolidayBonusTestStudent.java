import org.junit.Test;
import static org.junit.Assert.*;

public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus() {
        double[][] sales = {
            {1000, 2000, 3000},
            {4000, 5000},
            {6000, 7000, 8000, 9000}
        };

        double[] expectedBonuses = {
            4000.0, // Row 0: two OTHER_BONUS + one LOW_BONUS
            8000.0, // Row 1: two OTHER_BONUS + one HIGH_BONUS
            15000.0 // Row 2: three HIGH_BONUS + one OTHER_BONUS
        };

        double[] bonuses = HolidayBonus.calculateHolidayBonus(sales);

    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] sales = {
            {1000, 2000, 3000},
            {4000, 5000},
            {6000, 7000, 8000, 9000}
        };

        double expectedTotalBonus = 27000.0; // Sum of all expected bonuses

        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(sales);

        assertEquals(expectedTotalBonus, totalBonus, 0.001);
    }

    @Test
    public void testNegativeSales() {
        double[][] sales = {
            {1000, -2000, 3000},
            {-4000, 5000},
            {6000, -7000, 8000, 9000}
        };

        double[] expectedBonuses = {
            3000.0, // Row 0: one LOW_BONUS + one OTHER_BONUS
            5000.0, // Row 1: one HIGH_BONUS
            12000.0 // Row 2: two HIGH_BONUS + one OTHER_BONUS
        };

        double[] bonuses = HolidayBonus.calculateHolidayBonus(sales);

    }

    @Test
    public void testEmptySales() {
        double[][] sales = new double[0][];
        double[] expectedBonuses = {};

        double[] bonuses = HolidayBonus.calculateHolidayBonus(sales);

        assertArrayEquals(expectedBonuses, bonuses, 0.001);

        double expectedTotalBonus = 0.0;
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(sales);

        assertEquals(expectedTotalBonus, totalBonus, 0.001);
    }

    @Test
    public void testUnevenRows() {
        double[][] sales = {
            {1000, 2000},
            {3000},
            {4000, 5000, 6000}
        };

        double[] expectedBonuses = {
            4000.0, // Row 0: one LOW_BONUS + one OTHER_BONUS
            5000.0, // Row 1: one OTHER_BONUS
            12000.0 // Row 2: two HIGH_BONUS + one OTHER_BONUS
        };

        double[] bonuses = HolidayBonus.calculateHolidayBonus(sales);


    }
}

