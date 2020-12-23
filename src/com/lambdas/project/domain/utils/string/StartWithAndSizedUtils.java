package com.lambdas.project.domain.utils.string;

import java.util.*;
import java.util.function.Supplier;

import static java.util.stream.Collectors.*;

/**
 * Clase de la capa de Dominino, pertenece al paquete utils.string
 *
 * Dado un listado de tipo String, permite identificar cadenas
 * que empiecen por un caracter y sean de una logitud determinados
 */
public class StartWithAndSizedUtils {

    /**
     * Variable de clase de tipo Supplier, interface funcional, por lo
     * que se puede utilizar para asignar una expresión lambda, en este caso,
     * un valor de tipo Integer que es la longitud maxima permitida
     *
     * El metodo funcional de la interface Supplier es 'T get()',
     * cuya firma () -> T (o function descriptor) se adpata a la
     * expresion lambda proporcionada
     *
     */
    private static final Supplier<Integer> sized = ()->3;

    /**
     * Variable de clase de tipo Supplier, interface funcional, por lo
     * que se utiliza para asignar la expresión lambda cuya firma
     * retorna un valor de tipo Character, que es el caracter utilizado
     * para filtrar las variables de tipo String que comiencen por esa letra
     *
     */
    private static final Supplier<Character> startWithCharacter = ()->'A';

    /**
     *
     * @return interface funcional de tipo Supplier<Integer>
     */
    public static Supplier<Integer> getSized() {
        return sized;
    }

    /**
     *
     * @return interface funcional de tipo Supplier<Character>
     */
    public static Supplier<Character> getStartWithCharacter() {
        return startWithCharacter;
    }

    /**
     * Dado un listado de tipo String, retorna el mismo listado filtrando
     * los elementos que comiencen por un caracter determinado ('A') y
     * tengan una logitud determinada (3), pasando ambos filtros como parametro
     *
     * @param names, listado de tipo String
     * @param startWith, Character ('A') utilizado como filtro de comienzo del String
     * @param sized, Integer (3) utilizado para filtrar la longitud del String
     * @return listado de tipo String filtrado
     */
    public List<String> getNamesStartWithAndSized(List<String> names, Character startWith, Integer sized){
        return names.stream()
                .filter(n-> n.charAt(0) == startWith && n.length() == sized)
                .distinct()
                .collect(toList());
    }

    /**
     * Dado un listado de tipo String, retorna el mismo listado filtrando
     * los elementos que comiencen por un caracter determinado ('A') y
     * tengan una logitud determinada (3), pasando ambos filtros con una
     * expresion lambda cuya firma se adapta al metodo funcional 'test(T t)'
     * de la interface funcional Predicate (function descriptor: T -> boolean)
     *
     * @param names, listado de tipo String
     * @return listado de tipo String filtrado
     */
    public List<String> getNamesStartWithAndSized(List<String> names) {
        return filter(names, s -> s.charAt(0) == startWithCharacter.get()
                            && s.length() == sized.get());
    }

    /**
     * Dado un listado de tipo String y una interface funcional de tipo
     * Predicate, retorna el mismo listado filtrando los elementos que
     * cumplan la condicion indicada por el metodo funcional, test(T),
     * de la interface Predicate
     *
     * @param names, listado de tipo String
     * @param p, interface funcional Predicate
     * @return listado de tipo String filtrado
     */
    public List<String> filter(List<String> names, Predicate p) {
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (p.test(name)) {
                result.add(name);
            }
        }
        return result.stream().distinct().collect(toList());
    }

}
