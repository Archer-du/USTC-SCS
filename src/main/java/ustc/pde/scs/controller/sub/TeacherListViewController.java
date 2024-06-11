package ustc.pde.scs.controller.sub;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.w3c.dom.ls.LSInput;
import ustc.pde.scs.controller.IListViewController;
import ustc.pde.scs.entity.course.Course;
import ustc.pde.scs.entity.user.User;
import ustc.pde.scs.sql.implementation.action.select.CsSelectImpl;
import ustc.pde.scs.sql.implementation.action.select.SelectImpl;
import ustc.pde.scs.sql.implementation.course.CourseDAOImpl;
import ustc.pde.scs.sql.implementation.major.MajorDAOImpl;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TeacherListViewController implements IListViewController {
    public ImageView image;
    public Button showMyCourseButton;
    public Button showMyStudentButton;
    public Label userID;
    public Label userName;
    public Label department;
    public ListView listViewCourse;
    public ListView listViewStudent;
    private User currentUser;
    public HashMap<String, String> majorMap;
    @Override
    public void initialize(String userID, HashMap<String, String> map) {
        UserDAOImpl userDAO = new UserDAOImpl();
        currentUser = userDAO.getObject(userID);
        listViewCourse.setVisible(false);
        listViewStudent.setVisible(false);

        majorMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            majorMap.put(entry.getValue(), entry.getKey());
        }

        updateUserInfo();
    }
    // TODO
    private void updateUserInfo(){
        userName.setText(currentUser.getName());
        userID.setText(currentUser.getID());
        department.setText(majorMap.get(currentUser.getMajorId()));
    }


    private HashMap<User,Course> prepareMyStudentData() {

        ArrayList<Course> courses = new CourseDAOImpl().getCourses(currentUser.getID());
        HashMap<User,Course> students = new HashMap<>();
        CsSelectImpl csSelect = new CsSelectImpl();
        for(Course course: courses){
            for(User student: csSelect.getAll(course.getCourseId())){
                students.put(student,course);
            }
        }
        return students;
    }

    private ArrayList<Course> prepareMyCourseData(){
        return new CourseDAOImpl().getCourses(currentUser.getID());
    }
    private void setListViewItems(HashMap<User,Course> students){
        var studentSet = students.keySet();
        ArrayList<User> studentList = new ArrayList<>(studentSet);
        studentList.add(0,null);
        ObservableList<User> list = FXCollections.observableArrayList(studentList);
        listViewStudent.setItems(list);
        listViewStudent.setPrefWidth(400);
        listViewStudent.setCellFactory(listViewStudent -> new ListCell<User>(){
            int i = 0;
            protected void updateItem (User user, boolean empty){
                super.updateItem(user,empty);
                if(empty || user == null){
                    if(i!=0){
                        HBox hbox = new HBox();
                        Label courseIdHead = new Label("课程号");
                        Label courseNameHead = new Label("课程名");
                        Label studentIdHead = new Label("学号");
                        Label studentNameHead = new Label("学生姓名");
                        Label studentMajorHead = new Label("专业院系");

                        courseNameHead.setMinWidth(200);
                        courseIdHead.setMinWidth(100);
                        studentIdHead.setMinWidth(100);
                        studentNameHead.setMinWidth(100);
                        studentMajorHead.setMinWidth(200);
                        hbox.getChildren().addAll(courseIdHead,courseNameHead,studentMajorHead,studentIdHead,studentNameHead);
                        setGraphic(hbox);
                    }else{
                        setGraphic(null);
                    }
                    i += 1 ;
                }
                else {

                    HBox hbox = new HBox();
                    var course = students.get(user);
                    Label courseIdLabel = new Label(course.getCourseId());
                    Label courseNameLabel = new Label(course.getCourseName());
                    Label studentIdLabel = new Label(user.getID());
                    Label studentNameLabel = new Label(user.getName());
                    Label studentMajorLabel = new Label(new MajorDAOImpl().getObject(user.getMajorId()).getMajorName());

                    courseNameLabel.setMinWidth(200);
                    courseIdLabel.setMinWidth(100);
                    studentIdLabel.setMinWidth(100);
                    studentNameLabel.setMinWidth(100);
                    studentMajorLabel.setMinWidth(200);
                    hbox.getChildren().addAll(courseIdLabel,courseNameLabel,studentMajorLabel,studentIdLabel,studentNameLabel);
                    setGraphic(hbox);

                }
            }
        });

    }
    private void setListViewItems(ArrayList<Course> courses) {
        courses.add(0,null);
        ObservableList<Course> list = FXCollections.observableArrayList(courses);
        listViewCourse.setItems(list);
        listViewCourse.setPrefWidth(400);

        listViewCourse.setCellFactory(listViewCourse -> new ListCell<Course>() {
            int i = 0;
            @Override
            protected void updateItem(Course course, boolean empty) {
                super.updateItem(course, empty);

                if (empty || course == null) {
                    if(i!=0){
                        HBox hboxHead = new HBox();
                        Label courseIdHead = new Label("课程号");
                        Label courseNameHead = new Label("课程名");
                        Label courseTypeHead = new Label("选修/必修");
                        Label theoryHourHead = new Label("理论课学时");
                        Label labHourHead = new Label("实验课学时");
                        Label creditHead = new Label("学分");
                        Label numHead = new Label("已选人数/人数上限");
                        Label gradeMeansHead = new Label("评分方式");
                        courseIdHead.setMinWidth(100);
                        courseNameHead.setMinWidth(200);
                        courseTypeHead.setMinWidth(100);
                        theoryHourHead.setMinWidth(100);
                        labHourHead.setMinWidth(100);
                        creditHead.setMinWidth(50);
                        numHead.setMinWidth(100);
                        gradeMeansHead.setMinWidth(200);
                        gradeMeansHead.setAlignment(Pos.CENTER);
                        hboxHead.getChildren().addAll(courseIdHead,courseNameHead,courseTypeHead,theoryHourHead,labHourHead,creditHead,numHead,gradeMeansHead);
                        numHead.setAlignment(Pos.CENTER);
                        setGraphic(hboxHead);
                    }else {
                        setGraphic(null);
                    }
                    i += 1;
                } else {
                    HBox hbox = new HBox();
                    Label courseIdLabel = new Label(course.getCourseId());
                    Label courseNameLabel = new Label(course.getCourseName());
                    Label courseTypeLabel = new Label(course.getCourseType());
                    Label theoryHourLabel = new Label(String.valueOf(course.getTheoryHour()));
                    Label labHourLabel = new Label(String.valueOf(course.getLabHour()));
                    Label creditLabel = new Label(String.format("%.2f", course.getCredit()));
                    Label NumLabel = new Label(String.valueOf(course.getSelectedNum())+ "/" + String.valueOf(course.getMaxNum()));
                    Label gradeMeansLabel = new Label(course.getGradeMeans());
                    courseIdLabel.setMinWidth(100);
                    courseNameLabel.setMinWidth(200);
                    courseTypeLabel.setMinWidth(100);
                    theoryHourLabel.setMinWidth(100);
                    labHourLabel.setMinWidth(100);
                    creditLabel.setMinWidth(50);
                    NumLabel.setMinWidth(100);
                    NumLabel.setAlignment(Pos.CENTER);
                    gradeMeansLabel.setMinWidth(200);
                    gradeMeansLabel.setAlignment(Pos.CENTER);
                    hbox.getChildren().addAll(courseIdLabel, courseNameLabel, courseTypeLabel, theoryHourLabel, labHourLabel, creditLabel,NumLabel,gradeMeansLabel);
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
        setListViewItems(prepareMyCourseData());
        listViewCourse.setVisible(true);
        listViewStudent.setVisible(false);
    }

    public void OnShowMyStudentsCommand(ActionEvent actionEvent) {
        setListViewItems(prepareMyStudentData());
        listViewStudent.setVisible(true);
        listViewCourse.setVisible(false);
    }
}
