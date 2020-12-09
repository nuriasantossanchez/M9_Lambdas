package com.lambdas.project.domain;

import java.util.*;
import java.util.function.Supplier;

import static java.util.stream.Collectors.*;

public class UtilsLambda {

    private static final List<String> names = Arrays.asList(
            "Ann","Ais","Loren","Ala","Brian","Kevin","Ais","aut","Amstel","Aina","Ag","Agg","Ann"
    );
    public static final Supplier<Integer> sized = ()->3;
    public static final Supplier<Character> startWithCharacter = ()->'A';

    public static List<String> getNames() {
        return names;
    }

    public static Supplier<Integer> getSized() {
        return sized;
    }

    public static Supplier<Character> getStartWithCharacter() {
        return startWithCharacter;
    }

    public List<String> getNamesStartWithAndSized(List<String> names, Character startWith, Integer sized){
        return names.stream()
                .filter(n-> n.charAt(0) == startWith && n.length() == sized)
                .distinct()
                .collect(toList());
    }

    public List<String> getNamesStartWithAndSized() {
        return  filter(this.names, s -> s.charAt(0) == this.startWithCharacter.get()
                && s.length() == this.sized.get());
    }

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
