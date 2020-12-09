package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

import static java.util.stream.Collectors.joining;


public class MainApp {

    private static Controller controller=Controller.getInstance();

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Names: ");
        System.out.println(Controller.names.stream().map(String::toString).collect(joining(", ")));
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Start With 'A' And Sized = 3");
        System.out.println("---------------------------------");
        System.out.println();
        System.out.println("Parameterized: ");
        System.out.println(controller.getNamesStartWithAndSizedParameterized(Controller.names, Controller.startWithCharacter.get(), Controller.sized.get())
                .stream().collect(joining(", ")));
        System.out.println();
        System.out.println("Predicate: ");
        System.out.println(controller.getNamesStartWithAndSizedPredicate(Controller.names)
                .stream().collect(joining(", ")));
        System.out.println();
        System.out.println("Lambda: ");
        System.out.println(controller.getNamesStartWithAndSizedLambda()
                .stream().collect(joining(", ")));
    }
}
