package assignment;
public class Product implements IProduct {
    private final String[] names;
    private final int[][] sales;
    public Product(String[] names, int[][] sales) {
        if (names == null || sales == null || names.length == 0 || names.length != sales.length) throw new IllegalArgumentException("Invalid sales data");
        this.names = names.clone();
        this.sales = new int[sales.length][];
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] == null || sales[i].length != 3) throw new IllegalArgumentException("Each product needs three months");
            this.sales[i] = sales[i].clone();
            for (int amount : sales[i]) if (amount < 0) throw new IllegalArgumentException("Sales cannot be negative");
        }
    }
    @Override public int GetTotalProductsSold() {
        int total = 0;
        for (int[] months : sales) for (int amount : months) total += amount;
        return total;
    }
    @Override public double GetAverageProductSold() {
        // The sample report averages all nine monthly values.
        return (double) GetTotalProductsSold() / (sales.length * 3);
    }
    @Override public String GetMostPopularProduct() {
        // The sample chooses the highest single monthly sale.
        int best = -1;
        String name = "";
        for (int i = 0; i < sales.length; i++) for (int month : sales[i]) {
            if (month > best) { best = month; name = names[i]; }
        }
        return name + " (" + best + ")";
    }
    public String GetMostPopularByTotal() {
        int best = -1;
        String name = "";
        for (int i = 0; i < sales.length; i++) {
            int sum = 0;
            for (int value : sales[i]) sum += value;
            if (sum > best) { best = sum; name = names[i]; }
        }
        return name + " (" + best + ")";
    }
}
