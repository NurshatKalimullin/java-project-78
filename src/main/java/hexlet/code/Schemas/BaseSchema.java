package hexlet.code.Schemas;

import java.util.function.Predicate;

public class BaseSchema {

    private Predicate validation;
    private static boolean required = false;
    private final Class<?> schemaType;

    public BaseSchema(Class<?> schemaType) {
        this.schemaType = schemaType;
    }

    public void setRequired(boolean required) {
        BaseSchema.required = required;
    }

    public final void setValidation(Predicate validation) {
        this.validation = validation;
    }

    public boolean isValid(Object input) {
        boolean result = true;
        if (required) {
            if (!schemaType.isInstance(input)) {
                return false;
            }
            result = validation.test(input);
            System.out.println("For " + input + " result: " + result);
        }
        return result;
    }

}
