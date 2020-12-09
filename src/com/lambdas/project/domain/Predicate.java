package com.lambdas.project.domain;

@FunctionalInterface
public interface Predicate {
    boolean test(String name);
}
