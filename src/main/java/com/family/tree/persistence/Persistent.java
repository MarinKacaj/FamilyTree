package com.family.tree.persistence;

import org.apache.tinkerpop.gremlin.structure.Vertex;

public interface Persistent {

    Vertex toGraph(UniqueCheckerProvider uniqueCheckerProvider);
}
