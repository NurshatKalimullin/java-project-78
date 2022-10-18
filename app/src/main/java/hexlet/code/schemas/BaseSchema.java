package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {

    protected Map<String, Predicate> checks = new LinkedHashMap<>();
    protected boolean required = false;
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
        if (input == null && !required
                || !required && !schemaType.isInstance(input)) {
            result = true;
        } else if (schemaType.isInstance(input)) {
            System.out.println(checks);
            result = checks.values().stream().allMatch(check -> check.test(input));
            System.out.println("For " + input + " result is " + result);
        }
        return result;
    }

}
