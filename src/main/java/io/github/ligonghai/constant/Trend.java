package io.github.ligonghai.constant;


import io.github.ligonghai.serializer.Serializable;

/**
 * @author ligonghai
 */

public enum Trend implements Serializable {
    /**
     * 相同
     */
    SAME(1, "same");

    public final int code;

    public final String name;

    Trend(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String serialize() {
        return this.name;
    }
}
