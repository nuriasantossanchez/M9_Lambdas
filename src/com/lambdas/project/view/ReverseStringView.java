package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

import java.util.function.Supplier;

public class ReverseStringView {

    public static final Supplier<String> string =
            ()->("   gnimmargorp evitcaer dna lanoitcnuf ,smaerts ,sadbmaL" +
                    " - noitcA ni avaJ nredoM   ").trim();
    private static Controller controller;

    public ReverseStringView(Controller controller) {
        this.controller = controller;
    }

    public void show(){
        System.out.println();
        System.out.println("String: " );
        System.out.println(string.get());
        System.out.println();
        System.out.println("Reverse String: " );
        controller.printReverseString(string.get());

    }
}
