package com.family.tree.person;

import com.lambdazen.bitsy.BitsyGraph;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public interface Persistent {

    Vertex toGraph(BitsyGraph graph);
}
