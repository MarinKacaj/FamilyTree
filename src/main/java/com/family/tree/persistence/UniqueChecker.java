package com.family.tree.persistence;

import com.lambdazen.bitsy.BitsyGraph;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.Map;
import java.util.function.Function;

public class UniqueChecker<T extends Persistent> {

    private final Map<T, Vertex> uniqueInstances;
    private final T instance;
    private final BitsyGraph graph;

    UniqueChecker(Map<T, Vertex> uniqueInstances, T instance, BitsyGraph graph) {
        this.uniqueInstances = uniqueInstances;
        this.instance = instance;
        this.graph = graph;
    }

    public Vertex getVertex(Function<BitsyGraph, Vertex> vertexCreator) {
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
