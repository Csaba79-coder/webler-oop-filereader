package value;

public enum Unit {

    // KILOGRAM, LITER, PIECE, GRAM, BAR, OTHER;
    KILOGRAM("kg"), LITER("l"), PIECE("db"), GRAM("g"),
    BAR("rúd"), OTHER("");

    private final String value;

    Unit(String value) {
        this.value = value;
    }

    public static Unit getEnumValueFromString(String value) { // public static String fromAbbreviation(String abbreviation)
        for (Unit unit : values()) {
            if (unit.value.equalsIgnoreCase(value.toLowerCase())) {
                // return unit.toString().toLowerCase();
                return unit;
            }
        }
        // return OTHER.toString().toLowerCase(); // Default to OTHER if the abbreviation is not recognized
        return OTHER; // Default to OTHER if the abbreviation is not recognized
    }
}
