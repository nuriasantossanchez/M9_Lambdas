package com.lambdas.project.domain.utils.string;

public class ReverseStringUtils{

    ReverseString reverseString = string -> new StringBuilder(string).reverse().toString();

    public void printReverseString(String string){
        System.out.println(reverseString.reverse(string));
    }

}
