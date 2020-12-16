package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.joining;

public class StartWithAndSizedView {

    private static final List<String> names = Arrays.asList(
            "Ann","Ais","Loren","Ala","Brian","Kevin","Ais","aut","Amstel","Aina","Ag","Agg","Ann","Laura"
    );
    public static final Supplier<Character> startWithCharacter = ()->'L';
    public static final Supplier<Integer> sized = ()->5;

    private static Controller controller;

    public StartWithAndSizedView(Controller controller) {
        this.controller=controller;
    }

    public void show(){
        System.out.println();
        System.out.println("Names: ");
        System.out.println(names.stream().map(String::toString).collect(joining(", ")));
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Start With 'A' And Sized = 3");
        System.out.println("---------------------------------");
        showStartWithAndSizedLambda();
        showStartWithAndSizedPredicate();
        showStartWithAndSizedParametrized();
    }
    public void showStartWithAndSizedLambda(){
        System.out.println("Lambda: ");
        System.out.println(controller.getNamesStartWithAndSizedLambda(names)
                .stream().collect(joining(", ")));
        System.out.println();
    }
    public void showStartWithAndSizedPredicate(){
        System.out.println("Predicate: ");
        System.out.println(controller.getNamesStartWithAndSizedPredicate(names)
                .stream().collect(joining(", ")));
        System.out.println();
    }
    public void showStartWithAndSizedParametrized(){
        System.out.println("-------------------------------------------");
        System.out.println("Parameterized: " + "Start With " +startWithCharacter.get()+ " And Sized = " +sized.get());
        System.out.println("-------------------------------------------");
        System.out.println(controller.getNamesStartWithAndSizedParameterized(names, startWithCharacter.get(), sized.get())
                .stream().collect(joining(", ")));
        System.out.println();

    }
}
