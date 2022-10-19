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
        Predicate<Integer> validation = input -> input > 0;
        addCheck("positive", validation);
        return this;
    }

    public final NumberSchema range(int start, int end) {
        Predicate<Integer> validation = input -> input >= start && input <= end;
        addCheck("range", validation);
        return this;
    }
}
