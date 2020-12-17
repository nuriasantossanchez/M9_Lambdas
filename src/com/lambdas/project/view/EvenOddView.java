package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class EvenOddView {

    private static final List<Integer> numbers = Arrays.asList(
            1,9,5,2,3,9,99,999,6,100,6,9,0
    );
    private static Controller controller;

    public EvenOddView(Controller controller) {
        this.controller = controller;
    }

    public void show(){
        showEvenOddListNumbers();
        showEvenOddVarargsNumbers();
        showEvenOddRandomNumbers();

    }

    public void showEvenOddListNumbers(){
        System.out.println();
        System.out.println("List Numbers = ["
                + numbers.stream().map(String::valueOf).collect(joining(", "))
                +"]");
        System.out.println("-------------------------------------------");
        System.out.println("Even/Odd List Numbers: ");
        System.out.println(controller.getEvenOddListNumbers(numbers));
        System.out.println("-------------------------------------------");

    }

    public void showEvenOddVarargsNumbers(){
        System.out.println();
        System.out.println("Varargs Numbers = "+ Arrays.toString(new int[]{0, 1, 1, 2, 3, 4, 4}));
        System.out.println("-------------------------------------------");
        System.out.println("Even/Odd Varargs Numbers: ");
        System.out.println(controller.getEvenOddVarargsNumbers(0, 1, 1, 2, 3, 4, 4));
        System.out.println("-------------------------------------------");
    }

    public void showEvenOddRandomNumbers(){
        System.out.println();
        System.out.println(controller.getRandomNumbers());
        System.out.println("-------------------------------------------");
        System.out.println("Even/Odd Random Numbers: ");
        System.out.println(controller.getEvenOddRandomNumbers());
        System.out.println("-------------------------------------------");
    }
}
