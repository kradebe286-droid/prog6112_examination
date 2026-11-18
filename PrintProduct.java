package assignment;
public class PrintProduct {
    public void printReport(Product product) {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("********************************************");
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
        System.out.printf("AVERAGE PRODUCT SALES: %.0f%n", product.GetAverageProductSold());
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
        System.out.println("MOST POPULAR BY THREE-MONTH TOTAL: " + product.GetMostPopularByTotal());
    }
}
