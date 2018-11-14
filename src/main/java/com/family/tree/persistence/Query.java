package com.family.tree.persistence;

import com.family.tree.person.Person;
import com.family.tree.util.Either;
import com.lambdazen.bitsy.BitsyGraph;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.List;

public class Query {

    public static Either<String, List<Person>> people(BitsyGraph graph) {
        GraphTraversal<Vertex, String> traversal = graph.traversal().V().hasLabel(Person.ENTITY_NAME).values(Person.BIRTH_YEAR, Person.FIRST_NAME);
        traversal.toList();
        return Either.left("not impl yet");
    }
}
