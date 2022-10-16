package hexlet.code.Schemas;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super(Map.class);
    }

    public final MapSchema required() {
        Predicate<Map> validation = input -> input instanceof Map;
        setValidation(validation);
        setRequired(true);
        return this;
    }

    public final MapSchema sizeof(int size) {
        Predicate<Map> validation = input -> input.size() == size;
        setValidation(validation);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        Predicate<Map> validation = input -> {
            Set<String> keys = input.keySet();
            boolean result = false;
            for (String key : keys) {
                result = schemas.get(key).isValid(input.get(key));
                setRequired(false);
                if (!result) {
                    break;
                }
            }
            return result;
        };
        setValidation(validation);
        return this;
    }
}
