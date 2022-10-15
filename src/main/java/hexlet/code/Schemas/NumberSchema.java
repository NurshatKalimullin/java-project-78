package hexlet.code.Schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super(Integer.class);
    }

    public NumberSchema required() {
        Predicate<Integer> validation = input -> input != null;
        setValidation(validation);
        setRequired(true);
        return this;
    }


    public NumberSchema positive() {
        Predicate<Integer> validation = input -> input > 0;
        setValidation(validation);
        return this;
    }

    public NumberSchema range(int start, int end) {
        Predicate<Integer> validation = input -> input >= start && input <= end;
        setValidation(validation);
        return this;
    }
}
