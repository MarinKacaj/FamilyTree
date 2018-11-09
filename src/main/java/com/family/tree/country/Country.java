package com.family.tree.country;

import com.family.tree.persistence.Persistent;
import com.family.tree.persistence.UniqueCheckerProvider;
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
}
