package io.github.ligonghai.serializer.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Objects;

public class NumericBooleanSerializer extends JsonSerializer<Boolean> {

    @Override
    public void serialize(Boolean b, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(Objects.nonNull(b) && b ? 1 : 0);
    }

}