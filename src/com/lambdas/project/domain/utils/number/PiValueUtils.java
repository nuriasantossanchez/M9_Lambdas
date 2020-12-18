package com.lambdas.project.domain.utils.number;

import java.util.function.DoubleSupplier;

public class PiValueUtils {

    private static final DoubleSupplier pi = ()->3.1415;

    PiValue piValue = () -> pi.getAsDouble();

    public void printPiValue(){
        System.out.println(piValue.getPiValue());
    }
}

