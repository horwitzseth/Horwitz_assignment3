public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest () {
        double monthlyInterest;
        monthlyInterest = getSavingsBalance() * annualInterestRate / 12;
        setSavingsBalance(getSavingsBalance() + monthlyInterest);
    }

    public static void modifyInterestRate (double annualInterestRate) {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }
}


