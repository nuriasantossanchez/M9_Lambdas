package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

public class MainApp {

    private static Controller controller=Controller.getInstance();


    public static void main(String[] args) {

        new StartWithAndSizedView(controller).show();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        new EvenOddView(controller).show();

    }
}
