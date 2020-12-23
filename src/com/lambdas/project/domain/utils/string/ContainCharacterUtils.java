package com.lambdas.project.domain.utils.string;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase de la capa de Dominino, pertenece al paquete utils.string
 *
 * Dado un listado de tipo String, permite identificar cadenas
 * que contengan un caracter determinado y con una longitud mayor
 * a un numero dado
 */
public class ContainCharacterUtils {

    /**
     * Dado un listado de tipo String, retorna un String formado por
     * los elementos del listado que contengan el caracter pasado
     * como parametro
     *
     * @param strings, listado de tipo String
     * @param character, interface funcional  de tipo Supplier<Character>,
     *                   cuyo metodo funcional get() retorna el caracter
     *                   utilizado como filtro
     * @return String formado por los distintos elementos del listado de entrada
     * que contengan la letra 'o', separados por comas
     */
    public String getStringIfContainCharacter(List<String> strings, Supplier<Character> character){
        return strings.stream()
                .filter(s->s.toUpperCase().contains(character.get().toString().toUpperCase()))
                .collect(Collectors.joining(", "));
    }

    /**
     * Dado un listado de tipo String, retorna un String formado por
     * los elementos del listado que contengan el caracter pasado
     * como parametro y cuya longitud supere la longitud pasada como
     * paraemtro
     *
     * @param strings, listado de tipo String
     * @param character, interface funcional  de tipo Supplier<Character>,
     *                   cuyo metodo funcional get() retorna el caracter
     *                   utilizado como filtro
     * @param length, interface funcional  de tipo Supplier<Integer>,
     *                cuyo metodo funcional get() retorna la longitud
     *                utilizada como filtro
     * @return String formado por los distintos elementos del listado de entrada
     * que contengan la letra 'o' y tengan una longitud mayor a 5, separados por comas
     */
    public String getStringIfContainCharacterAndLengthMoreThanX(List<String> strings, Supplier<Character> character, Supplier<Integer> length){

        String containCharacter = getStringIfContainCharacter(strings, character);

        return Stream.of(containCharacter)
                .map(word -> word.split(","))
                .flatMap(Arrays::stream)
                .filter(word->word.length()>length.get())
                .collect(Collectors.joining(", "));

    }

}
