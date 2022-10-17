package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        super(String.class);
    }

    public final StringSchema required() {
        Predicate<String> validation = input ->  !input.isEmpty();
        if (getValidation() == null) {
            setValidation(validation);
        }
        setRequired(true);
        return this;
    }

    public final StringSchema contains(String sbstr) {
        Predicate<String> validation = input -> input.contains(sbstr);
        setValidation(validation);
        return this;
    }

    public final StringSchema minLength(int minLength) {
        Predicate<String> validation = input -> input.length() >= minLength;
        setValidation(validation);
        return this;
    }
}
