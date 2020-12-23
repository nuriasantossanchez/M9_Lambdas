package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

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
public class MonthNameView extends Task{

    /**
     * Tarea 1 a realizar
     */
    private String task1="Crea una llista amb els nombs dels mesos de l’any. Imprimeix tots \n" +
            "els elements de la llista amb una lambda.";

    /**
     * Tarea 2 a realizar
     */
    private String task2="Has de fer la mateixa impressió del punt anterior però fent-ho \n" +
            "mitjançant method reference.";

    private static Controller controller;

    public MonthNameView(Controller controller) {
        this.controller=controller;
    }

    public void show(){
        showTask(task1);
        showLambdaMonthName();
        showTask(task2);
        showReferenceMethodMonthName();
    }
    public void showLambdaMonthName(){
        System.out.println("With Lambda: ");
        controller.printMonthsWithLambda();
        System.out.println();
    }
    public void showReferenceMethodMonthName(){
        System.out.println("With Reference Method: ");
        controller.printMonthsWithReferenceMethod();
        System.out.println();
    }

}
