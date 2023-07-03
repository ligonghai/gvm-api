package io.github.ligonghai.constant;


import io.github.ligonghai.serializer.Serializable;

/**
 * @author ligonghai
 */

public enum PortType implements Serializable {
    /**
     * tcp
     */
    TCP(1, "tcp"),
    /**
     * udp
     */
    UDP(1, "udp");

    public final int code;

    public final String name;

    PortType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String serialize() {
        return this.name;
    }
}
