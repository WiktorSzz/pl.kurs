package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.kurs.models.Circle;
import pl.kurs.models.Rectangle;
import pl.kurs.models.Shape;
import pl.kurs.models.Square;

import java.io.IOException;

public class ShapeSerializer extends StdSerializer<Shape> {


    public ShapeSerializer(Class<Shape> t) {
        super(t);
    }

    @Override
    public void serialize(Shape shape, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        String type = shape.getClass().getSimpleName().toLowerCase();
        gen.writeStringField("type", type);

        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            gen.writeNumberField("radius", circle.getRadius());
        } else if (shape instanceof Square) {
            Square square = (Square) shape;
            gen.writeNumberField("side", square.getSide());
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            gen.writeNumberField("width", rectangle.getWidth());
            gen.writeNumberField("height", rectangle.getHeight());
        }

        gen.writeEndObject();
    }
}
