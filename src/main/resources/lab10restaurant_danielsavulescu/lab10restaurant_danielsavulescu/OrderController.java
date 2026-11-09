package lab10restaurant_danielsavulescu.lab10restaurant_danielsavulescu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author 2540408
 */
public class OrderController implements Initializable {

    @FXML
    private ListView<?> entreeSelection;
    @FXML
    private RadioButton coffee;
    @FXML
    private RadioButton tea;
    @FXML
    private RadioButton soda;
    @FXML
    private RadioButton juice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void placeOrder(ActionEvent event) {
    }

    @FXML
    private void clearOrder(ActionEvent event) {
    }

    @FXML
    private void exit(ActionEvent event) {
    }

    @FXML
    private void clearEntree(ActionEvent event) {
    }

    @FXML
    private void clearDrink(ActionEvent event) {
    }

    @FXML
    private void clearSpecialRequest(ActionEvent event) {
    }

    @FXML
    private void about(ActionEvent event) {
    }
    
}
