package hexlet.code.Schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        super(String.class);
    }

    public StringSchema required() {
        Predicate<String> validation = input -> !input.isEmpty();
        setValidations(validation);
        setRequired(true);
        return this;
    }

    public StringSchema contains(String sbstr) {
        clearValidations();
        Predicate<String> validation = input -> input.contains(sbstr);
        setValidations(validation);
        return this;
    }

    public StringSchema minLength(int minLength) {
        clearValidations();
        Predicate<String> validation = input -> input.length() >= minLength;
        setValidations(validation);
        return this;
    }
}
