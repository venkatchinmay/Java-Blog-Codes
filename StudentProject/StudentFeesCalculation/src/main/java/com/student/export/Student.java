package com.student.export;

import com.student.concealed.StudentFeesCalculation;

public class Student {

    private String name;
    private long id;
    private double feesPaid;
    private StudentFeesCalculation studentFeesCalculator;

    public Student(long id, String name){
        this.name = name;
        this.id = id;
        this.studentFeesCalculator = new StudentFeesCalculation();
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public double getRemainingFeesNeedToPaid() {
        return studentFeesCalculator.getRemainingFeesNeedToPaid();
    }

    public double getAnnualFees(){
        return studentFeesCalculator.getTotalFeesPerAnnum();
    }

    public double getTotalFeesPaid() {
        return studentFeesCalculator.getTotalFeesPaid();
    }
}
