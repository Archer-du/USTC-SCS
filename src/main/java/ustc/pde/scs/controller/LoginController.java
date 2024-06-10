package ustc.pde.scs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;
import java.io.IOException;


public class LoginController {
    public AnchorPane mainPane;
    public PasswordField passwordEnterZone;
    public TextField sidEnterZone;
    public Label forgetPassword;
    public Button closeButton;
    public AnchorPane registerPanel;

    public CheckBox male;
    public CheckBox female;
    public TextField registerName;
    public TextField registerSid;
    public TextField registerMajor;
    public PasswordField confirmedPassword;
    public PasswordField registerPassword;


    private Stage stage;
    private UserDAOImpl dao;

    public LoginController(){
        dao = new UserDAOImpl();
    }

    public void OnLoginConfirm() throws Exception {
        String login_username = sidEnterZone.getText();
        String login_password = passwordEnterZone.getText();
        //检索是否存在该用户
        boolean x = true;//dao.isExist(login_username, login_password);
        //如果存在，跳转主页
        if(x){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/listview.fxml"));
            System.out.println(loader);
            Parent root = loader.load();

            // 创建新的场景
            Scene scene = new Scene(root);
            stage = new Stage();
            // 切换到新场景
            stage.setScene(scene);
            stage.show();
        } else{//若不存在，提醒
            System.out.println("用户 '" + login_username + "' 不存在。");
        }
    }

    public void OnRegisterConfirm(ActionEvent actionEvent) {
    }


    public void OnForgetPassword(MouseEvent mouseEvent) {
        //执行跳转
        registerPanel.setVisible(true);
    }


    public void OnSwitchToLogin(ActionEvent actionEvent) {
        registerPanel.setVisible(false);
    }

    public void OnSwitchToRegister(ActionEvent actionEvent) {
        registerPanel.setVisible(true);
    }

    public void OnSwitchToAbout(ActionEvent actionEvent) {
    }

    public void OnClose(ActionEvent actionEvent) {
        System.exit(0);
    }

}
