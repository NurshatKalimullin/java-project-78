package hexlet.code.Schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    private static String status = "not required";
    private static int size;

    public MapSchema() {
        super(Map.class);
    }

    public static boolean isValid(Object input) {
        if (isRequired()) {
            return input instanceof Map;
        } else if (status.equals("sizeof")) {
            return ((Map<?, ?>) input).size() == size;
        }
        return false;
    }

    public MapSchema required() {
        setRequired(true);
        return this;
    }

    public MapSchema sizeof(int size) {
        status = "sizeof";
        MapSchema.size = size;
        return this;
    }
}
