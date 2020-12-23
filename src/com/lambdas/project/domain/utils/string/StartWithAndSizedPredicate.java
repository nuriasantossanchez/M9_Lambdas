package com.lambdas.project.domain.utils.string;

/**
 * Clase de la capa de Dominino, dentro del paquete utils.string
 *
 * Implementa la interfaz funcional Predicate
 */
public class StartWithAndSizedPredicate implements Predicate {


    /**
     * Implementacion del metodo funcional test(T), cuyo
     * function descriptor es String -> boolean
     *
     * Dado un String, retorna un tipo de dato boolean en funcion de si
     * el caracter inicial y la longitud de dicho String coinciden con
     * los valores predeterminados (caracter de inicio 'A', longitud 3)
     *
     * @param name, tipo de dato String
     * @return true, si el String pasado como parametro cumple unas condiciones
     * determinadas (caracter de inicio 'A' y longitud 3), false en caso contrario
     */
    @Override
    public boolean test(String name) {
        return name.charAt(0) == StartWithAndSizedUtils.getStartWithCharacter().get()
                && name.length() == StartWithAndSizedUtils.getSized().get();
    }

}

