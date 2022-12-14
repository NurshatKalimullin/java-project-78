package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {

    private final Map<String, Predicate> checks = new LinkedHashMap<>();
    private boolean required = false;

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
        return checks.values().stream().allMatch(check -> check.test(input));
    }

}
