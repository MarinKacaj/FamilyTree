package com.family.tree.person;

public class UnrelatedMale extends UnrelatedPerson {

    public UnrelatedMale(boolean isAdopted, String firstName, String lastName, Integer birthYear, Integer deathYear) {
        super(isAdopted, firstName, lastName, birthYear, deathYear);
    }

    @Override
    public boolean isMale() {
        return true;
    }

    @Override
    public boolean isFemale() {
        return false;
    }
}
