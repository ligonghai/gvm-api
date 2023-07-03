package io.github.ligonghai.constant;


import io.github.ligonghai.serializer.Serializable;

/**
 * @author ligonghai
 */

public enum TaskStatus implements Serializable {
    /**
     * Requested
     */
    Requested(1, "Requested"),
    /**
     * Requested
     */
    Queued(2, "Queued"),
    /**
     * Requested
     */
    Running(3, "Running"),
    /**
     * Requested
     */
    Done(4, "Done");

    public final int code;

    public final String name;

    TaskStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String serialize() {
        return this.name;
    }
}
