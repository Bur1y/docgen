package com.nrtk.bur1y.docgen.Data;

public class Chairman {

    public String fio;
    public String additionalInfo;

    public Chairman(String fio, String additionalInfo){
        this.fio = fio;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString(){

        return fio + " - " + additionalInfo;
    }

}
