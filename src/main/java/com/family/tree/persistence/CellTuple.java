package com.family.tree.persistence;

public class CellTuple {

    public final PersistentType type;
    public final boolean nullable;
    public final String name;
    public final byte[] value;

    public CellTuple(PersistentType type, boolean nullable, String name, byte[] value) {
        this.type = type;
        this.nullable = nullable;
        this.name = name;
        this.value = value;
    }
}
