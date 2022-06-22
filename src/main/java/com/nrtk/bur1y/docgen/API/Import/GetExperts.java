package com.nrtk.bur1y.docgen.API.Import;

import com.nrtk.bur1y.docgen.Data.Chairman;
import com.nrtk.bur1y.docgen.Data.Expert;
import com.nrtk.bur1y.docgen.JavaFX;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetExperts {

    public static List<Expert> getExperts(){
        List<Expert> expertList = new ArrayList<>();

        XSSFWorkbook workbook = SpreadSheet.book(JavaFX.class.getResource("Data/Комиссия.xlsx").getPath());

        Iterator<Row> rowIterator = workbook.getSheetAt(0).iterator();

        Row row = rowIterator.next();

        while (rowIterator.hasNext()) {

            row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            expertList.add(new Expert(
                    cellIterator.next().getStringCellValue())
            );
        }

        return expertList;
    }
}
