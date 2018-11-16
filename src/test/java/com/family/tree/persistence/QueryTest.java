package com.family.tree.persistence;

import com.family.tree.person.Female;
import com.family.tree.person.Male;
import com.family.tree.person.UnrelatedPerson;
import com.family.tree.person.fixture.PersonFixture;
import com.family.tree.util.Either;
import com.lambdazen.bitsy.BitsyGraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class QueryTest {

    private PersonFixture personFixture;

    @Before
    public void setUp() {
        personFixture = new PersonFixture();
    }

    @Test
    public void unrelatedPeople() {
        BitsyGraph graph = new BitsyGraph();
        Female mother = personFixture.female(null, null);
        Male male = personFixture.male(mother, null);
        male.toGraph(new UniqueCheckerProvider(new HashMap<>(), new HashMap<>(), new HashMap<>(), graph));
        Either<String, List<UnrelatedPerson>> stringListEither = Query.unrelatedPeople(graph);
        Assert.assertEquals(2, stringListEither.right().size());
    }
}