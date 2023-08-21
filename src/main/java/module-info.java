module com.bitscoder.javadesktopsudokudemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.bitscoder.javadesktopsudokudemo to javafx.fxml;
    exports com.bitscoder.javadesktopsudokudemo;
}