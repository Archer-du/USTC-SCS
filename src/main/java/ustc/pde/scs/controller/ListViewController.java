package ustc.pde.scs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

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
    @FXML
    public Button el;


    public void initialize() {
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

