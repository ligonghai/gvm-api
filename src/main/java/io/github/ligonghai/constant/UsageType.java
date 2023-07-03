package io.github.ligonghai.constant;


import io.github.ligonghai.serializer.Serializable;

/**
 * @author ligonghai
 */

public enum UsageType implements Serializable {
    /**
     * scan
     */
    SCAN(1, "scan");

    public final int code;

    public final String name;

    UsageType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String serialize() {
        return this.name;
    }
}
