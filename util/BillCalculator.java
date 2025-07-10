package util;

public class BillCalculator {
    public static double calculateTotal(String size, int toppings) {
        double base = 0;
        switch (size) {
            case "XL": base = 15.0; break;
            case "L": base = 12.0; break;
            case "M": base = 10.0; break;
            case "S": base = 8.0; break;
            default: base = 0;
        }
        double toppingCost = toppings * 1.5;
        double subtotal = base + toppingCost;
        double hst = subtotal * 0.15;
        return Math.round((subtotal + hst) * 100.0) / 100.0;
    }
}
