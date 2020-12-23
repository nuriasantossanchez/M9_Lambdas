package com.lambdas.project.application;

import com.lambdas.project.domain.utils.datetime.MonthUtils;
import com.lambdas.project.domain.utils.number.EvenOddUtils;
import com.lambdas.project.domain.utils.number.PiValueUtils;
import com.lambdas.project.domain.utils.number.RandomNumber;
import com.lambdas.project.domain.utils.string.ContainCharacterUtils;
import com.lambdas.project.domain.utils.string.ReverseStringUtils;
import com.lambdas.project.domain.utils.string.StartWithAndSizedPredicate;
import com.lambdas.project.domain.utils.string.StartWithAndSizedUtils;

import java.util.List;
import java.util.function.Supplier;

/**
 * Clase de la capa Aplicacion
 *
 * Instancia los objetos del modelo e invoca peticiones sobre esos objetos
 *
 * Mantiene la vista y el modelo separados, haciendo de intermediario entre ambos
 *
 * Implementa el patron Singleton
 *
 */
public class Controller {
    private static Controller instance=null;
    private StartWithAndSizedUtils startWithAndSizedUtils;
    private EvenOddUtils evenOddUtils;
    private ContainCharacterUtils containCharacterUtils;
    private MonthUtils monthUtils;
    private PiValueUtils piValueUtils;
    private ReverseStringUtils reverseStringUtils;

    /**
     * Constructor privado de la clase Controller.
     * Implementa el patron Singleton por lo que la clase tendra una
     * instancia unica y sera accedida por un solo punto global.
     *
     * Instancia las clases de utilidades del modelo
     */
    private Controller() {
        startWithAndSizedUtils = new StartWithAndSizedUtils();
        evenOddUtils = new EvenOddUtils();
        containCharacterUtils = new ContainCharacterUtils();
        monthUtils = new MonthUtils();
        piValueUtils = new PiValueUtils();
        reverseStringUtils = new ReverseStringUtils();
    }

    /**
     * Punto global de acceso a la instancia de la clase Controller
     *
     * @return instacia de la clase Controller
     */
    public static Controller getInstance(){
        if (instance==null){
            instance=new Controller();
        }
        return instance;

    }

    /**
     * Delega en un objeto de tipo StartWithAndSizedUtils la accion de filtrar
     * un listado de cadenas que comiencen por un caracter y tengan una longitud
     * determinados, pasando ambos filtros como parametros
     *
     * @param names, listado de tipo String
     * @param startWith, tipo de dato Character utilizado como filtro de comienzo de String
     * @param sized, Integer utilizado para filtrar la longitud de un String
     * @return listado de tipo String filtrado
     */
    public List<String> getNamesStartWithAndSizedParameterized(List<String> names, Character startWith, Integer sized){
        return startWithAndSizedUtils.getNamesStartWithAndSized(names,startWith,sized);
    }

    /**
     * Delega en un objeto de tipo StartWithAndSizedUtils la accion de filtrar
     * un listado de cadenas que comiencen por un caracter y tengan una longitud
     * determinados, parametrizando el comportamiento a traves de una interface
     * funcional
     *
     * @param names, listado de tipo String
     * @return listado de tipo String filtrado
     */
    public List<String> getNamesStartWithAndSizedPredicate(List<String> names){
        return startWithAndSizedUtils.filter(names, new StartWithAndSizedPredicate());
    }

    /**
     * Delega en un objeto de tipo StartWithAndSizedUtils la accion de filtrar
     * un listado de cadenas que comiencen por un caracter y tengan una longitud
     * determinados, haciendo uso de una expresion lambda
     *
     * @param names, listado de tipo String
     * @return listado de tipo String filtrado
     */
    public List<String> getNamesStartWithAndSizedLambda(List<String> names){
        return startWithAndSizedUtils.getNamesStartWithAndSized(names);
    }

    /**
     * Delega en un objeto de tipo EvenOddUtils la accion de añadir a cada elemento
     * de un listado de Integer, el prefijo "e", par, "o" impar, haciendo uso de
     * una referencia a metodo
     *
     * @param numbers, listado de tipos Integer
     * @return String formado por los distintos elementos del listado de entrada
     * anteponiendo a cada elemento el prefijo "e", par, "o" impar, y separados
     * por comas
     */
    public String getEvenOddListNumbers(List<Integer> numbers){
        return evenOddUtils.getEvenOddNumbers(numbers);
    }

