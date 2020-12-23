package com.lambdas.project.domain.utils.number;

/**
 * Interfaz funcional, cuyo metodo funcional retorna un
 * valor double
 *
 * La firma del metodo funcional de esta interface,
 * se adapta al descriptor funcional () -> double
 */
@FunctionalInterface
public interface PiValue {
    double getPiValue();
}
