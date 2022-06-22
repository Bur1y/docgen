package com.nrtk.bur1y.docgen.API.Import;

import com.nrtk.bur1y.docgen.Data.Group;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

public class GetGroups {
    public static List<Group> getGroupList(String path) {

        List<Group> groupList = new ArrayList<>();

        XSSFWorkbook workbook = SpreadSheet.book(path);

        for (int i = 1; i < workbook.getNumberOfSheets(); i++) {

            groupList.add(
                    new Group(GetStudents.
                            getListStudents(workbook.getSheetAt(i)),
                            workbook.getSheetAt(i).getSheetName())
            );
        }
        return groupList;
    }

}
