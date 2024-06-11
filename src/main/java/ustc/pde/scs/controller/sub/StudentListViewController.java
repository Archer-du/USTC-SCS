package ustc.pde.scs.controller.sub;

import javafx.animation.PathTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import ustc.pde.scs.controller.IListViewController;
import ustc.pde.scs.entity.course.Course;
import ustc.pde.scs.entity.user.User;
import ustc.pde.scs.sql.implementation.action.select.SelectImpl;
import ustc.pde.scs.sql.implementation.action.select.StuSelectImpl;
import ustc.pde.scs.sql.implementation.course.CourseDAOImpl;
import ustc.pde.scs.sql.implementation.user.UserDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentListViewController implements IListViewController {
    public ImageView image;

    public Label userName;
    public Label userID;

    public Label major;

    public AnchorPane selectPane;

    public ListView listView;
    public Button chooseButton;

    public Button queryButton;
    public Button showAllCourseButton;
    public Button showMyCourseButton;

    public Button cancelButton;
    public TextField queryText;

    private User currentUser;
    public HashMap<String, String> majorMap;

    public void initialize(String userID, HashMap<String, String> map) {
        UserDAOImpl userDAO = new UserDAOImpl();
        currentUser = userDAO.getObject(userID);
        listView.setVisible(false);
        chooseButton.setVisible(false);
        cancelButton.setVisible(false);

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
        major.setText(majorMap.get(currentUser.getMajorId()));
    }

    private ArrayList<Course> prepareAllCourseData(){
        return new CourseDAOImpl().getAll();
    }

    private ArrayList<Course> prepareMyCourseData(){
        return new StuSelectImpl().getAll(currentUser.getID());
    }



    private void setListViewItems(ArrayList<Course> courses) {
        courses.add(0,null);
        ObservableList<Course> list = FXCollections.observableArrayList(courses);
        listView.setItems(list);
        listView.setPrefWidth(400);

        listView.setCellFactory(listView -> new ListCell<Course>() {
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
                        gradeMeansHead.setMinWidth(100);
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
                    gradeMeansLabel.setMinWidth(100);
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
            //TODO: 选课数量超出限制的处理（查询）
            else if(selectedCourse.getSelectedNum() >= selectedCourse.getMaxNum()){
                showMessage("选课失败", "该课程人数已满！", Alert.AlertType.ERROR);
            }
            else if(selectDAO.insert(currentUser.getID(), course.getCourseId())){
                showMessage(
                        "提示", STR."\n(1)你选择了课程编号为 \{course.getCourseId()} 的课程!\n\n[a]课程名称：\{course.getCourseName()}\n", Alert.AlertType.INFORMATION);
                course.setSelectedNum(course.getSelectedNum()+1);
                courseDAO.update(course);
                prepareAllCourseData();
                OnShowAllCoursesCommand(actionEvent);
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
                showMessage(
                        "提示", STR."\n(1)你取消选择了课程编号为： \{course.getCourseId()} 的课程!\n\n(2)具体信息：\n     [a]课程名称：\{course.getCourseName()}\n     [b]授课老师：\{new UserDAOImpl().getTeacher(course.getCourseId()).getName()}\n", Alert.AlertType.INFORMATION);
                course.setSelectedNum(course.getSelectedNum()-1);
                courseDAO.update(course);
                prepareAllCourseData();
                OnShowMyCoursesCommand(actionEvent);
            }
            else throw new RuntimeException();
        }
    }





    public void OnShowAllCoursesCommand(ActionEvent actionEvent)  {
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

    public void OnCourseQuery(ActionEvent actionEvent) {
        queryText.setPromptText("输入课程名或ID");
        CourseDAOImpl courseDAO = new CourseDAOImpl();
        ArrayList<Course> courses = courseDAO.getCoursesByName(queryText.getText());
        if(courses.isEmpty()){
            if(courseDAO.isExist(queryText.getText())){
                courses.add(courseDAO.getObject(queryText.getText()));
            }
        }
        setListViewItems(courses);
        listView.setVisible(true);
    }
}
