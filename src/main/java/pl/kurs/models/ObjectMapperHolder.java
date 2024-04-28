package pl.kurs.models;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import pl.kurs.deserializers.ShapeDeserializer;
import pl.kurs.serializers.ShapeSerializer;


public enum ObjectMapperHolder {
    INSTANCE;
    private final ObjectMapper objectMapper;

    ObjectMapperHolder() {
        objectMapper = create();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    private static ObjectMapper create() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        ShapeSerializer shapeSerializer = new ShapeSerializer(Shape.class);
        SimpleModule simpleModule = new SimpleModule("shapeSerializer");
        simpleModule.addSerializer(Shape.class, shapeSerializer);

        ShapeDeserializer shapeDeserializer = new ShapeDeserializer(Shape.class);
        SimpleModule simpleModule2 = new SimpleModule("shapeDeserializer");
        simpleModule2.addDeserializer(Shape.class, shapeDeserializer);

        mapper.registerModules(simpleModule, simpleModule2);

        return mapper;
    }
}
