package com.lambdas.project.domain.utils.string;

public class StartWithAndSizedPredicate implements Predicate {

    @Override
    public boolean test(String name) {
        return name.charAt(0) == StartWithAndSizedUtils.getStartWithCharacter().get()
                && name.length() == StartWithAndSizedUtils.getSized().get();
    }

}

