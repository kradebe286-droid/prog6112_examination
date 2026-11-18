package assignment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ProductCalculationsTest {
    @Test void GetVat_WithValidData_ReturnsCorrectValue() {
        assertEquals(525.0, new ProductCalculations(3500).GetVat(), 0.001);
    }
    @Test void GetTotal_WithValidData_ReturnsCorrectValue() {
        assertEquals(4200.0, new ProductCalculations(3500).GetTotal(), 0.001);
    }
}
