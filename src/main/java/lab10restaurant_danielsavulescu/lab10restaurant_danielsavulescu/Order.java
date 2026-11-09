package lab10restaurant_danielsavulescu.lab10restaurant_danielsavulescu;

/**
 *
 * @author 2540408
 */
public class Order {
    public static final double CHICKEN_SALAD_PRICE = 6.5;
    public static final double TURKEY_SANDWICH_PRICE = 6.75;
    public static final double VEGETABLE_WRAP_PRICE = 6;
    public static final double GRILLED_CHEESE_PRICE = 5;
    
    public static final double COFFEE_PRICE = 1.5;
    public static final double TEA_PRICE = 1.5;
    public static final double SODA_PRICE = 2;
    public static final double JUICE_PRICE = 1.75;
    
    public static double calculateOrder(double entreePrice, double drinksPrice) {
        return entreePrice + drinksPrice;
    }
}
