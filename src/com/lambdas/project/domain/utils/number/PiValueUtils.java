package com.lambdas.project.domain.utils.number;

import java.util.function.DoubleSupplier;

/**
 * Clase de la capa de Dominino, dentro del paquete utils.number
 *
 * Instancia la interface funcional PiValue e imprime el valor double
 * que retorna su metodo funcional getPiValue()
 */
public class PiValueUtils {

    /**
     * Variable de instancia que es una interface funcional de tipo
     * DoubleSupplier, utilizada para asignar una expresión lambda
     * que retorna el valor double 3.1415
     */
    private DoubleSupplier pi = ()->3.1415;

    /**
     * Variable de instancia que es una interface funcional de tipo
     * PiValue, instanciada mediante una expresión lambda que
     * retorna el valor de la variable 'pi' de tipo DoubleSupplier
     */
    private PiValue piValue = () -> pi.getAsDouble();

    /**
     * Imprime el valor double que retorna el metodo funcional getPiValue()
     * de la interface funcional PiValue, en este caso, el valor 3.1415
     */
    public void printPiValue(){
        System.out.println(piValue.getPiValue());
    }
}

