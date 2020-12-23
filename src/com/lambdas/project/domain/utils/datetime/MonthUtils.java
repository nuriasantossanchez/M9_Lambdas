package com.lambdas.project.domain.utils.datetime;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Clase de la capa de Dominino, pertenece al paquete utils.datetime
 *
 * Dado un listaddo con los nombres de los meses del año, imprime
 * todos los elementos del listado
 */
public class MonthUtils {

    /**
     * Listado de tipo Month, que es un tipo enum que representa
     * los meses del año
     */
    private static final List<Month> months = Arrays.asList(
            Month.values()
    );

    /**
     * Imprime todos los meses del año haciendo uso de una
     * expresion lambda
     */
    public void printMonthsWithLambda(){
        months.stream()
                .forEach(m-> displayMonthName(m));
        System.out.println();
    }

    /**
     * Imprime todos los meses del año mediante una
     * referencia a metodo
     *
     */
    public void printMonthsWithReferenceMethod(){
        months.stream()
                .forEach(MonthUtils::displayMonthName);
        System.out.println();

    }

    /**
     * Dado un enum de tipo Month, imprime el nombre del mes que corresponda,
     * haciendo uso de la configuracion local mediante la etiqueta de idioma 'es-ES'
     *
     * @param month, enum de tipo Month
     */
    private static void displayMonthName(Month month) {
        Stream.of(month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es-ES")))
                .forEach(i -> System.out.printf("%s ", i.toUpperCase()));
    }

}
