package pl.kurs.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.kurs.models.Shape;
import pl.kurs.models.ShapeFactory;

import java.io.IOException;

public class ShapeDeserializer extends StdDeserializer<Shape> {

    public ShapeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Shape deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode rootNode = jsonParser.getCodec().readTree(jsonParser);
        String type = rootNode.get("type").asText();

        ShapeFactory shapeFactory = ShapeFactory.getInstance();

        switch (type.toLowerCase()) {
            case "circle":
                double radius = rootNode.get("radius").asDouble();
                return shapeFactory.createCircle(radius);
            case "square":
                double side = rootNode.get("side").asDouble();
                return shapeFactory.createSquare(side);
            case "rectangle":
                double width = rootNode.get("width").asDouble();
                double height = rootNode.get("height").asDouble();
                return shapeFactory.createRectangle(width, height);
            default:
                throw new JsonProcessingException("Unknown shape type: " + type) {
                };
        }
    }
}
