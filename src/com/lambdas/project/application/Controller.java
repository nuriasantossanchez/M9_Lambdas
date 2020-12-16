package com.lambdas.project.application;

import com.lambdas.project.domain.utils.evenoddnumber.EvenOddUtils;
import com.lambdas.project.domain.utils.evenoddnumber.RandomNumber;
import com.lambdas.project.domain.utils.startwithandsizedstring.StartWithAndSizedPredicate;
import com.lambdas.project.domain.utils.startwithandsizedstring.StartWithAndSizedUtils;

import java.util.List;


public class Controller {
    private static Controller instance=null;
    private StartWithAndSizedUtils startWithAndSizedUtils;
    private EvenOddUtils evenOddUtils;

    private Controller() {
        startWithAndSizedUtils = new StartWithAndSizedUtils();
        evenOddUtils =new EvenOddUtils();
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


}
