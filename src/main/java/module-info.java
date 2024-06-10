module ustc.pde.scs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ustc.pde.scs to javafx.fxml;
    exports ustc.pde.scs;
    exports ustc.pde.scs.controller;
    exports ustc.pde.scs.controller.sub;
    opens ustc.pde.scs.controller to javafx.fxml;
}