package com.family.tree.persistence;

import com.family.tree.city.City;
import com.family.tree.country.Country;
import com.family.tree.person.Person;
import com.lambdazen.bitsy.BitsyGraph;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.Map;

public class UniqueCheckerProvider {

    public final UniqueChecker<Person> personUniqueChecker;
    public final UniqueChecker<City> cityUniqueChecker;
    public final UniqueChecker<Country> countryUniqueChecker;

    public UniqueCheckerProvider(Map<Person, Vertex> uniquePeople,
                                 Map<City, Vertex> uniqueCities,
                                 Map<Country, Vertex> uniqueCountries, BitsyGraph graph) {
        this.personUniqueChecker = new UniqueChecker<>(uniquePeople, graph);
        this.cityUniqueChecker = new UniqueChecker<>(uniqueCities, graph);
        this.countryUniqueChecker = new UniqueChecker<>(uniqueCountries, graph);
    }
}
