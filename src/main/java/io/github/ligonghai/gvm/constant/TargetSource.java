package io.github.ligonghai.gvm.constant;


import io.github.ligonghai.gvm.serializer.Serializable;

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
