package com.family.tree.city;

import com.family.tree.country.Country;
import com.family.tree.persistence.Persistent;
import com.family.tree.persistence.UniqueCheckerProvider;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class City implements Persistent {

    public static final String NAME = "name";
    public static final String COUNTRY = "country";

    public final String name;
    public final Country country;

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    @Override
    public Vertex toGraph(UniqueCheckerProvider uniqueCheckerProvider) {
        return uniqueCheckerProvider.forPersistent(this).getVertex(graph -> {
            Vertex own = graph.addVertex(NAME, name);
            own.addEdge(COUNTRY, country.toGraph(uniqueCheckerProvider));
            return own;
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof City)) return false;

        City city = (City) o;

        return new EqualsBuilder()
                .append(name, city.name)
                .append(country, city.country)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(country)
                .toHashCode();
    }
}
