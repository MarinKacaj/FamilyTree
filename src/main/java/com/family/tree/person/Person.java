package com.family.tree.person;

import com.family.tree.city.City;
import com.family.tree.persistence.Persistent;
import com.family.tree.persistence.UniqueCheckerProvider;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class Person implements Persistent {

    public static final String ENTITY_NAME = "Person";
    public static final String MALE = "M";
    public static final String FEMALE = "F";

    public static final String MOTHER = "mother";
    public static final String FATHER = "father";
    public static final String GENDER = "gender";
    public static final String IS_ADOPTED = "isAdopted";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String BORN_IN = "lastName";
    public static final String BIRTH_YEAR = "lastName";
    public static final String DEATH_YEAR = "deathName";

    protected final Female mother;
    protected final Male father;
    public final List<Person> children;
    public final boolean isAdopted;
    public final String firstName;
    public final String lastName;
    protected final City bornIn;
    public final Integer birthYear;
    protected final Integer deathYear;

    protected Person(Female mother, Male father, boolean isAdopted, String firstName, String lastName,
                     City bornIn, Integer birthYear, Integer deathYear) {
        this.mother = mother;
        this.father = father;
        this.isAdopted = isAdopted;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornIn = bornIn;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.children = new LinkedList<>();
        addToParents();
    }

    private void addToParents() {
        this.mother().ifPresent(mother -> mother.children.add(this));
        this.father().ifPresent(father -> father.children.add(this));
    }

    public abstract boolean isMale();

    public abstract boolean isFemale();

    public Optional<Female> mother() {
        return Optional.ofNullable(mother);
    }

    public Optional<Male> father() {
        return Optional.ofNullable(father);
    }

    public Optional<City> city() {
        return Optional.ofNullable(bornIn);
    }

    public Optional<Integer> deathYear() {
        return Optional.ofNullable(deathYear);
    }

    @Override
    public Vertex toGraph(UniqueCheckerProvider uniqueCheckerProvider) {
        return uniqueCheckerProvider.personUniqueChecker.getVertex(this, graph -> {
            Vertex own = graph.addVertex(
                    T.label, ENTITY_NAME,
                    IS_ADOPTED, isAdopted,
                    FIRST_NAME, firstName,
                    LAST_NAME, lastName,
                    GENDER, isMale() ? MALE : FEMALE,
                    BORN_IN, bornIn,
                    BIRTH_YEAR, birthYear,
                    DEATH_YEAR, deathYear);
            mother().ifPresent(mother -> {
                Vertex motherVertex = mother.toGraph(uniqueCheckerProvider);
                own.addEdge(MOTHER, motherVertex);
            });
            father().ifPresent(father -> {
                Vertex fatherVertex = father.toGraph(uniqueCheckerProvider);
                own.addEdge(FATHER, fatherVertex);
            });
            city().ifPresent(city -> {
                Vertex cityVertex = city.toGraph(uniqueCheckerProvider);
                own.addEdge(BORN_IN, cityVertex);
            });
            return own;
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return new EqualsBuilder()
                .append(isAdopted, person.isAdopted)
                .append(mother, person.mother)
                .append(father, person.father)
                .append(firstName, person.firstName)
                .append(lastName, person.lastName)
                .append(bornIn, person.bornIn)
                .append(birthYear, person.birthYear)
                .append(deathYear, person.deathYear)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(mother)
                .append(father)
                .append(isAdopted)
                .append(firstName)
                .append(lastName)
                .append(bornIn)
                .append(birthYear)
                .append(deathYear)
                .toHashCode();
    }
}
