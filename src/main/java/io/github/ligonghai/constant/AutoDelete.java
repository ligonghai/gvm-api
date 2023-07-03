package io.github.ligonghai.constant;


import io.github.ligonghai.serializer.Serializable;

/**
 * @author ligonghai
 */

public enum AutoDelete implements Serializable {
    /**
     * no
     */
    NO(1, "no"),
    /**
     * keep
     */
    KEEP(2, "keep");


    public final int code;

    public final String name;

    AutoDelete(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String serialize() {
        return this.name;
    }
}
