package ustc.pde.scs.controller.sub;

import javafx.animation.PathTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import ustc.pde.scs.controller.IListViewController;
import ustc.pde.scs.entity.course.Course;
import ustc.pde.scs.entity.user.User;
import ustc.pde.scs.sql.implementation.action.select.SelectImpl;
import ustc.pde.scs.sql.implementation.course.CourseDAOImpl;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentListViewController implements IListViewController {
    public ImageView image;

    public Label userName;
    public Label userID;
    public Label gender;

    public Label major;
    public Label department;
    public Label updateTime;


    public ListView listView;
    public Button chooseButton;


    public Button showAllCourseButton;
    public Button showMyCourseButton;

    public Button cancelButton;


    private User currentUser;

    public void initialize(String userID) {
        UserDAOImpl userDAO = new UserDAOImpl();
        currentUser = userDAO.getObject(userID);
        listView.setVisible(false);
        chooseButton.setVisible(false);
        cancelButton.setVisible(false);
        updateUserInfo();
    }
    // TODO
    private void updateUserInfo(){
        userName.setText(currentUser.getName());
        userID.setText(currentUser.getID());
        gender.setText(null);
        major.setText(null);
        department.setText(null);
        updateTime.setText(null);
    }


    private ArrayList<Course> prepareAllCourseData() {
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







    public void OnCourseChosen(ActionEvent actionEvent) {
        Course selectedCourse = (Course)(listView.getSelectionModel().getSelectedItem());
        if (selectedCourse == null) {
            showMessage("错误", "请选择对应课程！", Alert.AlertType.ERROR);
            return;
        }
        String rawID = selectedCourse.getCourseId();
        CourseDAOImpl courseDAO = new CourseDAOImpl();
        var course = courseDAO.getObject(rawID);
        SelectImpl selectDAO = new SelectImpl();
        if (course != null) {
            if(selectDAO.isExist(currentUser.getID(), course.getCourseId())){
                showMessage("选课失败", "你已经选择了相同的课程！", Alert.AlertType.ERROR);
            }
            //TODO: 选课数量超出限制
            else if(selectDAO.insert(currentUser.getID(), course.getCourseId())){
                // TODO: teacher
                showMessage(
                        "提示", STR."\n(1)你选择了课程编号为： \{course.getCourseId()} 的课程!\n\n(2)具体信息：\n     [a]课程名称：\{course.getCourseName()}\n     [b]授课老师：\n", Alert.AlertType.INFORMATION);
            }
            else throw new RuntimeException();
        }
    }
    public void OnCourseCancel(ActionEvent actionEvent) {
        Course selectedCourse = (Course)(listView.getSelectionModel().getSelectedItem());
        if (selectedCourse == null) {
            showMessage("错误", "请选择对应课程！", Alert.AlertType.ERROR);
            return;
        }
        String rawID = selectedCourse.getCourseId();
        CourseDAOImpl courseDAO = new CourseDAOImpl();
        var course = courseDAO.getObject(rawID);
        SelectImpl selectDAO = new SelectImpl();
        if (course != null) {
            if(selectDAO.delete(currentUser.getID(), course.getCourseId())){
                // TODO: teacher
                showMessage(
                        "提示", STR."\n(1)你取消选择了课程编号为： \{course.getCourseId()} 的课程!\n\n(2)具体信息：\n     [a]课程名称：\{course.getCourseName()}\n     [b]授课老师：\n", Alert.AlertType.INFORMATION);
            }
            else throw new RuntimeException();
        }
    }





    public void OnShowAllCoursesCommand(ActionEvent actionEvent) throws SQLException {
        setListViewItems(prepareAllCourseData());
        listView.setVisible(true);
        chooseButton.setVisible(true);
        cancelButton.setVisible(false);
    }

    public void OnShowMyCoursesCommand(ActionEvent actionEvent) {
        setListViewItems(prepareMyCourseData());
        listView.setVisible(true);
        chooseButton.setVisible(false);
        cancelButton.setVisible(true);
    }





    private void moveList(Control con,double starX,double starY,double endX,double endY){
        con.setLayoutX(endX==-950?1550.0:0);
        Path path = new Path();

        path.getElements().add(new MoveTo(starX, starY));
        path.getElements().add(new LineTo(endX-50, endY));
        path.getElements().add(new LineTo(endX, endY));

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(endX==-950?0.8:1));
        pathTransition.setPath(path);
        pathTransition.setNode(con);
        pathTransition.setCycleCount(1);
        pathTransition.play();
    }

}
