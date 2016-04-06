package testass2;

import java.util.*;

public class PascalsTriangle {

    public static final int FIELD_SIZE = 4; // width for each int

    public static void main(String[] args) {

        // Reads in user selected number of rows to display
        System.out.println("This program Will print Pascals amazing triangle" + "\n");
        Scanner console = new Scanner(System.in);
        System.out.print("How many rows do ya want? ");
        // Assigns user choice to choice variable and passes it to the writeTable method
        int choice = console.nextInt();
        writeTable(choice - 1);
    }
// writes given number of given characters to populate the rows
    public static void writeChars(char ch, int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print(ch);
        }
    }
    // writes complete table, using leading spaces to center each row
    // @param maxRow is the chosen line-1
    public static void writeTable(int maxRow) {
        for (int row = 0; row <= maxRow; row++) {
            // Loop to write the correct amount or rows, and to pass the correct
            // characters to be written for each row to the writeChars method.
            writeChars(' ', (maxRow - row) * FIELD_SIZE / 2);
            writeRow(row);
        }
    }

// writes given row of Pascal's triangle
    public static void writeRow(int number) {
        int value = 1;
        System.out.print("1");
        // Prints out the desired row, %4d used to format numbers
        for (int i = 1; i <= number; i++) {
            value = value * (number - i + 1) / i;
            System.out.printf("%4d", value);
        }
        System.out.println();
    }

    }

