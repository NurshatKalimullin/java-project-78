package hexlet.code.Schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super(Map.class);
    }

    public MapSchema required() {
        Predicate<Map> validation = input -> input instanceof Map;
        setValidation(validation);
        setRequired(true);
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Map> validation = input -> input.size() == size;
        setValidation(validation);
        return this;
    }
}
