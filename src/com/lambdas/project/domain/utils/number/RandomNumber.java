package com.lambdas.project.domain.utils.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Clase de la capa de Dominino, dentro del paquete utils.number
 *
 * Inicializa un listado de tipo Integer con valores aleatorios distintos
 * comprendidos entre 0 y 100
 */
public class RandomNumber {

    /**
     * Variable de instancia de tipo List<Integer>
     */
    private List<Integer> numbers;


    /**
     * Constructor de la clase, inicializa un listado de 10 elementos
     * de tipo Integer, con valores aleatorios distintos comprendidos
     * entre 0 y 100
     *
     */
    public RandomNumber(){
        numbers = new ArrayList<>();

        Random rand = new Random();
        numbers = Stream.generate(()->rand.nextInt(100))
                        .distinct()
                        .limit(10)
                        .collect(toList());
    }

    /**
     *
     * @return listado de Integer generados de forma aleatoria
     */
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Random Numbers = " + numbers ;
    }
}
