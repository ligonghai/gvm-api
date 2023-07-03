package io.github.ligonghai.constant;


import io.github.ligonghai.serializer.Serializable;

/**
 * @author ligonghai
 */

public enum InUse implements Serializable {
    /**
     * no
     */
    NO(0, "no"),
    /**
     * yes
     */
    YES(1, "yes");

    public final int code;

    public final String name;

    InUse(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String serialize() {
        return this.name;
    }
}
