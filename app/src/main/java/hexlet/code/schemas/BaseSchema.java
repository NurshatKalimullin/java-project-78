package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {

    private final Map<String, Predicate> checks = new LinkedHashMap<>();
    private boolean required = false;
    //there is no way we can remove schemaType because of null input values
    private final Class<?> schemaType;

    public BaseSchema(Class<?> type) {
        this.schemaType = type;
    }

    public final void setRequired(boolean value) {
        this.required = value;
    }

    protected final void addCheck(String name, Predicate validate) {
        checks.put(name, validate);
    }

    protected final void clearChecks() {
        checks.clear();
    }

    public final boolean isValid(Object input) {
        boolean result = !required;
        if (schemaType.isInstance(input)){
            result = checks.values().stream().allMatch(check -> check.test(input));
        }
        return result;
    }

}
