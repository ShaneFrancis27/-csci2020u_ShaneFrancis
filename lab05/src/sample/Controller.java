package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML private TableView tableView;
    @FXML private TableColumn SID;
    @FXML private TableColumn midterm;
    @FXML private TableColumn assignments;
    @FXML private TableColumn finalExam;
    @FXML private TableColumn finalMark;
    @FXML private TableColumn letterGrade;

    public Controller() {
    }

    public void initialize(){
        SID.setCellValueFactory(new PropertyValueFactory<>("SID"));
        midterm.setCellValueFactory(new PropertyValueFactory<>("midterm"));
        assignments.setCellValueFactory(new PropertyValueFactory<>("assignments"));
        finalExam.setCellValueFactory(new PropertyValueFactory<>("finalExam"));
        letterGrade.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));
        finalMark.setCellValueFactory(new PropertyValueFactory<>("finalMark"));

        tableView.setItems(DataSource.getAllMarks());
    }
}
