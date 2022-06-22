package com.nrtk.bur1y.docgen.API.Import;

import com.nrtk.bur1y.docgen.Data.Student;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetStudents {
    public static List<Student> getListStudents(Sheet groups) {
        List<Student> studentList = new ArrayList<>();

        Iterator<Row> rowIterator = groups.iterator();

        Row row = rowIterator.next();

        row = rowIterator.next();

        while (rowIterator.hasNext()) {

            row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            studentList.add(new Student(
                    cellIterator.next().getStringCellValue(),
                    (int) cellIterator.next().getNumericCellValue(),
                    (int) cellIterator.next().getNumericCellValue(),
                    (int) cellIterator.next().getNumericCellValue(),
                    (int) cellIterator.next().getNumericCellValue(),
                    (int) cellIterator.next().getNumericCellValue(),
                    (int) cellIterator.next().getNumericCellValue(),
                    (long) cellIterator.next().getNumericCellValue(),
                    (int) cellIterator.next().getNumericCellValue(),
                    (int) cellIterator.next().getNumericCellValue())
            );
        }
        return studentList;
    }
}
