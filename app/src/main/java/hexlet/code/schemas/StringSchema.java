package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        super(String.class);
    }

    public final StringSchema required() {
        addCheck("required", input -> input instanceof String && !((String) input).isEmpty());
        setRequired(true);
        return this;
    }

    public final StringSchema contains(String sbstr) {
        Predicate<?> validation = input -> input instanceof String && ((String) input).contains(sbstr);
        addCheck("contains", validation);
        return this;
    }

    public final StringSchema minLength(int minLength) {
        clearChecks();
        Predicate<String> validation = input ->  input instanceof String && ((String) input).length() >= minLength;
        addCheck("minLength", validation);
        return this;
    }
}
