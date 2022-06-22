module com.nrtk.bur1y.docgen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.apache.poi.ooxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml.schemas;
    requires java.naming;
    requires java.desktop;
    requires java.net.http;
    requires java.base;
    requires javafx.base;
    requires simple.odf;
    requires odfdom.java;
    requires com.aspose.words;

    opens com.nrtk.bur1y.docgen to javafx.fxml;
    opens com.nrtk.bur1y.docgen.API.Import;
    opens com.nrtk.bur1y.docgen.API.Export;
    opens com.nrtk.bur1y.docgen.Controllers;
    opens com.nrtk.bur1y.docgen.Data;
    exports com.nrtk.bur1y.docgen;
    exports com.nrtk.bur1y.docgen.API.Import;
    exports com.nrtk.bur1y.docgen.API.Export;
    exports com.nrtk.bur1y.docgen.Controllers;
    exports com.nrtk.bur1y.docgen.Data;
}