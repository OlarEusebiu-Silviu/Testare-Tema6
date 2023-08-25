import org.junit.Test;
import static org.junit.Assert.*;

public class MetricDistanceCalculatorTest {

    @Test
    public void testIndividualCalculations() {
        assertEquals(1090, MetricDistanceCalculator.calculate("10 cm + 1 m - 10 mm"));
        assertEquals(250, MetricDistanceCalculator.calculate("5 dm + 2 m"));
        assertEquals(280000, MetricDistanceCalculator.calculate("3 km - 200 m + 15 cm"));
        assertEquals(0, MetricDistanceCalculator.calculate("7 m - 70 dm + 700 cm - 7000 mm"));
    }

    @Test
    public void testParametrizedCalculations() {
        String[][] testCases = {
                {"1 m + 1 km + 1 cm", "1001010"},
                {"10 mm + 10 mm + 10 mm", "30"},
                {"2 km - 500 m - 50 cm - 5 mm", "1500495"}
        };

        for (String[] testCase : testCases) {
            int result = MetricDistanceCalculator.calculate(testCase[0]);
            assertEquals(Integer.parseInt(testCase[1]), result);
        }
    }
}