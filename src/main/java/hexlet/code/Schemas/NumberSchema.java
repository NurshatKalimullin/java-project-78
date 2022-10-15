package hexlet.code.Schemas;

public class NumberSchema extends BaseSchema {

    private static String status = "not required";
    private static int start;
    private static int end;

    public NumberSchema() {
        super(Integer.class);
    }

    public static boolean isValid(Object input) {
        if (isRequired()) {
            return input instanceof Integer;
        } else if (status.equals("positive")) {
            return (Integer) input > 0;
        } else if (status.equals("range")) {
            return (Integer) input >= start && (Integer) input <= end;
        }
        return false;
    }


    public NumberSchema required() {
        setRequired(true);
        return this;
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
