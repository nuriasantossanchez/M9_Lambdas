package com.lambdas.project.domain.utils.number;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;

import static java.util.stream.Collectors.joining;

/**
 * Clase de la capa de Dominino, dentro del paquete utils.number
 *
 * Dado un listado de tipo Integer, permite añadir a cada elemento
 * del listado el prefijo 'e', si el numero es par, o el prefijo 'o',
 * si el numero es impar
 *
 */
public class EvenOddUtils {

    /**
     * Variable de instacina de tipo RandomNumber
     */
    private final RandomNumber randomNumbers;

    /**
     * Constructor de la clase, instancia el objeto tipo RandomNumber
     * que retorna un listado de 10 numeros aleatorios distintos
     */
    public EvenOddUtils() {
        randomNumbers = new RandomNumber();
    }

    /**
     * Tipo enum, compuesto por las constantes EVEN y ODD que almacenan
     * los valores String "e" y "o", respectivamente
     *
     */
    public enum PrefixEvenOdd {
        EVEN("e"),
        ODD("o");

        private String prefix;

        PrefixEvenOdd(String prefix) {
            this.prefix=prefix;
        }

        public String getPrefix() {
            return prefix;
        }
    }

    /**
     *
     * @return listado de 10 numeros aleatorios distintos, encapsulados
     * en la instacia de tipo RandomNumber
     */
    public RandomNumber getRandomNumbers() {
        return randomNumbers;
    }

    /**
     * Dado un listado de tipos Integer, retorna el mismo listado anteponiendo a
     * cada elemento el prefijo "e"/"o", en función de si el numero es par o
     * impar
     *
     * Utiliza una referencia a metodo para mapear los elementos de la secuencia
     * aplicando a cada elemento la funcion dada
     * (operacion intermedia)
     *
     * Realiza una operacion de reduccion de los elementos mediante un Collector
     * que concatena los elementos de entrada, separados por el delimitador especificado
     * (operacion terminal)
     *
     * @param numbers, listado de tipos Integer
     * @return String formado por los distintos elementos del listado de entrada
     * anteponiendo a cada elemento el prefijo "e", par, "o" impar, y separados
     * por comas
     */
    public String getEvenOddNumbers(List<Integer> numbers){

        return numbers.stream()
                .distinct()
                .map(EvenOddUtils::getEvenOddNumbers)
                .collect(joining(", "));

    }

    /**
     * Dado un tipo Integer, retorna un String compuesto por el mismo
     * Integer anteponiendo al elemento el prefijo "e"/"o", en funcion
     * de si el numero es par o impar
     *
     * Utiliza la interface funcional Function<T, R> que sirve de
     * destino para una expresion lambda, cuya firma se adapta al
     * descriptor funcional T -> R, propio del metodo funcional
     * 	apply(T t)
     *
     * @param number, tipo Integer
     * @return String compuesto por el elemento Integer de entrada
     * concatenado con el prefijo "e"/"o", en funcion de si el
     * numero es par o impar
     */
    public static String getEvenOddNumbers(Integer number){

        Function<Integer, String> prefixEvenOddFunction =
                i  -> addPrefixEvenOdd(i);

        return prefixEvenOddFunction.apply(number);
    }

    /**
     * Dado un array de longitud indeterminada de tipos Integer,
     * retorna un String compuesto por cada elemento del array
     * concatenado con el prefijo "e"/"o", en funcion de si el
     * numero es par o impar
     *
     * Utiliza una expresion lambda para mapear los elementos de la secuencia
     * aplicando a cada elemento la funcion dada
     *
     * @param i, elemntos de tipo Integer del array, de tamaño indeterminado
     * @return String compuesto por cada elemento del array concatenado
     * con el prefijo "e"/"o", en funcion de si el numero es par o impar
     */
    public String getEvenOddNumbers(Integer...i){

        return Arrays.stream(i)
                .map(n -> addPrefixEvenOdd(n))
                .distinct()
                .collect(joining(", "));
    }

    /**
     * Utiliza la instancia de tipo RandomNumber, inicializada en el constructor
     * de la clase y mapea con una expresion lambda, cada elemento del listado
     * aleatorios de numeros, aplicando a cada elemento la funcion dada
     *
     * @return String compuesto por cada elemento del listado concatenado
     * con el prefijo "e"/"o", en funcion de si el numero es par o impar
     */
    public String getEvenOddNumbers(){

        return randomNumbers.getNumbers().stream()
                .map(i -> addPrefixEvenOdd(i))
                .collect(joining(", "));
    }

    /**
     * Dado un tipo Integer, retorna un String concatenando el numero con
     * el prefijo "e"/"o", en funcion de si es par o impar
     *
     * Utiliza la interfaz funcional IntPredicate que sirve de destino
     * para una expresion lambda, cuya firma se adapta al descriptor
     * funcional int -> boolean, propio del metodo funcional test(int)
     *
     * @param number, elemento de tipo Integer
     * @return String compuesto por el elemento Integer de entrada
     * concatenado con el prefijo "e"/"o", en funcion de si el
     * numero es par o impar
     */
    public static String addPrefixEvenOdd(Integer number) {
        String evenOddNumber = "";

        IntPredicate evenIntPredicate =  i -> i % 2 == 0;

        if(evenIntPredicate.test(number)){
            evenOddNumber=PrefixEvenOdd.EVEN.getPrefix().concat(String.valueOf(number));
        }
        else{
            evenOddNumber=PrefixEvenOdd.ODD.getPrefix().concat(String.valueOf(number));
        }
        return evenOddNumber;
    }
}
