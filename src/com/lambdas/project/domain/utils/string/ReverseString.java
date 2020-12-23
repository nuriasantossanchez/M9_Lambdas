package com.lambdas.project.domain.utils.string;

/**
 * Interfaz funcional, cuyo metodo funcional retorna un
 * valor String, que es el mismo String que recibe como
 * parametro, pero mostrado al reves
 *
 * La firma del metodo funcional de esta interface,
 * se adapta al descriptor funcional String -> String
 */
@FunctionalInterface
public interface ReverseString {
    String reverse(String string);
}