    /**
     * Delega en un objeto de tipo EvenOddUtils la accion de añadir a cada elemento
     * de un listado de Integer, el prefijo "e", par, "o" impar, haciendo uso de
     * una expresion lambda
     *
     * @param i, elemntos de tipo Integer del array, de tamaño indeterminado
     * @return String compuesto por cada elemento del array concatenado
     * con el prefijo "e"/"o", en funcion de si el numero es par o impar
     */
    public String getEvenOddVarargsNumbers(Integer...i){
        return evenOddUtils.getEvenOddNumbers(i);
    }

    /**
     * Delega en un objeto de tipo EvenOddUtils la accion de añadir a cada elemento
     * de un listado de Integer generado de forma aleatoria, el prefijo "e", par,
     * "o" impar, haciendo uso de una expresion lambda
     *
     * @return String compuesto por cada elemento del listado concatenado
     * con el prefijo "e"/"o", en funcion de si el numero es par o impar
     */
    public String getEvenOddRandomNumbers(){
        return evenOddUtils.getEvenOddNumbers();
    }

    /**
     * Delega en un objeto de tipo EvenOddUtils la accion de obtener
     * una instancia de la clase RandomNumber
     *
     * @return listado de 10 numeros aleatorios distintos, encapsulados
     * en la instacia de tipo RandomNumber
     */
    public RandomNumber getRandomNumbers() {
        return evenOddUtils.getRandomNumbers();
    }

    /**
     * Delega en un objeto de tipo ContainCharacterUtils la accion de filtrar
     * un listado de cadenas que contengan un caracter determinado
     *
     * @param strings, listado de tipo String
     * @param character, interface funcional  de tipo Supplier<Character>,
     *                   cuyo metodo funcional get() retorna el caracter
     *                   utilizado como filtro
     * @return String formado por los distintos elementos del listado de entrada
     * que contengan un caracter determinado, separados por comas
     */
    public String getStringIfContainCharacter(List<String> strings,
                                              Supplier<Character> character){
        return containCharacterUtils.getStringIfContainCharacter(strings, character);
    }

    /**
     * Delega en un objeto de tipo ContainCharacterUtils la accion de filtrar
     * un listado de cadenas que contengan un caracter y tengan una longitud
     * determinados
     *
     * @param strings, listado de tipo String
     * @param character, interface funcional  de tipo Supplier<Character>,
     *                   cuyo metodo funcional get() retorna el caracter
     *                   utilizado como filtro
     * @param length, interface funcional  de tipo Supplier<Integer>,
     *                cuyo metodo funcional get() retorna la longitud
     *                utilizada como filtro
     * @return String formado por los distintos elementos del listado de entrada
     * que contengan un caracter y tengan una longitud determinados
     */
    public String getStringIfContainCharacterAndLengthMoreThanX(List<String> strings,
                                                                Supplier<Character> character,
                                                                Supplier<Integer> length){
        return containCharacterUtils.getStringIfContainCharacterAndLengthMoreThanX(strings, character, length);
    }

    /**
     * Delega en un objeto de tipo MonthUtils la accion de imprimir
     * los meses del año, haciendo uso de una expresion lambda
     */
    public void printMonthsWithLambda(){
        monthUtils.printMonthsWithLambda();
    }

    /**
     * Delega en un objeto de tipo MonthUtils la accion de imprimir
     * los meses del año, haciendo uso de una referencia a metodo
     */
    public void printMonthsWithReferenceMethod(){
        monthUtils.printMonthsWithReferenceMethod();
    }

    /**
     * Delega en un objeto de tipo PiValueUtils la accion de imprimir
     * un valor double, haciendo uso de una interface funcional
     */
    public void printPiValue(){
        piValueUtils.printPiValue();
    }

    /**
     * Delega en un objeto de tipo ReverseStringUtils la accion de imprimir
     * un valor String al reves, haciendo uso de una interface funcional
     *
     * @param string, tipo String que ha de mostrarse al reves tras llamar
     *                al metodo funcional de la interface funcional
     */
    public void printReverseString(String string){
        reverseStringUtils.printReverseString(string);
    }

}
