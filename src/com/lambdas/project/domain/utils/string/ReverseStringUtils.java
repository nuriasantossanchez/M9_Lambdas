package com.lambdas.project.domain.utils.string;

/**
 * Clase de la capa de Dominino, dentro del paquete utils.string
 *
 * Instancia la interface funcional ReverseString e imprime el String
 * que retorna su metodo funcional reverse()
 */
public class ReverseStringUtils{

    /**
     * Variable de instancia que es una interface funcional de tipo
     * ReverseString, instanciada mediante una expresión lambda, que
     * dado un String, retorna el mismo String mostrandolo al reves
     */
    private ReverseString reverseString = string -> new StringBuilder(string).reverse().toString();

    /**
     * Imprime el String que retorna el metodo funcional reverse(String)
     * de la interface funcional ReverseString, que es el mismo String que
     * recibe como parametro, pero mostrandolo al reves
     *
     * @param string, tipo String que ha de mostrarse al reves tras llamar
     *                al metodo funcional reverse(String)
     */
    public void printReverseString(String string){
        System.out.println(reverseString.reverse(string));
    }

}
