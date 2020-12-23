package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.joining;

/**
 * Clase de la capa Vista
 * Extiende a la clase abstracta Task, que contiene una cabecera con un formato comun,
 * para mostrar la tarea a realizar
 *
 * Hace peticiones a la capa de Aplicacion, a traves de la clase Controller, instanciada
 * en su constructor
 *
 * Imprime el resultado de las peticiones por pantalla
 */
public class StartWithAndSizedView extends Task{

    /**
     * Tarea a realizar
     */
    private String task="Tenint una llista de cadenes de noms propis, escriu un mètode \n" +
            "que retorne una llista de totes les cadenes que comencen amb \n" +
            "la lletra 'a' (mayuscula) i tenen exactament 3 lletres. \n" +
            "Imprimeix el resultat.";

   private static final List<String> names = Arrays.asList(
            "Ann","Ais","Loren","Ala","Brian","Kevin","Ais","aut","Amstel","Aina","Ag","Ahg","Ann"
    );

    public static final Supplier<Character> startWithCharacter = ()->'A';
    public static final Supplier<Integer> sized = ()->3;

    private static Controller controller;

    public StartWithAndSizedView(Controller controller) {
        this.controller=controller;
    }

    public void show(){
        showTask(task);
        System.out.println("Names: ");
        System.out.println(names.stream().map(String::toString).collect(joining(", ")));
        System.out.println();
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
        System.out.println("Parameterized: ");
        System.out.println(controller.getNamesStartWithAndSizedParameterized(names, startWithCharacter.get(), sized.get())
                .stream().collect(joining(", ")));
        System.out.println();
    }
}
