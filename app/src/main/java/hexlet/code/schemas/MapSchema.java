package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super(Map.class);
    }

    public final MapSchema required() {
        addCheck("required", input -> input instanceof Map);
        setRequired(true);
        return this;
    }

    public final MapSchema sizeof(int size) {
        Predicate<?> validation = input -> input instanceof Map
                && ((Map<?, ?>) input).size() == size;
        addCheck("sizeof", validation);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck(
                "shape",
                input -> input instanceof Map &&
                        schemas.entrySet().stream().allMatch(e ->
                        e.getValue().isValid(((Map<?, ?>) input).get(e.getKey())))
        );
        return this;
    }
}
