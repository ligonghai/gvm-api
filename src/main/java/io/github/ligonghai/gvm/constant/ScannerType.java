package io.github.ligonghai.gvm.constant;


import io.github.ligonghai.gvm.serializer.Serializable;

/**
 * @author ligonghai
 */

public enum ScannerType implements Serializable {
    /**
     * osp
     */
    OSP(1, "osp scanner"),
    /**
     * openvas default
     */
    DEFAULT(2, "default"),
    /**
     * cve
     */
    CVE(3, "cve");

    public final int code;

    public final String name;

    ScannerType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String serialize() {
        return String.valueOf(this.code);
    }
}
