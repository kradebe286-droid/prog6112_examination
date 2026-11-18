package assignment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ProductTest {
    private Product sample() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {{25,18,20},{15,10,12},{18,15,20}};
        return new Product(names, sales);
    }
    @Test void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, sample().GetTotalProductsSold());
    }
    @Test void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(17.0, sample().GetAverageProductSold(), 0.001);
    }
}
