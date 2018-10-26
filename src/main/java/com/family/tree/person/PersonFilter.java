package com.family.tree.person;

import java.util.LinkedList;
import java.util.List;

public class PersonFilter {

    private final Person person;

    public PersonFilter(Person person) {
        this.person = person;
    }

    public List<Person> descendants() {
        List<Person> descendants = new LinkedList<>();
        allDescendants(person, descendants);
        return descendants;
    }

    public List<Person> ancestors() {
        List<Person> ancestors = new LinkedList<>();
        allAncestors(person, ancestors);
        return ancestors;
    }

    private static void allAncestors(Person person, List<Person> allAncestors) {
        person.mother().ifPresent(mother -> {
            allAncestors.add(mother);
            allAncestors(mother, allAncestors);
        });
        person.father().ifPresent(father -> {
            allAncestors.add(father);
            allAncestors(father, allAncestors);
        });
    }

    private static void allDescendants(Person person, List<Person> allDescendants) {
        allDescendants.addAll(person.children);
        person.children.forEach(child -> allDescendants(child, allDescendants));
    }
}
