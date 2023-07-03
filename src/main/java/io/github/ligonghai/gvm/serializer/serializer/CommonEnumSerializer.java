package io.github.ligonghai.gvm.serializer.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.ligonghai.gvm.serializer.Serializable;

import java.io.IOException;

public class CommonEnumSerializer extends JsonSerializer<Serializable> {

    @Override
    public void serialize(Serializable serializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(serializable.serialize());
    }
}