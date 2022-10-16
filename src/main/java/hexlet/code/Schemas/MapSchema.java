package hexlet.code.Schemas;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super(Map.class);
    }

    public MapSchema required() {
        Predicate<Map> validation = input -> input instanceof Map;
        setValidation(validation);
        setRequired(true);
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Map> validation = input -> input.size() == size;
        setValidation(validation);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        Set<String> keysSchemas = schemas.keySet();
//        Predicate<Map> validation = input -> {
//            Set<String> testKeys = s;
//            boolean result = true;
//            String k = null;
//            for (String key : testKeys) {
//                k = key;
//                System.out.println("Now we test " + input.get(key));
//                result = schemas.get(key).isValid(input.get(key));
//                break;
//            }
//            testKeys.remove(k);
//            setRequired(false);
//            System.out.println("Now we change required to " + getRequired());
//            return result;
//        };
        Predicate<Map> validation = input -> {
            Set<String> keys = input.keySet();
            boolean result = false;
            for (String key : keys) {
                result = schemas.get(key).isValid(input.get(key));
                setRequired(false);
                if (!result) {
                    break;
                }
            }
            return result;
        };
        setValidation(validation);
        return this;
    }
}
