package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super(Integer.class);
    }

    public final NumberSchema required() {
        addCheck("required", input -> input instanceof Integer);
        setRequired(true);
        return this;
    }


    public final NumberSchema positive() {
        Predicate<?> validation = input -> input instanceof Integer
                && (Integer) input > 0;
        addCheck("positive", validation);
        return this;
    }


    public final NumberSchema range(int start, int end) {
        Predicate<?> validation = input -> input instanceof Integer
                && (Integer) input >= start
                && (Integer) input <= end;
        addCheck("range", validation);
        return this;
    }
}
