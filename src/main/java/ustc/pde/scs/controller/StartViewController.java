package ustc.pde.scs.controller;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import ustc.pde.scs.entity.major.Major;
import ustc.pde.scs.entity.user.User;
import ustc.pde.scs.sql.implementation.major.MajorDAOImpl;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class StartViewController {
    public AnchorPane mainPane;
    public AnchorPane loginPanel;
    public AnchorPane registerPanel;


    public TextField loginID;
    public PasswordField loginPassword;
    public TextField registerID;
    public TextField registerName;
    public PasswordField registerPassword;
    public PasswordField confirmedPassword;


    public Button confirmButton;


    public Label forgetPassword;
    public Button closeButton;
    public ChoiceBox<String> IDPrefixBox;
    public ChoiceBox<String> majorsBox;
    public HashMap<String, String> majorMap;

    public void initializeController() {
        majorMap = new HashMap<>();
        prepareIDPrefixData();
        prepareMajorData();

        cleanLoginPanel();
        cleanRegisterPanel();

        loginPanel.setVisible(true);
        loginID.setPromptText("学号/工号");
        registerPanel.setVisible(false);
    }



    private void prepareIDPrefixData(){
        ObservableList<String> list = FXCollections.observableArrayList("PB", "TA");
        IDPrefixBox.setItems(list);
    }

    private void prepareMajorData(){
        ArrayList<String> majorNames = new ArrayList<>();
        MajorDAOImpl majorDAO = new MajorDAOImpl();
        ArrayList<Major> majors = majorDAO.getAll();
        for(Major major: majors){
            var id = major.getMajorId();
            var name = major.getMajorName();
            majorNames.add(name);
            majorMap.put(name,id);
        }

        ObservableList<String> list = FXCollections.observableArrayList(majorNames);
        majorsBox.setItems(list);
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
            var result = controlAlert(STR."账号[\{rawID}]不存在！" +
                    "\n是否注册？", "登录失败", Alert.AlertType.ERROR);
            if (result.get() == ButtonType.OK) {
                cleanRegisterPanel();
                registerID.setText(rawID);
                onSwitchToRegister(actionEvent);
            }
            return;
        }
        if (user.getPassword().equals(rawPassword)) {
            var identity = parseIdentity(rawID);
            var result = controlAlert("欢迎！" + rawID +
                    "\n你的身份是：" + identity.toString(), "登录成功", Alert.AlertType.INFORMATION);
            if (result.get() == ButtonType.OK) {
                String path = null;
                switch (identity){
                    case student -> path = "/ustc/pde/scs/fxml/studentListview.fxml";
                    case teacher -> path = "/ustc/pde/scs/fxml/teacherListview.fxml";
                    case administrator -> path = "/ustc/pde/scs/fxml/adminListview.fxml";
                }
                assert path != null;
                FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
                Parent root = loader.load();

                var stage = SCSApplication.primaryStage;
                stage.setTitle("USTC SCS");
                stage.setResizable(false);
                stage.setScene(new Scene(root, 1920, 1080));
                stage.show();
                IListViewController controller = loader.getController();
                controller.initialize(rawID, majorMap);
            }
        }
        else {
            controlAlert("密码输入错误！", "登录失败", Alert.AlertType.ERROR);
            controlAnimation(confirmButton);
        }
    }

    public void onRegisterConfirm(ActionEvent actionEvent) {
        String rawID = IDPrefixBox.getValue() + registerID.getText();
        String rawName = registerName.getText();
        String rawMajor = majorsBox.getValue();
        String rawPassword = registerPassword.getText();
        if(IDPrefixBox.getValue() == null){
            controlAlert(STR."账号[\{rawID}]格式不合法（未选择前缀）", "输入错误", Alert.AlertType.ERROR);
            return;
        }
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
        if(rawMajor == null){
            controlAlert(STR."院系[\{rawName}]不能为空", "输入错误", Alert.AlertType.ERROR);
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
        user.setMajorId(majorMap.get(rawMajor));
        user.setPassword(rawPassword);
        user.setType(parseIdentity(rawID).toString());
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
        controlAlert("没做", "提示", Alert.AlertType.INFORMATION);
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
        controlAlert("没做", "提示", Alert.AlertType.INFORMATION);
    }
    public void OnClose(ActionEvent actionEvent){
        SCSApplication.primaryStage.close();
    }





    private void cleanLoginPanel(){
        loginID.setText("");
        loginPassword.setText("");
    }
    private void cleanRegisterPanel(){
        registerID.setText("");
        registerName.setText("");
        registerPassword.setText("");
        confirmedPassword.setText("");
    }




    private boolean checkIDFormat(String rawID){
        // 合法ID格式
        return rawID.matches("PB\\d{8}") || rawID.matches("TA\\d{3}") || rawID.equals("root");
    }
    private boolean checkNameFormat(String rawName){
        return rawName.matches("[a-zA-Z\\u4e00-\\u9fa5]+");
    }

    private Identity parseIdentity(String qualifiedID){
        if(!checkIDFormat(qualifiedID)){
            throw new RuntimeException();
        }
        if(qualifiedID.matches("PB\\d{8}")) return Identity.student;
        if(qualifiedID.matches("TA\\d{3}")) return Identity.teacher;
        if(qualifiedID.equals("root")) return Identity.administrator;
        return null;
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




    public enum Identity{
        student,
        teacher,
        administrator
    }
}