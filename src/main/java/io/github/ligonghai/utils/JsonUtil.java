package io.github.ligonghai.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author ligonghai
 */
public class JsonUtil {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) throws JsonProcessingException {
        return JSON_MAPPER.readValue(content, valueTypeRef);
    }

    public static <T> T readValue(byte[] src, TypeReference<T> valueTypeRef) throws IOException {
        return JSON_MAPPER.readValue(src, valueTypeRef);
    }

    public static <T> T readValue(String content, Class<T> valueType) throws JsonProcessingException {
        return JSON_MAPPER.readValue(content, valueType);
    }

    public static String writeValueAsString(Object value) throws JsonProcessingException {
        return JSON_MAPPER.writeValueAsString(value);
    }

    public static byte[] writeValueAsBytes(Object value) throws JsonProcessingException {
        return JSON_MAPPER.writeValueAsBytes(value);
    }
}
