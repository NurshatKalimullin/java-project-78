package hexlet.code;

public class NumberSchema extends BaseSchema {

    static String status = "not required";
    static int start;
    static int end;

    public NumberSchema() {
    }

    public static boolean isValid(Object input) {
        if (status.equals("not required")) {
            return true;
        } else if (status.equals("required")) {
            return input instanceof Integer;
        } else if (status.equals("positive")) {
            return (Integer) input > 0;
        } else if (status.equals("range")) {
            return (Integer) input >= start && (Integer) input <= end;
        }
        return false;
    }


    public void required() {
        status = "required";
    }


    public NumberSchema positive() {
        status = "positive";
        return this;
    }

    public NumberSchema range(int start, int end) {
        NumberSchema.end = end;
        NumberSchema.start = start;
        status = "range";
        return this;
    }
}
