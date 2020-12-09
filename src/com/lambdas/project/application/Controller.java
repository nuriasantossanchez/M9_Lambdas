package com.lambdas.project.application;

import com.lambdas.project.domain.StartWithAndSizedPredicate;
import com.lambdas.project.domain.UtilsLambda;

import java.util.List;
import java.util.function.Supplier;


public class Controller {
    private static Controller instance=null;
    private UtilsLambda utilsLambda;
    public static final List<String> names = UtilsLambda.getNames();
    public static final Supplier<Integer> sized = UtilsLambda.getSized();
    public static final Supplier<Character> startWithCharacter = UtilsLambda.getStartWithCharacter();

    private Controller() {
        utilsLambda = new UtilsLambda();
    }

    public static Controller getInstance(){
        if (instance==null){
            instance=new Controller();
        }
        return instance;

    }

    public List<String> getNamesStartWithAndSizedParameterized(List<String> names, Character startWith, Integer sized){
        return utilsLambda.getNamesStartWithAndSized(names,startWith,sized);
    }

    public List<String> getNamesStartWithAndSizedPredicate(List<String> names){
        return utilsLambda.filter(names, new StartWithAndSizedPredicate());
    }

    public List<String> getNamesStartWithAndSizedLambda(){
        return utilsLambda.getNamesStartWithAndSized();
    }



}
