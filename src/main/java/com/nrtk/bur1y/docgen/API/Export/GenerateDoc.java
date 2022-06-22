package com.nrtk.bur1y.docgen.API.Export;


import com.aspose.words.*;
import com.nrtk.bur1y.docgen.Data.Commission;
import com.nrtk.bur1y.docgen.Data.Group;
import com.nrtk.bur1y.docgen.Data.PM;
import com.nrtk.bur1y.docgen.Data.Student;
import com.nrtk.bur1y.docgen.JavaFX;
import org.odftoolkit.simple.TextDocument;
import org.odftoolkit.simple.common.navigation.InvalidNavigationException;
import org.odftoolkit.simple.common.navigation.TextNavigation;
import org.odftoolkit.simple.common.navigation.TextSelection;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import java.time.LocalDate;

public class GenerateDoc {

    public static void generateDocVed(Group sGroup, PM pm, LocalDate localDate, Commission commission, String extension) throws Exception {


        TextDocument textdoc = TextDocument.loadDocument(JavaFX.class.getResource("Data/Ведомость.odt").getPath());

        replace("%pm%",textdoc, pm.toString());
        replace("%groupName%",textdoc, sGroup.name);
        replace("%dateExam%",textdoc,localDate.toString());
        replace("%expert1fio%",textdoc, commission.getChairman().fio);
        replace("%expert1%",textdoc, commission.getChairman().toString());
        replace("%expert2%",textdoc, commission.getExpert2().fio);
        replace("%expert3%",textdoc, commission.getExpert3().fio);
        replace("%expert4%",textdoc, commission.getExpert4().fio);
        replace("%expert5%",textdoc, commission.getExpert5().fio);

        Table t = textdoc.getTableByName("Таблица1");
        Row row = t.getRowByIndex(1);

        int i = 1;

        for (Student s: sGroup.studentList) {

            replace("%idRecord%",textdoc, String.valueOf(s.idRecord));
            replace("%fio%",textdoc, s.fio);
            replace("%id%",textdoc, String.valueOf(i));
            replace("%total%",textdoc, String.valueOf(s.total +
                    switch (s.total){

                        case 5 -> " (отлично)";
                        case 4 -> " (хорошо)";
                        case 3 -> " (удовлет)";
                        case 2 -> " (неудовлет)";
                        default -> throw new IllegalStateException("Unexpected value: " + s.total);
                    }));

            i++;

            Cell c = row.getCellByIndex(0);
            c.setStringValue("%id%");
            c = row.getCellByIndex(1);
            c.setStringValue("%fio%");
            c = row.getCellByIndex(2);
            c.setStringValue("%idRecord%");
            c = row.getCellByIndex(3);
            c.setStringValue("освоен с оценкой %total%");

            row = t.appendRow();
        }
        t.removeRowsByIndex(i,i+1);

        if(extension.equals(".odt")){
            textdoc.save("toOdt");
            Document doc = new Document("toOdt");
            doc.save(sGroup.name + " Протокол от " + localDate + ".odt");
        } else {
            textdoc.save(sGroup.name + " Протокол от " + localDate + extension);
        }
    }

    public static void generateDocPro(Group sGroup, PM pm, LocalDate localDate, Commission commission, String extension) throws Exception {

        TextDocument textdoc = TextDocument.loadDocument(JavaFX.class.getResource("Data/Протокол.odt").getPath());

        replace("%pm%",textdoc, pm.toString());
        replace("%groupName%",textdoc, sGroup.name);
        replace("%dateExam%",textdoc,localDate.toString());
        replace("%expert1fio%",textdoc, commission.getChairman().fio);
        replace("%expert1%",textdoc, commission.getChairman().toString());
        replace("%expert2%",textdoc, commission.getExpert2().fio);
        replace("%expert3%",textdoc, commission.getExpert3().fio);
        replace("%expert4%",textdoc, commission.getExpert4().fio);
        replace("%expert5%",textdoc, commission.getExpert5().fio);

        Table t = textdoc.getTableByName("Таблица1");
        Row row = t.getRowByIndex(3);

        int i = 1;

        for (Student s : sGroup.studentList) {
            System.out.printf("Номер строки - " + i + " ");
            replace("%idRecord%",textdoc, String.valueOf(s.idRecord));
            replace("%fio%",textdoc, s.fio);
            replace("%id%",textdoc, String.valueOf(i));
            replace("%total%",textdoc, String.valueOf(s.total +
                    switch (s.total){

                        case 5 -> " (отлично)";
                        case 4 -> " (хорошо)";
                        case 3 -> " (удовлет)";
                        case 2 -> " (неудовлет)";
                        default -> throw new IllegalStateException("Unexpected value: " + s.total);
                    }));
            replace("%mdk01%",textdoc, String.valueOf(s.mdk0101));
            replace("%mdk02%",textdoc, String.valueOf(s.mdk0102));
            replace("%mdk03%",textdoc, String.valueOf(s.mdk0103));

            replace("%kp%",textdoc, String.valueOf(s.kp));
            replace("%up%",textdoc, String.valueOf(s.up));
            replace("%pp%",textdoc, String.valueOf(s.pp));

            i++;

            Cell c = row.getCellByIndex(0);
            c.setStringValue("%id%");
            c = row.getCellByIndex(1);
            c.setStringValue("%fio%");
            c = row.getCellByIndex(2);
            c.setStringValue("%mdk01%");
            c = row.getCellByIndex(3);
            c.setStringValue("%mdk02%");
            c = row.getCellByIndex(4);
            c.setStringValue("%mdk03%");
            c = row.getCellByIndex(5);
            c.setStringValue("%kp%");
            c = row.getCellByIndex(6);
            c.setStringValue("%up%");
            c = row.getCellByIndex(7);
            c.setStringValue("%pp%");

            for (int j = 8; j < 17; j++) {
                c = row.getCellByIndex(j);
                c.setStringValue("+");
            }
            row = t.appendRow();
        }
        t.removeRowsByIndex(i+1, i);

        if(extension.equals(".odt")){
            textdoc.save("toOdt");
            Document doc = new Document("toOdt");
            doc.save(sGroup.name + " Протокол от " + localDate + ".odt");
        } else {
            textdoc.save(sGroup.name + " Протокол от " + localDate + extension);
        }
    }

    public static void replace(String pattern, TextDocument textDocument, String text){
        TextNavigation search = new TextNavigation(pattern, textDocument);

        while (search.hasNext()) {

            TextSelection item = (TextSelection) search.nextSelection();

            try {
                item.replaceWith(text);
                System.out.println("Замена " + pattern + " на " + text);
            } catch (InvalidNavigationException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
