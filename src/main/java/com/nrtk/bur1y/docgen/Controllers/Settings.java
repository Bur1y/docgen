//package com.nrtk.bur1y.docgen.Controllers;
//
//import com.nrtk.bur1y.docgen.API.Import.GetChairmans;
//import com.nrtk.bur1y.docgen.API.Import.GetExperts;
//import com.nrtk.bur1y.docgen.Data.Expert;
//import com.nrtk.bur1y.docgen.JavaFX;
//import javafx.collections.FXCollections;
//import javafx.stage.FileChooser;
//
//import java.io.File;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
//public class Settings {
//
//    public String getFilePath(){
//        FileChooser fc = new FileChooser();
//        fc.setTitle("Open Resource File");
//        fc.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("Excel, Calc, CSV", "*.xls", "*.xlsx", "*.ods", "*.csv")
//        );
//
//        String path = null;
//
//        try {
//            path = new String(
//
//                    new File(fc
//                            .showOpenDialog(JavaFX.s)
//                            .getPath())
//                            .getAbsolutePath()
//                            .getBytes(StandardCharsets.UTF_8));
//        } catch (Exception e) {
//            System.out.printf("Ошибка получаения файла оценок", e);
//        }
//        return path;
//    }
//
//    public void newComm(){
//        comField.setText(getFilePath());
//    }
//    public void newPM(){
//        pmField.setText(getFilePath());
//    }
//    public void newGroups(){
//        groupsField.setText(getFilePath());
//    }
//
//}
