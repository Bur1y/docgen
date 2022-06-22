package com.nrtk.bur1y.docgen.API.Import;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class SpreadSheet {

    public static XSSFWorkbook book(String path) {

        XSSFWorkbook workbook = null;

        try {

            File file = new File(path);

            FileInputStream fip = new FileInputStream(file);
            //Get the workbook instance for XLSX file
            workbook = new XSSFWorkbook(fip);
            if (file.isFile() && file.exists()) {
                System.out.println(
                        "Книжка открыта");
                return workbook;

            } else {
               new NullPointerException().getMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }


}
