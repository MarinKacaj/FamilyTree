package com.family.tree.city;

import com.family.tree.country.Country;
import com.family.tree.person.Persistent;
import com.lambdazen.bitsy.BitsyGraph;
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
    public Vertex toGraph(BitsyGraph graph) {
        Vertex own = graph.addVertex(NAME, name);
        own.addEdge(COUNTRY, country.toGraph(graph));
        return own;
    }
}
