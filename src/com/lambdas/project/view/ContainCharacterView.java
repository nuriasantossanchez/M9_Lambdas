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
public class ContainCharacterView extends Task{
    /**
     * Tarea 1 a realizar
     */
    private String task1="Tenint una llista de Strings, escriu un mètode que retorne \n" +
            "una llista de totes les cadenes que continguen la lletra ‘o’ \n" +
            "i imprimeix el resultat.";

    /**
     * Tarea 2 a realizar
     */
    private String task2="Has de fer el mateix que en el punt anterior, però retornant \n" +
            "una llista que incloga els elements amb més de 5 lletres. \n" +
            "Imprimeix el resultat.";

    private static final List<String> strings = Arrays.asList(
            "HELLO","Modern","Java","Functional","Programming","In","Action"
    );

    private static final Supplier<Character> character = ()->'o';
    private static final Supplier<Integer> length = ()->5;

    private static Controller controller;

    public ContainCharacterView(Controller controller) {
        this.controller=controller;
    }

    public void show(){
        showTask(task1);
        System.out.println("List Strings = ["
                + strings.stream().collect(joining(", "))
                +"]");
        System.out.println();
        showStringIfContainCharacter();
        showTask(task2);
        showStringIfContainCharacterAndLengthMoreThanX();
    }

    public void showStringIfContainCharacter(){
        System.out.println("Contain Character '" +character.get()+"': ");
        System.out.println(controller.getStringIfContainCharacter(strings,character));
        System.out.println();
    }

    public void showStringIfContainCharacterAndLengthMoreThanX(){
        System.out.println("Contain Character '" +character.get()
                +"' And Length More Than '"+length.get()+"': ");
        System.out.println(controller.getStringIfContainCharacterAndLengthMoreThanX(strings,character,length));
        System.out.println();
    }
}
