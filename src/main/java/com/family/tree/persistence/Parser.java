package com.family.tree.persistence;

import com.family.tree.person.Person;
import com.family.tree.util.Either;
import com.lambdazen.bitsy.BitsyGraph;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.Iterator;

public class Parser {

    public static Either<String, Person> parse(BitsyGraph graph) {
        Iterator<Vertex> vertexIterator = graph.vertices();
        while (vertexIterator.hasNext()) {
            Vertex vertex = vertexIterator.next();
        }
        return null;
    }
}
