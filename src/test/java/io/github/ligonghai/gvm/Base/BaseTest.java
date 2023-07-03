package io.github.ligonghai.gvm.Base;

import io.github.ligonghai.gvm.GvmApiClient;
import io.github.ligonghai.gvm.config.GvmConfig;
import org.junit.Before;

import java.io.IOException;

public class BaseTest {

    protected GvmApiClient client;

    @Before
    public void init() throws IOException {
        GvmConfig config = new GvmConfig();
        config.setApi("http://192.168.133.128:3180/gmp");
        config.setUsername("admin");
        config.setPassword("123456");
        client = new GvmApiClient(config);
    }
}
