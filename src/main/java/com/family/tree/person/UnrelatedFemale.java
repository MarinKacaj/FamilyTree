package com.family.tree.person;

public class UnrelatedFemale extends UnrelatedPerson {

    public UnrelatedFemale(boolean isAdopted, String firstName, String lastName, Integer birthYear, Integer deathYear) {
        super(isAdopted, firstName, lastName, birthYear, deathYear);
    }

    @Override
    public boolean isMale() {
        return false;
    }

    @Override
    public boolean isFemale() {
        return false;
    }
}
