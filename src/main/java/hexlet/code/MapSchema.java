package hexlet.code;

import java.util.Map;

public class MapSchema {

    private static String status = "not required";
    private static int size;

    public MapSchema() {
    }

    public static boolean isValid(Object input) {
        if (status.equals("not required")) {
            return true;
        } else if (status.equals("required")) {
            return input instanceof Map;
        } else if (status.equals("sizeof")) {
            return ((Map<?, ?>) input).size() == size;
        }
        return false;
    }

    public void required() {
        status = "required";
    }

    public MapSchema sizeof(int size) {
        status = "sizeof";
        MapSchema.size = size;
        return this;
    }
}
