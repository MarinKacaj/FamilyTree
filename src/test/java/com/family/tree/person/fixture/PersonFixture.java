package com.family.tree.person.fixture;

import com.family.tree.city.City;
import com.family.tree.country.Country;
import com.family.tree.person.Female;
import com.family.tree.person.Male;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Calendar;

public class PersonFixture {

    private final DataFactory df;
    private final int currentYear;
    private final Country italy;
    private final City rome;
    private final boolean isAdopted;

    public PersonFixture() {
        this.df = new DataFactory();
        this.currentYear = Calendar.getInstance().get(Calendar.YEAR);
        this.italy = new Country("Italy");
        this.rome = new City("Rome", italy);
        this.isAdopted = df.chance((int) System.currentTimeMillis());
    }

    public Male male(Female mother, Male father) {
        return new Male(mother, father, isAdopted,
                df.getFirstName(), df.getLastName(),
                rome, df.getNumberUpTo(currentYear), df.getNumberUpTo(currentYear));
    }

    public Female female(Female mother, Male father) {
        return new Female(mother, father, isAdopted,
                df.getFirstName(), df.getLastName(),
                rome, df.getNumberUpTo(currentYear), df.getNumberUpTo(currentYear));
    }
}
