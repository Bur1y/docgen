package com.nrtk.bur1y.docgen.Data;

public class Commission {

    Chairman chairman;
    Expert expert2;
    Expert expert3;
    Expert expert4;
    Expert expert5;

    public Commission(Chairman chairman, Expert expert2,  Expert expert3, Expert expert4, Expert expert5){
        this.chairman = chairman;

        this.expert2 = expert2;
        this.expert3 = expert3;
        this.expert4 = expert4;
        this.expert5 = expert5;
    }

    public Chairman getChairman() {
        return chairman;
    }

    public Expert getExpert2() {
        return expert2;
    }

    public Expert getExpert3() {
        return expert3;
    }

    public Expert getExpert4() {
        return expert4;
    }

    public Expert getExpert5() {
        return expert5;
    }
}
