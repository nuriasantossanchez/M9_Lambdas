package com.lambdas.project.domain.utils.datetime;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;


public class MonthUtils {

    private static final List<Month> months = Arrays.asList(
            Month.values()
    );

    public void printMonthsWithLambda(){
        months.stream()
                .forEach(m-> displayMonthName(m));
        System.out.println();
    }


    public void printMonthsWithReferenceMethod(){
        months.stream()
                .forEach(MonthUtils::displayMonthName);
        System.out.println();

    }

    private static void displayMonthName(Month month) {
        Stream.of(month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es-ES")))
                .forEach(i -> System.out.printf("%s ", i.toUpperCase()));
    }

}
