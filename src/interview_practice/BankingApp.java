package interview_practice;

public class BankingApp {
    public static void main(String[] args) {
        // Load the CustomInterestCalculator class dynamically
        try {
            String s = "interview_practice.CustomInterestCalculator";
            Class<?> calculatorClass = Class.forName(s);
            FinancialCalculator calculator = (FinancialCalculator) calculatorClass.newInstance();

            double principalAmount = 1000.0;
            double interest = calculator.calculate(principalAmount);
            System.out.println("Interest: " + interest);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
