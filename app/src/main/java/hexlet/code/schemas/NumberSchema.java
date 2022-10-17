package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super(Integer.class);
    }

    public final NumberSchema required() {
        Predicate<Integer> validation = input -> input != null;
        if (getValidation() == null) {
            setValidation(validation);
        }
        setRequired(true);
        return this;
    }


    public final NumberSchema positive() {
        Predicate<Integer> validation = input -> input > 0;
        setValidation(validation);
        return this;
    }

    public final NumberSchema range(int start, int end) {
        Predicate<Integer> validation = input -> input >= start && input <= end;
        setValidation(validation);
        return this;
    }
}
