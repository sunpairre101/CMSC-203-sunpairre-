import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtilityTestStudent {

    @Test
    public void testReadFile() throws FileNotFoundException {
        File inputFile = new File("testInput.txt");
        PrintWriter writer = new PrintWriter(inputFile);
        writer.println("1.0 2.0 3.0");
        writer.println("4.0 5.0");
        writer.println("6.0 7.0 8.0 9.0");
        writer.close();

        double[][] result = TwoDimRaggedArrayUtility.readFile(inputFile);
        assertArrayEquals(new double[] {1.0, 2.0, 3.0}, result[0], 0.001);
        assertArrayEquals(new double[] {4.0, 5.0}, result[1], 0.001);
        assertArrayEquals(new double[] {6.0, 7.0, 8.0, 9.0}, result[2], 0.001);
    }

    @Test
    public void testWriteToFile() throws FileNotFoundException {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };
        File outputFile = new File("testOutput.txt");

        TwoDimRaggedArrayUtility.writeToFile(data, outputFile);

        double[][] result = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertArrayEquals(data[0], result[0], 0.001);
        assertArrayEquals(data[1], result[1], 0.001);
        assertArrayEquals(data[2], result[2], 0.001);
    }

    @Test
    public void testGetTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };
        double total = TwoDimRaggedArrayUtility.getTotal(data);
        assertEquals(45.0, total, 0.001);
    }

    @Test
    public void testGetAverage() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };
        double average = TwoDimRaggedArrayUtility.getAverage(data);
        assertEquals(5.0, average, 0.001);
    }

    @Test
    public void testGetRowTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };
        double rowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 2);
        assertEquals(30.0, rowTotal, 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };
        double columnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 2);
        assertEquals(11.0, columnTotal, 0.001);
    }

    @Test
    public void testGetHighestInArray() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };
        double highest = TwoDimRaggedArrayUtility.getHighestInArray(data);
        assertEquals(9.0, highest, 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        double[][] data = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0},
            {6.0, 7.0, 8.0, 9.0}
        };
        double lowest = TwoDimRaggedArrayUtility.getLowestInArray(data);
        assertEquals(1.0, lowest, 0.001);
    }
}
