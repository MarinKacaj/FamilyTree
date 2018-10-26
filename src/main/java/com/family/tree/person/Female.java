package com.family.tree.person;

import com.family.tree.city.City;

public class Female extends Person {

    public Female(Female mother, Male father, boolean isAdopted,
                  String firstName, String lastName, City bornIn, Integer birthYear, Integer deathYear) {
        super(mother, father, isAdopted, firstName, lastName, bornIn, birthYear, deathYear);
    }

    public boolean isMale() {
        return false;
    }

    public boolean isFemale() {
        return true;
    }
}
