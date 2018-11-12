package com.family.tree.country;

import com.family.tree.persistence.Persistent;
import com.family.tree.persistence.UniqueCheckerProvider;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class Country implements Persistent {

    public static final String NAME = "name";

    public final String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public Vertex toGraph(UniqueCheckerProvider uniqueCheckerProvider) {
        return uniqueCheckerProvider.forPersistent(this)
                .getVertex(graph -> graph.addVertex(NAME, name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        return new EqualsBuilder()
                .append(name, country.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .toHashCode();
    }
}
