package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {

    private final Map<String, Predicate> checks = new LinkedHashMap<>();
    private boolean required = false;

    public BaseSchema(Class<?> type) {
    }

    public final void setRequired(boolean value) {
        this.required = value;
    }

    public final boolean isRequired() {
        return required;
    }

    protected final void addCheck(String name, Predicate validate) {
        checks.put(name, validate);
    }

    public final boolean isValid(Object input) {
        System.out.println(checks);
        boolean result = checks.values().stream().allMatch(check -> check.test(input));
        System.out.println("For " + input + " resul is " + result);
        return result;
    }

}
