package com.family.tree.persistence;

import com.family.tree.city.City;
import com.family.tree.country.Country;
import com.family.tree.person.Person;
import com.lambdazen.bitsy.BitsyGraph;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.Map;

public class UniqueCheckerProvider {

    private final Map<Person, Vertex> uniquePeople;
    private final Map<City, Vertex> uniqueCities;
    private final Map<Country, Vertex> uniqueCountries;
    private final BitsyGraph graph;

    public UniqueCheckerProvider(Map<Person, Vertex> uniquePeople,
                                 Map<City, Vertex> uniqueCities,
                                 Map<Country, Vertex> uniqueCountries, BitsyGraph graph) {
        this.uniquePeople = uniquePeople;
        this.uniqueCities = uniqueCities;
        this.uniqueCountries = uniqueCountries;
        this.graph = graph;
    }

    public UniqueChecker<Person> forPersistent(Person person) {
        return new UniqueChecker<>(uniquePeople, person, graph);
    }

    public UniqueChecker<City> forPersistent(City city) {
        return new UniqueChecker<>(uniqueCities, city, graph);
    }

    public UniqueChecker<Country> forPersistent(Country country) {
        return new UniqueChecker<>(uniqueCountries, country, graph);
    }
}
