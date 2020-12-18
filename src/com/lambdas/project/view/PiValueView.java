package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

public class PiValueView {

    private static Controller controller;

    public PiValueView(Controller controller) {
        this.controller=controller;
    }

    public void show(){
        System.out.println();
        System.out.println("Pi Value: ");
        controller.printPiValue();
    }
}
