package ustc.pde.scs.controller;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import ustc.pde.scs.SCSApplication;
import ustc.pde.scs.entity.user.User;
import ustc.pde.scs.sql.implementation.major.MajorDAOImpl;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

import java.io.IOException;
import java.util.Optional;

public class StartViewController {
    public AnchorPane mainPane;
    public AnchorPane loginPanel;
    public AnchorPane registerPanel;


    public TextField loginID;
    public PasswordField loginPassword;
    public TextField registerID;
    public TextField registerName;
    public TextField registerMajor;
    public CheckBox male;
    public CheckBox female;
    public PasswordField registerPassword;
    public PasswordField confirmedPassword;




    public Button confirmButton;


    public Label forgetPassword;
    public Button closeButton;

    public void initialize(){
        cleanLoginPanel();
        cleanRegisterPanel();
    }

    public void onLoginConfirm(ActionEvent actionEvent) throws IOException {
        String rawID = loginID.getText();
        String rawPassword = loginPassword.getText();

        if(!checkIDFormat(rawID)) {
            controlAlert(STR."账号[\{rawID}]不存在！", "输入错误", Alert.AlertType.ERROR);
            controlAnimation(confirmButton);
            return;
        }
        UserDAOImpl userDAO = new UserDAOImpl();
        var user = userDAO.getObject(rawID);
        if (user == null) {
            var result = controlAlert(STR."账号[\{rawID}]不存在！\n是否注册？", "登录失败", Alert.AlertType.ERROR);
            if (result.get() == ButtonType.OK) {
                cleanRegisterPanel();
                registerID.setText(rawID);
                onSwitchToRegister(actionEvent);
            }
            return;
        }
        if (user.getPassword().equals(rawPassword)) {
            var result = controlAlert("√" + rawID + "," + rawPassword, "登录成功", Alert.AlertType.INFORMATION);
            if (result.get() == ButtonType.OK) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ustc/pde/scs/fxml/listview.fxml"));
                Parent root = loader.load();

                var stage = SCSApplication.primaryStage;
                stage.setTitle("USTC SCS");
                stage.setResizable(false);
                stage.setScene(new Scene(root, 1920, 1080));
                stage.show();
                ListViewController controller = loader.getController();
                controller.initialize(rawID);
            }
        }
        else {
            controlAlert("密码输入错误！", "登录失败", Alert.AlertType.ERROR);
            controlAnimation(confirmButton);
        }
    }

    public void onRegisterConfirm(ActionEvent actionEvent) {
        String rawID = registerID.getText();
        String rawName = registerName.getText();
        String rawMajor = registerMajor.getText();
        String rawPassword = registerPassword.getText();
        if(!checkIDFormat(rawID)) {
            controlAlert(STR."账号[\{rawID}]格式不合法", "输入错误", Alert.AlertType.ERROR);
            registerID.setText("");
            return;
        }
        if (!checkNameFormat(rawName)) {
            controlAlert(STR."姓名[\{rawName}]格式不合法", "输入错误", Alert.AlertType.ERROR);
            registerName.setText("");
            return;
        }
        MajorDAOImpl majorDAO = new MajorDAOImpl();
        //TODO
        if(false){
            controlAlert(STR."专业[\{rawMajor}]不存在", "输入错误", Alert.AlertType.ERROR);
            registerMajor.setText("");
            return;
        }
        if(!rawPassword.equals(confirmedPassword.getText())){
            controlAlert("前后密码输入不一致", "输入错误", Alert.AlertType.ERROR);
            registerPassword.setText("");
            confirmedPassword.setText("");
            return;
        }
        User user = new User();
        user.setID(rawID);
        user.setName(rawName);
        user.setPassword(rawPassword);
        UserDAOImpl userDAO = new UserDAOImpl();
        try {
            boolean succeed = userDAO.insert(user);
            var result = controlAlert(succeed ?
                            STR."√\{rawID},\{rawName},注册成功！\n去登录？"
                            : "注册失败！此账号已存在！\n去登录？",
                    "提示",
                    Alert.AlertType.INFORMATION);
            if (result.get() == ButtonType.OK) {
                cleanLoginPanel();
                loginID.setText(rawID);
                onSwitchToLogin(actionEvent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void OnForgetPassword(MouseEvent mouseEvent) {
    }




    public void onSwitchToLogin(ActionEvent actionEvent) {
        if(loginPanel.isVisible()){
            PanelAnimation(loginPanel,0.0,1.0,100,5);
        }
        else {
            cleanRegisterPanel();
            registerPanel.setVisible(false);
            loginPanel.setVisible(true);
            PanelAnimation(loginPanel, 256, -770, 256, 391, 0.5, 0);
        }
    }
    public void onSwitchToRegister(ActionEvent actionEvent) {
        if(registerPanel.isVisible()){
            PanelAnimation(registerPanel,0.0,1.0,100,5);
        }
        else {
            cleanLoginPanel();
            registerPanel.setVisible(true);
            loginPanel.setVisible(false);
            PanelAnimation(registerPanel, 256, -770, 256, 391, 0.5, 0);
        }
    }
    public void OnSwitchToAbout(ActionEvent actionEvent) {
    }




    public void checkGenderFemale(ActionEvent actionEvent) {
        male.setSelected(!female.isSelected());
    }

    public void checkGenderMale(ActionEvent actionEvent) {
        female.setSelected(!male.isSelected());
    }





    public void OnClose(ActionEvent actionEvent) {
    }





    private void cleanLoginPanel(){
        loginID.setText("");
        loginPassword.setText("");
    }
    private void cleanRegisterPanel(){
        registerID.setText("");
        registerName.setText("");
        registerMajor.setText("");
        registerPassword.setText("");
        confirmedPassword.setText("");
        male.setSelected(true);
        female.setSelected(false);
    }




    private boolean checkIDFormat(String rawID){
        // 合法ID格式
        return rawID.matches("PB\\d{8}") || rawID.matches("TA\\d{3}") || rawID.equals("root");
    }
    private boolean checkNameFormat(String rawName){
        return rawName.matches("[a-zA-Z\\u4e00-\\u9fa5]+");
    }




    private Optional<ButtonType> controlAlert(String text, String title, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        return alert.showAndWait();
    }
    private void controlAnimation(Control con){
        Path path = new Path();
        double x = con.getScaleX() + con.getWidth() / 2;
        double y = con.getScaleY() + con.getHeight() / 2;
        path.getElements().add(new MoveTo(x, y));
        path.getElements().add(new LineTo(x - 20, y));
        path.getElements().add(new LineTo(x + 20, y));
        path.getElements().add(new LineTo(x + 20, y));
        path.getElements().add(new LineTo(x - 20, y));
        path.getElements().add(new LineTo(x - 20, y));
        path.getElements().add(new LineTo(x + 20, y));
        path.getElements().add(new LineTo(x, y));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(0.3));
        pathTransition.setPath(path);
        pathTransition.setNode(con);
        pathTransition.setCycleCount(1);
        pathTransition.play();
    }

    public void PanelAnimation(AnchorPane con, double starOpacity, double endOpacity, int time, int playtimes){
        FadeTransition ft = new FadeTransition(Duration.millis(time), con);
        ft.setFromValue(starOpacity);
        ft.setToValue(endOpacity);
        ft.setCycleCount(playtimes);//Timeline.INDEFINITE
        ft.setAutoReverse(true);
        ft.play();
    }
    void PanelAnimation(AnchorPane con, double starX, double starY, double endX, double endY, double time, double step){
        Path path = new Path();
        path.getElements().add(new MoveTo(starX,starY));
        path.getElements().add(new LineTo(starX,starY+step));
        path.getElements().add(new LineTo(endX,endY-step));
        path.getElements().add(new LineTo(endX,endY));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(time));
        pathTransition.setPath(path);
        pathTransition.setNode(con);
        pathTransition.setCycleCount(1);
        pathTransition.play();
    }
}