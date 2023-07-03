package io.github.ligonghai.constant;


import io.github.ligonghai.serializer.Serializable;

/**
 * @author ligonghai
 */

public enum HostOrdering implements Serializable {

    /**
     * sequential
     */
    SEQUENTIAL(1, "sequential"),
    /**
     * random
     */
    RANDOM(1, "random"),
    /**
     * reverse
     */
    REVERSE(1, "reverse");

    public final int code;

    public final String name;

    HostOrdering(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String serialize() {
        return this.name;
    }
}
