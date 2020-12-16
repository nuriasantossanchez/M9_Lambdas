package com.lambdas.project.domain.utils.startwithandsizedstring;

import java.util.*;
import java.util.function.Supplier;

import static java.util.stream.Collectors.*;

public class StartWithAndSizedUtils {

    private static final Supplier<Integer> sized = ()->3;
    private static final Supplier<Character> startWithCharacter = ()->'A';

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

    public List<String> getNamesStartWithAndSized(List<String> names) {
        return filter(names, s -> s.charAt(0) == this.startWithCharacter.get()
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
