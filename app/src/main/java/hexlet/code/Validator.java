package hexlet.code;

import hexlet.code.Schemas.MapSchema;
import hexlet.code.Schemas.NumberSchema;
import hexlet.code.Schemas.StringSchema;

public class Validator {

    public Validator() {
    }

    public final StringSchema string() {
        return new StringSchema();
    }

    public final NumberSchema number() {
        return new NumberSchema();
    }

    public final MapSchema map() {
        return new MapSchema();
    }
}
