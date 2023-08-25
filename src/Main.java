public class Main {
    public static void main(String[] args) {
        MetricDistanceCalculator calculator = new MetricDistanceCalculator();

        // Exemplu de utilizare a calculatorului
        String expression = "10 cm + 1 m - 10 mm";
        int result = calculator.calculate(expression);
        System.out.println("Result: " + result + " mm");

        // Exemplu de rulare a testelor unitare
        org.junit.runner.JUnitCore.main("MetricDistanceCalculatorTest");
    }
}
