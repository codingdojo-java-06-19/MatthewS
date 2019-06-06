import java.util.Random;

class BankAccount {
  private String accountNumber;
  private Double checkingBalance = 0.00;
  private Double savingsBalance = 0.00;
  private static int numOfAccounts = 0;
  private static int totalMoney = 0;

  public BankAccount() {
    accountNumber = acctNumber();
    numOfAccounts++;
  }

  public static int accountCount() {
    return numOfAccounts;
  }

  public String accountNumber() {
    return accountNumber;
  }

  public Double getCheckBalance() {
    return checkingBalance;
  }

  public Double getSavingBalance() {
    return savingsBalance;
  }

  public void depositChecking(Double deposit) {
    this.checkingBalance += deposit;
    System.out.println("You have successfully deposited " + deposit + " into your checking account.");
  }

  public void withdrawCheck(Double withdraw) {
    if (this.checkingBalance < withdraw) {
      System.out.println("There are insufficient funds! Earn more money!!");
    } else {
      this.checkingBalance -= withdraw;
      System.out.println(withdraw + " has successfully been withdrawn.");
    }
  }

  public double checkTotalBalance() {
    return checkingBalance + savingsBalance;
  }

  private String acctNumber() {
    Random random = new Random();
    String acctNum = "";
    for (int i = 0; i < 10; i++) {
      acctNum += random.nextInt(10);
    }
    return acctNum;
  }
}