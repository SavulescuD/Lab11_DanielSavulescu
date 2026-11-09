module lab10restaurant_danielsavulescu.lab10restaurant_danielsavulescu {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens lab10restaurant_danielsavulescu.lab10restaurant_danielsavulescu to javafx.fxml;
    exports lab10restaurant_danielsavulescu.lab10restaurant_danielsavulescu;
}
