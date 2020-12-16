package com.lambdas.project.domain.utils.evenoddnumber;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntPredicate;


import static java.util.stream.Collectors.joining;

public class EvenOddUtils {

    private final RandomNumber randomNumbers = new RandomNumber();

    private static IntPredicate evenIntPredicate = (int i) -> i % 2 == 0;
    private static IntPredicate oddIntPredicate = (int i) -> i % 2 != 0;

    public enum PrefixEvenOdd {
        e,
        o
    }

    public RandomNumber getRandomNumbers() {
        return randomNumbers;
    }

    public String getEvenOddNumbers(List<Integer> numbers){

        return numbers.stream()
                .distinct()
                .map(EvenOddUtils::getEvenOddNumbers)
                .collect(joining(", "));

    }

    public static String getEvenOddNumbers(Integer number){

        String result = "";

        BiFunction<Integer, IntPredicate, String> evenBiFunction =
                (i, p)  -> PrefixEvenOdd.e.toString().concat(String.valueOf(i));
        BiFunction<Integer, IntPredicate, String> oddBiFunction =
                (i, p)  -> PrefixEvenOdd.o.toString().concat(String.valueOf(i));

        if(evenIntPredicate.test(number)){
            result = evenBiFunction.apply(number, evenIntPredicate);
        }
        else {
            result = oddBiFunction.apply(number, oddIntPredicate);
        }

        return result;
    }



    public String getEvenOddNumbers(Integer...i){

        return Arrays.stream(i)
                .map(n -> addPrefixEvenOdd(n))
                .distinct()
                .collect(joining(", "));
    }

    public String getEvenOddNumbers(){

        return randomNumbers.getNumbers().stream()
                .map(i -> addPrefixEvenOdd(i))
                .collect(joining(", "));
    }

    public String addPrefixEvenOdd(Integer i) {
        String evenOddNumber = "";

        if(evenIntPredicate.test(i)){
            evenOddNumber=PrefixEvenOdd.e.toString().concat(String.valueOf(i));
        }
        else if (oddIntPredicate.test(i)){
            evenOddNumber=PrefixEvenOdd.o.toString().concat(String.valueOf(i));
        }
        return evenOddNumber;
    }

}
