import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility {

    private static final int MAX_ROW = 10;

    // Constructor
    private TwoDimRaggedArrayUtility() {
        // Utility class; no instantiation needed
    }

    // Method to read a ragged array from a file
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String[][] tempArray = new String[MAX_ROW][];
        int rowCount = 0;

        // Read file data into a temporary array
        while (scanner.hasNextLine() && rowCount < MAX_ROW) {
            String line = scanner.nextLine().trim();
            tempArray[rowCount] = line.split("\\s+");
            rowCount++;
        }
        scanner.close();

        // Create the actual ragged array
        double[][] raggedArray = new double[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            int columnCount = tempArray[i].length;
            raggedArray[i] = new double[columnCount];
            for (int j = 0; j < columnCount; j++) {
                raggedArray[i][j] = Double.parseDouble(tempArray[i][j]);
            }
        }

        return raggedArray;
    }

    // Method to write a ragged array to a file
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (double[] row : data) {
            for (int i = 0; i < row.length; i++) {
                writer.print(row[i]);
                if (i < row.length - 1) {
                    writer.print(" ");
                }
            }
            writer.println();
        }
        writer.close();
    }

    // Method to calculate the total of all elements in the array
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    // Method to calculate the average of all elements in the array
    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int elementCount = 0;
        for (double[] row : data) {
            elementCount += row.length;
        }
        return elementCount > 0 ? total / elementCount : 0;
    }

    // Method to get the total of a specific row
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double value : data[row]) {
            total += value;
        }
        return total;
    }

    // Method to get the total of a specific column
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    // Method to find the highest value in the entire array
    public static double getHighestInArray(double[][] data) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }

    // Method to find the lowest value in the entire array
    public static double getLowestInArray(double[][] data) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }
        return lowest;
    }

    // Method to find the highest value in a specific row
    public static double getHighestInRow(double[][] data, int row) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double value : data[row]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }

    // Method to find the index of the highest value in a specific row
    public static int getHighestInRowIndex(double[][] data, int row) {
        int highestIndex = -1;
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    // Method to find the highest value in a specific column
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] > highest) {
                highest = row[col];
            }
        }
        return highest;
    }

    // Method to find the lowest value in a specific column
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] < lowest) {
                lowest = row[col];
            }
        }
        return lowest;
    }
}


