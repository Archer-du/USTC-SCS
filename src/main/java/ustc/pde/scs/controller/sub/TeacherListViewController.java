package ustc.pde.scs.controller.sub;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import ustc.pde.scs.controller.IListViewController;
import ustc.pde.scs.entity.course.Course;
import ustc.pde.scs.entity.user.User;
import ustc.pde.scs.sql.implementation.action.select.SelectImpl;
import ustc.pde.scs.sql.implementation.course.CourseDAOImpl;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherListViewController implements IListViewController {
    public ImageView image;
    public Button showMyCourseButton;
    public Button showMyStudentButton;
    public Label userID;
    public Label userName;
    public Label department;
    public ListView listView;

    private User currentUser;
    @Override
    public void initialize(String userID) {
        UserDAOImpl userDAO = new UserDAOImpl();
        currentUser = userDAO.getObject(userID);
        listView.setVisible(false);
        updateUserInfo();
    }
    // TODO
    private void updateUserInfo(){
        userName.setText(currentUser.getName());
        userID.setText(currentUser.getID());
        department.setText(null);
    }


    private ArrayList<Course> prepareMyStudentData() {
        try {
            CourseDAOImpl courseDAO = new CourseDAOImpl();
            ArrayList<Course> courses = new ArrayList<>();
            ResultSet rs = null;
            try {
                rs = courseDAO.executeQuerySQL("select * from course");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
//        courses.add(new Course("课程ID", "课程名称", "课程类型", "理论课学时", "实验课学时", "学分"));
            while (rs.next()) {
                courses.add(new Course(
                        rs.getString("courseId"),
                        rs.getString("courseName"),
                        rs.getString("courseType"),
                        rs.getInt("theoryHour"),
                        rs.getInt("labHour"),
                        rs.getDouble("credit")
                ));
            }
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Course> prepareMyCourseData() {
        try {
            CourseDAOImpl courseDAO = new CourseDAOImpl();
            ArrayList<Course> courses = new ArrayList<>();
            ResultSet rs = null;
            try {
                rs = courseDAO.executeQuerySQL("select course.courseId, courseName, courseType, theoryHour, labHour, credit " +
                        "from selectcourse, course " +
                        "where selectcourse.ID = ? and selectcourse.courseId = course.courseId", currentUser.getID());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
//        courses.add(new Course("课程ID", "课程名称", "课程类型", "理论课学时", "实验课学时", "学分"));
            while (rs.next()) {
                courses.add(new Course(
                        rs.getString("courseId"),
                        rs.getString("courseName"),
                        rs.getString("courseType"),
                        rs.getInt("theoryHour"),
                        rs.getInt("labHour"),
                        rs.getDouble("credit")
                ));
            }
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void setListViewItems(ArrayList<Course> courses) {
        ObservableList<Course> list = FXCollections.observableArrayList(courses);
        listView.setItems(list);
        listView.setPrefWidth(400);
        listView.setCellFactory(listView -> new ListCell<Course>() {
            @Override
            protected void updateItem(Course course, boolean empty) {
                super.updateItem(course, empty);
                if (empty || course == null) {
                    setGraphic(null);
                } else {
                    HBox hbox = new HBox();
                    Label courseIdLabel = new Label(course.getCourseId());
                    Label courseNameLabel = new Label(course.getCourseName());
                    Label courseTypeLabel = new Label(course.getCourseType());
                    Label theoryHourLabel = new Label(String.valueOf(course.getTheoryHour()));
                    Label labHourLabel = new Label(String.valueOf(course.getLabHour()));
                    Label creditLabel = new Label(String.format("%.2f", course.getCredit()));

                    courseIdLabel.setMinWidth(100);
                    courseNameLabel.setMinWidth(200);
                    courseTypeLabel.setMinWidth(100);
                    theoryHourLabel.setMinWidth(50);
                    labHourLabel.setMinWidth(50);
                    creditLabel.setMinWidth(50);

                    hbox.getChildren().addAll(courseIdLabel, courseNameLabel, courseTypeLabel, theoryHourLabel, labHourLabel, creditLabel);
                    setGraphic(hbox);
                }
            }
        });

    }



    private boolean showMessage(String title, String text, Alert.AlertType type){
        boolean ans = false;
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
        return ans;
    }







    public void OnShowMyCoursesCommand(ActionEvent actionEvent) {
    }

    public void OnShowMyStudentsCommand(ActionEvent actionEvent) {
    }
}
