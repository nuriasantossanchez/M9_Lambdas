package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

public class MonthNameView {
    private static Controller controller;

    public MonthNameView(Controller controller) {
        this.controller=controller;
    }

    public void show(){
        System.out.println("-------------------------------------------");
        System.out.println("Months Names");
        System.out.println("-------------------------------------------");
        showLambdaMonthName();
        System.out.println();
        showReferenceMethodMonthName();
    }
    public void showLambdaMonthName(){
        System.out.println("With Lambda: ");
        controller.printMonthsWithLambda();
    }
    public void showReferenceMethodMonthName(){
        System.out.println("With Reference Method: ");
        controller.printMonthsWithReferenceMethod();
    }

}
