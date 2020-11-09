package com.student.details;

import com.student.export.Student;

public class CheckingFees {
    public static void main(String args[]){
       // StudentFeesCalculation st = new StudentFeesCalculation();
        Student st = new Student(1L,"Chinmay");
        st.setFeesPaid(1000);
        System.out.println("------"+st.getRemainingFeesNeedToPaid());
        st.setFeesPaid(1000);
        System.out.println("------"+st.getFeesPaid());
        System.out.println("------"+st.getRemainingFeesNeedToPaid());
    }
}
