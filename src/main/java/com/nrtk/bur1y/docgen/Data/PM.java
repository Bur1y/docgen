package com.nrtk.bur1y.docgen.Data;

public class PM {

    public String reduction;
    public String fullName;
    public String groupName;

    public PM(String reduction, String fullName, String groupName){
        this.reduction = reduction;
        this.fullName = fullName;
        this.groupName = groupName;
    }

    public String toString(){
        return reduction + " - " + fullName;
    }
}
