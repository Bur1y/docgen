package com.nrtk.bur1y.docgen.API.Import;

import com.nrtk.bur1y.docgen.Data.Chairman;
import com.nrtk.bur1y.docgen.Data.PM;
import com.nrtk.bur1y.docgen.JavaFX;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetPM {

    public static List<PM> getPM() {
        List<PM> pmList = new ArrayList<>();

        XSSFWorkbook workbook = SpreadSheet.book(JavaFX.class.getResource("Data/ПМ.xlsx").getPath());

        Iterator<Row> rowIterator = workbook.getSheetAt(0).iterator();

        Row row = rowIterator.next();

        while (rowIterator.hasNext()) {

            row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            pmList.add(new PM(
                    cellIterator.next().getStringCellValue(),
                    cellIterator.next().getStringCellValue(),
                    cellIterator.next().getStringCellValue())
            );
        }

        return pmList;
    }
}
