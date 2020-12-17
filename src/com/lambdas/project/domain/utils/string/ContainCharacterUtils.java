package com.lambdas.project.domain.utils.string;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContainCharacterUtils {

    public String getStringIfContainCharacter(List<String> strings, Supplier<Character> character){
        return strings.stream()
                .filter(s->s.toUpperCase().contains(character.get().toString().toUpperCase()))
                .collect(Collectors.joining(", "));
    }

    public String getStringIfContainCharacterAndLengthMoreThanX(List<String> strings, Supplier<Character> character, Supplier<Integer> length){

        String containCharacter = getStringIfContainCharacter(strings, character);

        return Stream.of(containCharacter)
                .map(word -> word.split(","))
                .flatMap(Arrays::stream)
                .filter(word->word.length()>length.get())
                .collect(Collectors.joining(", "));

    }

}
