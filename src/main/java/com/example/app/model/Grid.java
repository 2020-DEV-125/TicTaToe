package com.example.app.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Grid implements Serializable {

    private static final long serialVersionUID = 418061626191626746L;

    public static final int rows = 3;

    public static final int cols = 3;

    private final Map<String, Cell> fields;

    public Grid() {
        fields = new HashMap<>(cols*rows);
    }

    public Grid(Map<String, Cell> fields) {
        this.fields = fields;
    }

    public Map<String, Cell> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "Grid{" + "fields=" + fields + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.fields);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grid other = (Grid) obj;
        if (!Objects.equals(this.fields, other.fields)) {
            return false;
        }
        return true;
    }


}
