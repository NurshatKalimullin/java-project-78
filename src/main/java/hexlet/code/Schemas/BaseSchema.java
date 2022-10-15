package hexlet.code.Schemas;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    private final List<Predicate> validations = new ArrayList<>();
    private static boolean required = false;

    public BaseSchema(Class<?> stringClass) {

    }

    public void setRequired(boolean required) {
        BaseSchema.required = required;
    }

    public static boolean isRequired() {
        return required;
    }

    public final void setValidations(Predicate predicate) {
        validations.add(predicate);
    }

    public final void clearValidations() {
        validations.clear();
    }

    public boolean isValid(String input) {
        boolean result = true;
        if (required) {
            if (input == null) {
                return false;
            }
            result = validations.stream().allMatch(check -> check.test(input));
            System.out.println("For " + input + " result: " + result);
        }
        return result;
    }

}
