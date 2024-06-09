package ustc.pde.scs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

public class ListViewController {
    @FXML
    public ImageView image;
    @FXML
    public Label name;
    @FXML
    public Label sid;
    @FXML
    public Label gender;
    @FXML
    public Label major;
    @FXML
    public Label department;
    @FXML
    public Label updateTime;
    @FXML
    public ListView courseList;
    @FXML
    public ChoiceBox chooseList;
    @FXML
    public Button choose;
    @FXML
    public Button showAllCourseButton;
    @FXML
    public Button showMyCourseButton;
    @FXML
    public Button ChooseCourseButton;


    public void initialize(String userID) {
        UserDAOImpl userDAO = new UserDAOImpl();
        var user = userDAO.getObject(userID);

    }

    public void OnCourseChosen(ActionEvent actionEvent) {
    }

    public void OnShowAllCoursesCommand(ActionEvent actionEvent) {
    }

    public void OnShowMyCoursesCommand(ActionEvent actionEvent) {
    }

    public void OnShowCoursesListCommand(ActionEvent actionEvent) {
    }


}

