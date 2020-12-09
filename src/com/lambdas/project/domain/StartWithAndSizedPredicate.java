package com.lambdas.project.domain;


import static com.lambdas.project.domain.UtilsLambda.sized;
import static com.lambdas.project.domain.UtilsLambda.startWithCharacter;

public class StartWithAndSizedPredicate implements Predicate {

    @Override
    public boolean test(String name) {
        return name.charAt(0) == startWithCharacter.get()
                && name.length() == sized.get();
    }

}

