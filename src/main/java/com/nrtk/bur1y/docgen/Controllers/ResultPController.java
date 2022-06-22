package com.nrtk.bur1y.docgen.Controllers;

import com.nrtk.bur1y.docgen.Data.Student;
import com.nrtk.bur1y.docgen.JavaFX;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class ResultPController {

    public TableColumn<Student, String> fio, mdk01, mdk02, mdk03, kp, up, pp;
    public TableView<Student> viewTable;

    @FXML
    public void initialize() {

        List<Student> studentList = MainController.sGroup.studentList;

        fio.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cd) -> {
            return new SimpleStringProperty(String.valueOf(cd.getValue().fio));
        });
        mdk01.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cd) -> {
            return new SimpleStringProperty(String.valueOf(cd.getValue().mdk0101));
        });
        mdk02.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cd) -> {
            return new SimpleStringProperty(String.valueOf(cd.getValue().mdk0102));
        });
        mdk03.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cd) -> {
            return new SimpleStringProperty(String.valueOf(cd.getValue().mdk0103));
        });
        kp.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cd) -> {
            return new SimpleStringProperty(String.valueOf(cd.getValue().kp));
        });
        up.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cd) -> {
            return new SimpleStringProperty(String.valueOf(cd.getValue().up));
        });
        pp.setCellValueFactory((TableColumn.CellDataFeatures<Student, String> cd) -> {
            return new SimpleStringProperty(String.valueOf(cd.getValue().pp));
        });


        ObservableList<Student> students = FXCollections.observableList(studentList);
        viewTable.setItems(students);


    }

    public void edit(ActionEvent actionEvent) {
    }
}
