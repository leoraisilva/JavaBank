module com.bank.javafxbank {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.bank.javafxbank to javafx.fxml;
    exports com.bank.javafxbank;
    exports com.bank.javafxbank.Control to javafx.fxml;
}