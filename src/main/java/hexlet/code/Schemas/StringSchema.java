package hexlet.code.Schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        super(String.class);
    }

    public StringSchema required() {
        Predicate<String> validation = input ->  !input.isEmpty();
        setValidation(validation);
        setRequired(true);
        return this;
    }

    public StringSchema contains(String sbstr) {
        Predicate<String> validation = input -> input.contains(sbstr);
        setValidation(validation);
        return this;
    }

    public StringSchema minLength(int minLength) {
        Predicate<String> validation = input -> input.length() >= minLength;
        setValidation(validation);
        return this;
    }
}
