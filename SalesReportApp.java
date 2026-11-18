package assignment;
import java.util.Scanner;
public class SalesReportApp {
    public static void main(String[] args) {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = new int[names.length][3];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < names.length; i++) {
            for (int month = 0; month < 3; month++) {
                while (true) {
                    System.out.print("Enter number of sales for month " + (month + 1) + " for " + names[i] + " mattress: ");
                    if (input.hasNextInt()) {
                        int value = input.nextInt();
                        if (value >= 0) { sales[i][month] = value; break; }
                    } else input.next();
                    System.out.println("Please enter a whole number of zero or more.");
                }
            }
            System.out.println();
        }
        new PrintProduct().printReport(new Product(names, sales));
    }
}
