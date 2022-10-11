package hexlet.code;

public class StringSchema extends BaseSchema {

    static String status = "not required";
    static String sbstr;
    static int minLength;

    public StringSchema() {
    }


    public static boolean isValid(Object input) {
        if (status.equals("not required")) {
            return true;
        } else if (status.equals("required")) {
            return input instanceof String && !((String) input).isEmpty();
        } else if (status.equals("contains")) {
            return ((String) input).contains(sbstr);
        } else if (status.equals("minLength")) {
            return ((String) input).length() >= minLength;
        }
        return false;
    }

    public void required() {
        status = "required";
    }

    public StringSchema contains(String sbstr) {
        status = "contains";
        StringSchema.sbstr = sbstr;
        return this;
    }

    public StringSchema minLength(int minLength) {
        status = "minLength";
        StringSchema.minLength = minLength;
        return this;
    }
}
