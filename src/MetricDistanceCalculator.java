import java.util.HashMap;

public class MetricDistanceCalculator {
    private static final HashMap<String, Integer> unitToMillimeters = new HashMap<>();

    static {
        unitToMillimeters.put("mm", 1);
        unitToMillimeters.put("cm", 10);
        unitToMillimeters.put("dm", 100);
        unitToMillimeters.put("m", 1000);
        unitToMillimeters.put("km", 1000000);
    }

    public static int calculate(String expression) {
        String[] tokens = expression.split("\\s+");
        int resultMm = 0;
        int operator = 1;  // 1 for addition, -1 for subtraction

        for (String token : tokens) {
            if (token.equals("+")) {
                operator = 1;
            } else if (token.equals("-")) {
                operator = -1;
            } else if (token.matches("\\d+")) {
                int value = Integer.parseInt(token);
                resultMm += operator * value;
            } else {
                String unit = token.toLowerCase();
                if (unitToMillimeters.containsKey(unit)) {
                    resultMm += operator * unitToMillimeters.get(unit);
                } else {
                    throw new IllegalArgumentException("Invalid unit: " + unit);
                }
            }
        }

        return resultMm;
    }
}
