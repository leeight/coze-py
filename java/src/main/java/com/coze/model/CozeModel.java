package com.coze.model;

/**
 * Base class for all Coze model classes.
 */
public abstract class CozeModel {
    @Override
    public String toString() {
        return String.format("%s{}", getClass().getSimpleName());
    }
}
