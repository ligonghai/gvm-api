package io.github.ligonghai.gvm.constant;


import io.github.ligonghai.gvm.serializer.Serializable;

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
