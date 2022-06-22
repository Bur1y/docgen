import com.nrtk.bur1y.docgen.API.Import.GetChairmans;
import com.nrtk.bur1y.docgen.API.Import.GetGroups;
import com.nrtk.bur1y.docgen.API.Import.GetPM;
import com.nrtk.bur1y.docgen.API.Import.SpreadSheet;
import com.nrtk.bur1y.docgen.Data.Chairman;
import com.nrtk.bur1y.docgen.Data.Group;
import com.nrtk.bur1y.docgen.Data.PM;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class UnitTesting {

    // Тест проверяем правильность создания групп
    @Test
    public void getGroupsName() {
        List<Group> myGroups = new ArrayList<>();
        myGroups.add(new Group("ОТЗИ-17-1"));
        myGroups.add(new Group("ИСИП-18-1"));

        List<Group> spreadSheet = GetGroups.getGroupList(UnitTesting.class.getResource("groups.xlsx").getPath());
        Assertions.assertEquals(spreadSheet.get(0).name, myGroups.get(0).name);
        Assertions.assertEquals(spreadSheet.get(1).name, myGroups.get(1).name);
    }

    // Тест проверяет наличие эксперта по статичным данным указанным ниже
    @Test
    public void chairman() {
        List<Chairman> chairmanList = GetChairmans.getChairmans();

        String name = "Е.А.Романов";
        String desc = " начальник Управления информационных технологий АО «ФНПЦ «НИИРТ»";

        Assertions.assertEquals(chairmanList.get(0).fio, name);
        Assertions.assertEquals(chairmanList.get(0).additionalInfo, desc);
    }

    // Тест проверяет правильность экспорта пм из таблиц
    @Test
    public void pms() {
        List<PM> pmList = GetPM.getPM();

        Assertions.assertEquals(pmList.get(1).fullName, new PM("ПМ.02", "Администрирование баз данных", "ИСИП").fullName);
    }

    // Тест проверяет действительность возврата нужного класса при помощи библиотеки Apache POI
    @Test
    public void getBook(){
        Assertions.assertNotNull(SpreadSheet.book(UnitTesting.class.getResource("groups.xlsx").getPath()));
        Assertions.assertNotSame(SpreadSheet.book(UnitTesting.class.getResource("groups.xlsx").getPath()), new XSSFWorkbook());
    }
}