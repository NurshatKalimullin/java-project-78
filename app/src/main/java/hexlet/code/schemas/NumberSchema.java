package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super(Integer.class);
    }

    public final NumberSchema required() {
        Predicate<Integer> validation = input -> input != null;
        addCheck("required", validation);
        setRequired(true);
        return this;
    }


    public final NumberSchema positive() {
        clearChecks();
        Predicate<Integer> validation = input -> input > 0;
        addCheck("required", validation);
        return this;
    }

    public final NumberSchema range(int start, int end) {
        clearChecks();
        Predicate<Integer> validation = input -> input >= start && input <= end;
        addCheck("required", validation);
        return this;
    }
}
