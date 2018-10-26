package com.family.tree.person;

import com.family.tree.city.City;

public class Male extends Person {

    public Male(Female mother, Male father, boolean isAdopted,
                String firstName, String lastName, City bornIn, Integer birthYear, Integer deathYear) {
        super(mother, father, isAdopted, firstName, lastName, bornIn, birthYear, deathYear);
    }

    public boolean isMale() {
        return true;
    }

    public boolean isFemale() {
        return false;
    }
}
