package com.lambdas.project.domain.utils.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RandomNumber {

    private List<Integer> numbers;

    public RandomNumber(){
        numbers = new ArrayList<>();

        Random rand = new Random();
        numbers = Stream.generate(()->rand.nextInt(100))
                        .distinct()
                        .limit(10)
                        .collect(toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Random Numbers = " + numbers ;
    }
}
