package com.family.tree.country;

import com.family.tree.person.Persistent;
import com.lambdazen.bitsy.BitsyGraph;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class Country implements Persistent {

    public static final String NAME = "name";

    public final String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public Vertex toGraph(BitsyGraph graph) {
        return graph.addVertex(NAME, name);
    }
}
