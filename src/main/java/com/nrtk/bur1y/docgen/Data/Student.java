package com.nrtk.bur1y.docgen.Data;

/**
 *
 */
public class Student {

    public String fio;
    public int mdk0101;
    public int mdk0102;
    public int mdk0103;
    public int kp;
    public int up;
    public int pp;
    public long test;
    public int task;
    public int total;
    public int idRecord;

    public Student(){

    }

    public Student(String fio, int mdk0101, int mdk0102, int mdk0103, int kp, int up, int pp, long test, int task, int idRecord) {
        this.fio = fio;
        this.mdk0101 = mdk0101;
        this.mdk0102 = mdk0102;
        this.mdk0103 = mdk0103;
        this.kp = kp;
        this.up = up;
        this.pp = pp;
        this.test = test;
        this.task = task;
        this.idRecord = idRecord;

        this.total = (((int) (test + task) / 2) + (mdk0101 + mdk0102 + mdk0103 + kp + up + pp) / 6) / 2;
    }

    public static Student createStudent(String fio, int mdk0101, int mdk0102, int mdk0103, int kp, int up, int pp, long test, int task, int idRecord) {
        return new Student(fio, mdk0101, mdk0102, mdk0103, kp, up, pp, test, task, idRecord);
    }

    public void reCalc() {
        this.total = (((int) (test + task) / 2) + (mdk0101 + mdk0102 + mdk0103 + kp + up + pp) / 6) / 2;
    }

    @Override
    public String toString() {

        String sb = "Номер книжки " + idRecord + " " + fio + " МДК " + mdk0101 + +mdk0102 + mdk0103 + " - " + " Экзамен " + test + task + " Итог " + total;

        return sb;
    }

}
