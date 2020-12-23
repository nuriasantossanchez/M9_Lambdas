package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

import java.util.Arrays;
import java.util.List;

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
public class EvenOddView extends Task{

    /**
     * Tarea a realizar
     */
    private String task="Escriu un mètode que retorne una cadena separada per comes basada \n" +
                    "en una llista d’Integers. Cada element hauria d'anar precedit per \n" +
                    "la lletra \"e\" si el nombre és parell, i precedit de la lletra \"o\" \n" +
                    "si el nombre és imparell. Per exemple, si la llista d'entrada és \n" +
                    "(3,44), la sortida hauria de ser \"o3, e44\". Imprimeix el resultat.";

    private static final List<Integer> numbers = Arrays.asList(
            1,9,5,2,3,9,99,999,6,100,6,9,0
    );
    private static Controller controller;

    public EvenOddView(Controller controller) {
        this.controller = controller;
    }

    public void show(){
        showTask(task);
        showEvenOddListNumbers();
        showEvenOddVarargsNumbers();
        showEvenOddRandomNumbers();

    }

    public void showEvenOddListNumbers(){
        System.out.println("List Numbers = ["
                + numbers.stream().map(String::valueOf).collect(joining(", "))
                +"]");
        System.out.println("Even/Odd List Numbers: ");
        System.out.println(controller.getEvenOddListNumbers(numbers));
        System.out.println();

    }

    public void showEvenOddVarargsNumbers(){
        System.out.println("Varargs Numbers = "+ Arrays.toString(new int[]{0, 1, 1, 2, 3, 4, 4}));
        System.out.println("Even/Odd Varargs Numbers: ");
        System.out.println(controller.getEvenOddVarargsNumbers(0, 1, 1, 2, 3, 4, 4));
        System.out.println();
    }

    public void showEvenOddRandomNumbers(){
        System.out.println(controller.getRandomNumbers());
        System.out.println("Even/Odd Random Numbers: ");
        System.out.println(controller.getEvenOddRandomNumbers());
        System.out.println();
    }
}
