package io.github.ligonghai.constant;


import io.github.ligonghai.serializer.Serializable;

/**
 * @author ligonghai
 */

public enum TargetSource  implements Serializable {
    /**
     * manual
     */
    MANUAL(1, "manual");

    public final int code;

    public final String name;

    TargetSource(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String serialize() {
        return this.name;
    }
}
