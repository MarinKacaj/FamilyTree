package com.family.tree.persistence;

import com.lambdazen.bitsy.BitsyGraph;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.Map;
import java.util.function.Function;

public class UniqueChecker<T extends Persistent> {

    private final Map<T, Vertex> uniqueInstances;
    private final BitsyGraph graph;

    UniqueChecker(Map<T, Vertex> uniqueInstances, BitsyGraph graph) {
        this.uniqueInstances = uniqueInstances;
        this.graph = graph;
    }

    public Vertex getVertex(T instance, Function<BitsyGraph, Vertex> vertexCreator) {
        Vertex vertex;
        if (uniqueInstances.containsKey(instance)) {
            vertex = uniqueInstances.get(instance);
        } else {
            vertex = vertexCreator.apply(graph);
            uniqueInstances.put(instance, vertex);
        }
        return vertex;
    }
}
