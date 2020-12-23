package com.lambdas.project.domain.utils.string;

/**
 * Interface funcional de tipo Predicate de la capa de Dominino,
 * dentro del paquete utils.string
 *
 * Como cualquier interface funcional proporciona un tipo de destino
 * para expresiones lambda y referencias a metodos, a traves de un
 * metodo funcional (unico metodo abstracto), al cual se hacen coincidir
 * el parámetro de la expresión lambda y los tipos de retorno
 *
 * La firma del metodo funcional de la interface Predicate, test(String),
 * se adapta al function descriptor String -> boolean
 *
 */
@FunctionalInterface
public interface Predicate {
    boolean test(String name);
}
