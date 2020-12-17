package com.lambdas.project.view;

import com.lambdas.project.application.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.joining;

public class ContainCharacterView {

    private static Controller controller;

    private static final List<String> strings = Arrays.asList(
            "HELLO","Modern","Java","Functional","Programming","In","Action"
    );

    private static final Supplier<Character> character = ()->'o';
    private static final Supplier<Integer> length = ()->5;

    public ContainCharacterView(Controller controller) {
        this.controller=controller;
    }

    public void show(){
        System.out.println();
        System.out.println("List Strings = ["
                + strings.stream().collect(joining(", "))
                +"]");
        System.out.println("-------------------------------------------");
        showStringIfContainCharacter();
        System.out.println("-------------------------------------------");
        showStringIfContainCharacterAndLengthMoreThanX();
    }

    public void showStringIfContainCharacter(){
        System.out.println();
        System.out.println("Contain Character '" +character.get()+"': ");
        System.out.println(controller.getStringIfContainCharacter(strings,character));

    }

    public void showStringIfContainCharacterAndLengthMoreThanX(){
        System.out.println();
        System.out.println("Contain Character '" +character.get()
                +"' And Length More Than '"+length.get()+"': ");
        System.out.println(controller.getStringIfContainCharacterAndLengthMoreThanX(strings,character,length));
    }
}
