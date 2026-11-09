package lab11_danielsavulescu.lab11_danielsavulescu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OrderSummaryController {

    @FXML
    private Button closeButton;

    @FXML
    private Label drinkLabel;

    @FXML
    private Label entreeLabel;

    @FXML
    private Label specialRequestLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private Label waterLabel;
    
    public void setOrder(Order order) {
        entreeLabel.setText(String.format("Entree:   %s  $%.2f", order.getEntree(), order.getEntreePrice()));
        drinkLabel.setText(String.format("Drink:   %s  $%.2f", order.getDrink(), order.getDrinkPrice()));
        waterLabel.setText("Water:   " + (order.isFreeWater() ? "Yes" : "No"));
        String req = order.getSpecialRequests().trim();
        specialRequestLabel.setText("Special Requests: " + (req.isEmpty() ? "None" : req));
        totalLabel.setText(String.format("Total: $%.2f", order.calculateTotal()));
    }
    
    @FXML
    void closeButtonClicked(ActionEvent event) {
        closeButton.getScene().getWindow().hide();
    }
}
