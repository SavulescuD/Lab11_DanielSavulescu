package lab11_danielsavulescu.lab11_danielsavulescu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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
    private final Order order = new Order();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        entreeSelection.getItems().addAll(Order.getEntreeNames());
        
        coffee.setUserData("Coffee");
        tea.setUserData("Tea");
        soda.setUserData("Soda");
        juice.setUserData("Juice");
        
        aboutInfo = new Alert(AlertType.INFORMATION);
        aboutInfo.setTitle("About");
        aboutInfo.setHeaderText("Application Information");
        aboutInfo.setContentText("Application name: Restaurant Order application. \n"
                + "Developer: Daniel Savulescu \n" 
                + "Version 1.1");
        
        entreeSelection.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
            order.setEntree(newV);
            updateTotal();
        });
        
        drinks.selectedToggleProperty().addListener((obs, oldT, newT) -> {
            order.setDrink(newT == null ? null : newT.getUserData().toString());
            updateTotal();
        });
        
        specialRequests.textProperty().addListener((obs, oldV, newV) -> {
            order.setSpecialRequests(newV);
        });
        
        freeWater.selectedProperty().addListener((obs, oldV, newV) -> {
            order.setFreeWater(newV);
        });
    }

    private void updateTotal() {
        totalOrder.setText(String.format("Total: $%.2f", order.calculateTotal()));
    }

    @FXML
    private void placeOrder(ActionEvent event) {
        if (!order.isComplete()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Incomplete Order");
            alert.setHeaderText("Missing Selection");
            alert.setContentText("Please select one entree and one drink before placing your order");
            alert.showAndWait();
            return;
        }
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderSummary.fxml"));
            Parent root = loader.load();
            OrderSummaryController summary = loader.getController();
            summary.setOrder(order);
            
            Stage stage = new Stage();
            stage.setTitle("Order Summary");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            new Alert(AlertType.ERROR, "Could not open the order summary: " + e.getMessage()).showAndWait();
        }
    }

    @FXML
    private void clearOrder(ActionEvent event) {
        entreeSelection.getSelectionModel().clearSelection();
        drinks.selectToggle(null);
        specialRequests.clear();
        freeWater.setSelected(false);
        updateTotal();
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void clearEntree(ActionEvent event) {
        entreeSelection.getSelectionModel().clearSelection();
    }

    @FXML
    private void clearDrink(ActionEvent event) {
        drinks.selectToggle(null);
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
