package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super(Map.class);
    }

    public final MapSchema required() {
        Predicate<Map> validation = input -> input instanceof Map;
        addCheck("required", validation);
        setRequired(true);
        return this;
    }

    public final MapSchema sizeof(int size) {
        Predicate<Map> validation = input -> input.size() == size;
        addCheck("sizeof", validation);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck(
                "shape",
                value -> schemas.entrySet().stream().allMatch(e ->
                        e.getValue().isValid(((Map<?, ?>) value).get(e.getKey())))
        );
        return this;
    }
}
