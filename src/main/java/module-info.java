module ustc.pde.scs {
    requires javafx.controls;
    requires javafx.fxml;


    opens ustc.pde.scs to javafx.fxml;
    exports ustc.pde.scs;
}