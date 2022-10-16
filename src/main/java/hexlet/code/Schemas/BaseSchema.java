package hexlet.code.Schemas;

import java.util.function.Predicate;

public class BaseSchema {

    private Predicate validation;
    private boolean required = false;
    private final Class<?> schemaType;

    public BaseSchema(Class<?> type) {
        this.schemaType = type;
    }

    public final void setRequired(boolean value) {
        this.required = value;
    }

    public final void setValidation(Predicate predicate) {
        this.validation = predicate;
    }

    public final boolean isValid(Object input) {
        boolean result = !required;
        System.out.println("Required is " + required);
        if (input == null && !required
                || !required && !schemaType.isInstance(input)) {
            result = true;
        } else if (schemaType.isInstance(input)) {
            if (validation == null) {
                result = true;
            } else {
                result = validation.test(input);
            }
        }
        return result;
    }

}
