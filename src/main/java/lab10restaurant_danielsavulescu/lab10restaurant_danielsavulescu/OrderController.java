package lab10restaurant_danielsavulescu.lab10restaurant_danielsavulescu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author 2540408
 */
public class OrderController implements Initializable {

    @FXML
    private ListView<String> entreeSelection;
    @FXML
    private RadioButton coffee;
    @FXML
    private RadioButton tea;
    @FXML
    private RadioButton soda;
    @FXML
    private RadioButton juice;
    @FXML
    private Label totalOrder;
    @FXML
    private TextField specialRequests;
    @FXML
    private ToggleGroup drinks;
    @FXML
    private CheckBox freeWater;
    
    private Alert aboutInfo;
    private double selectedEntreePrice = 0;
    private double selectedDrinkPrice;
    private boolean freeWaterSelected;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        entreeSelection.getItems().addAll("Chicken Salad", "Turkey Sandwich", "Vegetable Wrap", "Grilled Cheese");
        coffee.setToggleGroup(drinks);
        tea.setToggleGroup(drinks);
        soda.setToggleGroup(drinks);
        juice.setToggleGroup(drinks);
        aboutInfo = new Alert(AlertType.INFORMATION);
        aboutInfo.setTitle("About");
        aboutInfo.setHeaderText("Application Information");
        aboutInfo.setContentText("Application name: Restaurant Order application. Developper: Daniel Savulescu. Version 1.1");
        
        coffee.setUserData(Order.COFFEE_PRICE);
        tea.setUserData(Order.TEA_PRICE);
        soda.setUserData(Order.SODA_PRICE);
        juice.setUserData(Order.JUICE_PRICE);
        
        switch (entreeSelection.getSelectionModel().getSelectedItem()) {
            case "Chicken Salad": selectedEntreePrice += Order.CHICKEN_SALAD_PRICE; break;
            case "Turkey Sandwich": selectedEntreePrice += Order.TURKEY_SANDWICH_PRICE; break;
            case "Vegetable Wrap": selectedEntreePrice += Order.VEGETABLE_WRAP_PRICE; break;
            case "Grilled Cheese": selectedEntreePrice += Order.GRILLED_CHEESE_PRICE; break;
            default: selectedEntreePrice += 0;    
        }
        
        drinks.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle != null) {
                selectedDrinkPrice = (double) newToggle.getUserData();
            }
        });
        
        if (freeWater.isSelected()) {
            freeWaterSelected = true;
            
        }
        
        totalOrder.setText(String.format("Total: $f", Order.calculateOrder(selectedEntreePrice, selectedDrinkPrice)));
    }    

    @FXML
    private void placeOrder(ActionEvent event) {
        
    }

    @FXML
    private void clearOrder(ActionEvent event) {
        coffee.setSelected(false);
        tea.setSelected(false);
        soda.setSelected(false);
        juice.setSelected(false);
        entreeSelection.getSelectionModel().clearSelection();
        specialRequests.clear();
        totalOrder.setText("Total: $0.00");
        freeWater.setSelected(false);
        
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(1); 
    }

    @FXML
    private void clearEntree(ActionEvent event) {
        entreeSelection.getSelectionModel().clearSelection();
    }

    @FXML
    private void clearDrink(ActionEvent event) {
        drinks.getToggles().clear();
    }

    @FXML
    private void clearSpecialRequest(ActionEvent event) {
        specialRequests.clear();
    }

    @FXML
    private void about(ActionEvent event) {
        aboutInfo.showAndWait();
    }
}
