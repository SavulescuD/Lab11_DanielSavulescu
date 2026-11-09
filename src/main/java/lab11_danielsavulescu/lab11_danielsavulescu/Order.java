package lab11_danielsavulescu.lab11_danielsavulescu;

import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    public static final double CHICKEN_SALAD_PRICE = 6.5;
    public static final double TURKEY_SANDWICH_PRICE = 6.75;
    public static final double VEGETABLE_WRAP_PRICE = 6;
    public static final double GRILLED_CHEESE_PRICE = 5;
    
    public static final double COFFEE_PRICE = 1.5;
    public static final double TEA_PRICE = 1.5;
    public static final double SODA_PRICE = 2;
    public static final double JUICE_PRICE = 1.75;
    
    private static final Map<String, Double> ENTREES = new LinkedHashMap<>();
    private static final Map<String, Double> DRINKS = new LinkedHashMap<>();
    
    static {
        ENTREES.put("Chicken Salad", CHICKEN_SALAD_PRICE);
        ENTREES.put("Turkey Sandwich", TURKEY_SANDWICH_PRICE);
        ENTREES.put("Vegetable Wrap", VEGETABLE_WRAP_PRICE);
        ENTREES.put("Grilled Cheese", GRILLED_CHEESE_PRICE);
        
        DRINKS.put("Coffee", COFFEE_PRICE);
        DRINKS.put("Tea", TEA_PRICE);
        DRINKS.put("Soda", SODA_PRICE);
        DRINKS.put("Juice", JUICE_PRICE);
    }
    
    private String entree;
    private String drink;
    private String specialRequests = "";
    private boolean freeWater;
    
    public static String[] getEntreeNames() {
        return ENTREES.keySet().toArray(new String[0]);
    }

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = (specialRequests == null) ? "" : specialRequests;
    }

    public boolean isFreeWater() {
        return freeWater;
    }

    public void setFreeWater(boolean freeWater) {
        this.freeWater = freeWater;
    }
    
    public double getEntreePrice() {
        return ENTREES.getOrDefault(entree, 0.0);
    }
    
    public double getDrinkPrice() {
        return DRINKS.getOrDefault(drink, 0.0);
    }
    
    public double calculateTotal() {
        return getEntreePrice() + getDrinkPrice();
    }
    
    public boolean isComplete() {
        return entree != null && drink != null;
    }
}
