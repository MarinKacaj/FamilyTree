package com.family.tree.city;

import com.family.tree.country.Country;

public class City {

    public final String name;
    public final Country country;

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
