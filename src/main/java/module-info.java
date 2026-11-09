module lab10restaurant_danielsavulescu.lab10restaurant_danielsavulescu {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens lab11_danielsavulescu.lab11_danielsavulescu to javafx.fxml;
    exports lab11_danielsavulescu.lab11_danielsavulescu;
}
