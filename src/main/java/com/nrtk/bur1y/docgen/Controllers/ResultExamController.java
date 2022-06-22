package com.nrtk.bur1y.docgen.Controllers;

import com.nrtk.bur1y.docgen.Data.Student;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class ResultExamController {


    public TableColumn<Student, String> fio, test, task;
    public TableView<Student> viewTable;

    @FXML
    public void initialize() {

        List<Student> studentList = MainController.sGroup.studentList;

        fio.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cd) -> {
            return new SimpleStringProperty(String.valueOf(cd.getValue().fio));
        });

        test.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cd) -> {
            return new SimpleStringProperty(String.valueOf(cd.getValue().test));
        });

        task.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cd) -> {
            return new SimpleStringProperty(String.valueOf(cd.getValue().task));
        });


        ObservableList<Student> students = FXCollections.observableList(studentList);
        viewTable.setItems(students);
    }

    public void edit(ActionEvent actionEvent) {

    }
}
