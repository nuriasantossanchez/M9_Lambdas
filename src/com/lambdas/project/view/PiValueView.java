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
public class PiValueView extends Task{

    /**
     * Tarea a realizar
     */
    private String task="Crea una Functional Interface que continga un mètode abstracte \n" +
            "getPiValue(), que retorna un valor double; en una altra classe,  \n" +
            "instancie la interfície i assigneu-li mitjançant una lambda el \n" +
            "valor 3.1415. Invoca el mètode getPiValue de la instància \n" +
            "d'interfície i imprimeix el resultat.";

    private static Controller controller;

    public PiValueView(Controller controller) {
        this.controller=controller;
    }

    public void show(){
        showTask(task);
        System.out.println("Pi Value: ");
        controller.printPiValue();
    }
}
