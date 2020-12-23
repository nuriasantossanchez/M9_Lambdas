package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

import java.util.function.Supplier;

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
public class ReverseStringView extends Task{

    /**
     * Tarea a realizar
     */
    private String task="Crea una Functional Interface que continga un mètode abstracte \n" +
            "reverse(), que retorne un valor String; en una altra classe, \n" +
            "injecta a la interfície creada mitjançant una lambda el cos del \n" +
            "mètode, de manera que torne la mateixa cadena que rep com a \n" +
            "paràmetre però a l'inrevés. Invoca la instància de la interfície \n" +
            "passant-li una cadena i comprovant el resultat.";

    public static final Supplier<String> string =
            ()->("   gnimmargorp evitcaer dna lanoitcnuf ,smaerts ,sadbmaL" +
                    " - noitcA ni avaJ nredoM   ").trim();
    private static Controller controller;

    public ReverseStringView(Controller controller) {
        this.controller = controller;
    }

    public void show(){
        showTask(task);
        System.out.println("String: " );
        System.out.println(string.get());
        System.out.println();
        System.out.println("Reverse String: " );
        controller.printReverseString(string.get());

    }
}
