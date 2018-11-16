package com.family.tree.persistence;

import com.family.tree.person.Person;
import com.family.tree.person.UnrelatedPerson;
import com.family.tree.util.Either;
import com.lambdazen.bitsy.BitsyGraph;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.family.tree.person.Person.*;

public class Query {

    public static Either<String, List<UnrelatedPerson>> unrelatedPeople(BitsyGraph graph) {
        GraphTraversal<Vertex, Map<String, String>> traversal = graph.traversal().V()
                .hasLabel(Person.ENTITY_NAME)
                .valueMap(BIRTH_YEAR, FIRST_NAME, LAST_NAME, GENDER, IS_ADOPTED, DEATH_YEAR);
        List<UnrelatedPerson> unrelatedPeople = new LinkedList<>();
        while (traversal.hasNext()) {
            Map<String, String> pairs = traversal.next();
            Either<String, UnrelatedPerson> maybeAnUnrelatedPerson = UnrelatedPerson.fromMap(pairs);
            if (maybeAnUnrelatedPerson.isLeft()) {
                return Either.left(maybeAnUnrelatedPerson.left());
            } else {
                unrelatedPeople.add(maybeAnUnrelatedPerson.right());
            }
        }
        return Either.right(unrelatedPeople);
    }
}
