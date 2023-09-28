package interview_practice;

public class CustomInterestCalculator implements FinancialCalculator {
    public double calculate(double amount) {
        // Custom interest calculation logic
        return amount * 0.1; // 10% interest
    }
}
