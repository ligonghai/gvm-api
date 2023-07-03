package io.github.ligonghai.constant;

import io.github.ligonghai.serializer.Serializable;

/**
 * @author ligonghai
 */

public enum AliveTest implements Serializable {

    /**
     * Scan Config Default
     */
    SCAN_CONFIG_DEFAULT(1, "Scan Config Default"),
    /**
     * ICMP Ping
     */
    ICMP_PING(2, "ICMP Ping"),
    /**
     * TCP-ACK Service Ping
     */
    TCP_ACK_SERVICE_PING(3, "TCP-ACK Service Ping"),
    /**
     * TCP-SYN Service Ping
     */
    TCP_SYN_SERVICE_PING(4, "TCP-SYN Service Ping"),
    /**
     * ARP Ping
     */
    ARP_PING(5, "ARP Ping"),
    /**
     * ICMP & TCP-ACK Service Ping
     */
    ICMP_TCP_ACK_SERVICE_PING(6, "ICMP & TCP-ACK Service Ping"),
    /**
     * ICMP & ARP Ping
     */
    ICMP_ARP_PING(7, "ICMP & ARP Ping"),
    /**
     * TCP-ACK Service & ARP Ping
     */
    TCP_ACK_SERVICE_ARP_PING(8, "TCP-ACK Service & ARP Ping"),
    /**
     * ICMP, TCP-ACK Service & ARP Ping
     */
    ICMP_TCP_ACK_SERVICE_ARP_PING(9, "ICMP, TCP-ACK Service & ARP Ping"),
    /**
     * Consider Alive
     */
    CONSIDER_ALIVE(10, "Consider Alive");

    public final int code;

    public final String name;

    AliveTest(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String serialize() {
        return this.name;
    }
}
