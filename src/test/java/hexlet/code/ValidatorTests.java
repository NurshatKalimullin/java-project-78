package hexlet.code;

import org.junit.jupiter.api.Test;

public class ValidatorTests {

    @Test
    public void test() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid(null));

        schema.required();

        System.out.println(schema.isValid("what does the fox say"));; // true
        System.out.println(schema.isValid("hexlet")); // true
        System.out.println(schema.isValid(null));// false
        System.out.println(schema.isValid("")); // false

        System.out.println(schema.contains("wh").isValid("what does the fox say"));
        System.out.println(schema.contains("what").isValid("what does the fox say"));
        System.out.println(schema.contains("whatthe").isValid("what does the fox say"));

        System.out.println(schema.isValid("what does the fox say")); // false

        System.out.println(schema.minLength(4).isValid("test")); //true
        System.out.println(schema.minLength(5).isValid("test")); //false

    }
}
