package com.nrtk.bur1y.docgen.API.Import;

import com.nrtk.bur1y.docgen.Data.Chairman;
import com.nrtk.bur1y.docgen.Data.Group;
import com.nrtk.bur1y.docgen.Data.Student;
import com.nrtk.bur1y.docgen.JavaFX;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetChairmans {

    public static List<Chairman> getChairmans() {
        List<Chairman> chairmanList = new ArrayList<>();

        XSSFWorkbook workbook = SpreadSheet.book(JavaFX.class.getResource("Data/Комиссия.xlsx").getPath());

        Iterator<Row> rowIterator = workbook.getSheetAt(1).iterator();

        Row row = rowIterator.next();

        while (rowIterator.hasNext()) {

            row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            chairmanList.add(new Chairman(
                    cellIterator.next().getStringCellValue(),
                    cellIterator.next().getStringCellValue())
            );
        }

        return chairmanList;
    }
}
