package com.lambdas.project.application;

import com.lambdas.project.domain.utils.datetime.MonthUtils;
import com.lambdas.project.domain.utils.number.EvenOddUtils;
import com.lambdas.project.domain.utils.number.RandomNumber;
import com.lambdas.project.domain.utils.string.ContainCharacterUtils;
import com.lambdas.project.domain.utils.string.StartWithAndSizedPredicate;
import com.lambdas.project.domain.utils.string.StartWithAndSizedUtils;

import java.util.List;
import java.util.function.Supplier;


public class Controller {
    private static Controller instance=null;
    private StartWithAndSizedUtils startWithAndSizedUtils;
    private EvenOddUtils evenOddUtils;
    private ContainCharacterUtils containCharacterUtils;
    private MonthUtils monthUtils;

    private Controller() {
        startWithAndSizedUtils = new StartWithAndSizedUtils();
        evenOddUtils = new EvenOddUtils();
        containCharacterUtils = new ContainCharacterUtils();
        monthUtils = new MonthUtils();
    }

    public static Controller getInstance(){
        if (instance==null){
            instance=new Controller();
        }
        return instance;

    }

    public List<String> getNamesStartWithAndSizedParameterized(List<String> names, Character startWith, Integer sized){
        return startWithAndSizedUtils.getNamesStartWithAndSized(names,startWith,sized);
    }

    public List<String> getNamesStartWithAndSizedPredicate(List<String> names){
        return startWithAndSizedUtils.filter(names, new StartWithAndSizedPredicate());
    }

    public List<String> getNamesStartWithAndSizedLambda(List<String> names){
        return startWithAndSizedUtils.getNamesStartWithAndSized(names);
    }
    public String getEvenOddListNumbers(List<Integer> numbers){
        return evenOddUtils.getEvenOddNumbers(numbers);
    }

    public String getEvenOddVarargsNumbers(Integer...i){
        return evenOddUtils.getEvenOddNumbers(i);
    }

    public String getEvenOddRandomNumbers(){
        return evenOddUtils.getEvenOddNumbers();
    }

    public RandomNumber getRandomNumbers() {
        return evenOddUtils.getRandomNumbers();
    }

    public String getStringIfContainCharacter(List<String> strings,
                                              Supplier<Character> character){
        return containCharacterUtils.getStringIfContainCharacter(strings, character);
    }

    public String getStringIfContainCharacterAndLengthMoreThanX(List<String> strings,
                                                                Supplier<Character> character,
                                                                Supplier<Integer> length){
        return containCharacterUtils.getStringIfContainCharacterAndLengthMoreThanX(strings, character, length);
    }

    public void printMonthsWithLambda(){
        monthUtils.printMonthsWithLambda();
    }

    public void printMonthsWithReferenceMethod(){
        monthUtils.printMonthsWithReferenceMethod();
    }

}
