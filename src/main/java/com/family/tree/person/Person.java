package com.family.tree.person;

import com.family.tree.city.City;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class Person {

    protected final Female mother;
    protected final Male father;
    public final List<Person> children;
    public final boolean isAdopted;
    public final String firstName;
    public final String lastName;
    protected final City bornIn;
    public final Integer birthYear;
    protected final Integer deathYear;
    public final PersonFilter filter;

    protected Person(Female mother, Male father, boolean isAdopted, String firstName, String lastName,
                     City bornIn, Integer birthYear, Integer deathYear) {
        this.mother = mother;
        this.father = father;
        this.isAdopted = isAdopted;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornIn = bornIn;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.children = new LinkedList<>();
        this.filter = new PersonFilter(this);
        addToParents();
    }

    private void addToParents() {
        this.mother().ifPresent(mother -> mother.children.add(this));
        this.father().ifPresent(father -> father.children.add(this));
    }

    public abstract boolean isMale();

    public abstract boolean isFemale();

    public Optional<Female> mother() {
        return Optional.ofNullable(mother);
    }

    public Optional<Male> father() {
        return Optional.ofNullable(father);
    }

    public Optional<City> city() {
        return Optional.ofNullable(bornIn);
    }

    public Optional<Integer> deathYear() {
        return Optional.ofNullable(deathYear);
    }
}
