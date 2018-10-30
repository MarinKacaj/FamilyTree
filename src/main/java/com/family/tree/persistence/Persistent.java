package com.family.tree.persistence;

import java.util.List;

public interface Persistent<Entity> {

    Either<Entity, String> parse(List<CellTuple> fields);

    List<CellTuple> fields();
}
