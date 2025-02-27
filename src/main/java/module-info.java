module com.currencycalc.currencycalculatorjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.google.gson;
    requires java.net.http;

    opens com.currencycalc.currencycalculatorjavafx to javafx.fxml, com.google.gson;
    opens com.currencycalc.currencycalculatorjavafx.utils to javafx.fxml, com.google.gson;
    opens com.currencycalc.currencycalculatorjavafx.model to javafx.fxml, com.google.gson;

    exports com.currencycalc.currencycalculatorjavafx;
    exports com.currencycalc.currencycalculatorjavafx.utils;
    exports com.currencycalc.currencycalculatorjavafx.model;
}
