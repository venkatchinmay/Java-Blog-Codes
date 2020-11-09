package com.student.concealed;

public class StudentFeesCalculation {
    private double totalFeesPerAnnum = 100000000d;
    private double totalFeesPaid = 0d;
    private double feesPaidNow = 0d;

    public double getFeesPaidNow() {
        return feesPaidNow;
    }
    public void setFeesPaidNow(double feesPaidNow) {
        this.feesPaidNow = feesPaidNow;
    }
    public double getTotalFeesPerAnnum() {
        return totalFeesPerAnnum;
    }
    public double getTotalFeesPaid() {
        totalFeesPaid = totalFeesPaid + getFeesPaidNow();
        return totalFeesPaid;
    }
    public double getRemainingFeesNeedToPaid() {
        return totalFeesPerAnnum - getTotalFeesPaid();
    }
}
