package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.BillCalculator;

public class BillCalculatorTest {
    @Test
    public void testXLNoToppings() {
        assertEquals(17.25, BillCalculator.calculateTotal("XL", 0));
    }
    @Test
    public void testLWith2Toppings() {
        assertEquals(15.53, BillCalculator.calculateTotal("L", 2));
    }
    @Test
    public void testMWith5Toppings() {
        assertEquals(19.55, BillCalculator.calculateTotal("M", 5));
    }
    @Test
    public void testSWith1Topping() {
        assertEquals(10.93, BillCalculator.calculateTotal("S", 1));
    }
    @Test
    public void testInvalidSize() {
        assertEquals(0.0, BillCalculator.calculateTotal("XXL", 3));
    }
}
