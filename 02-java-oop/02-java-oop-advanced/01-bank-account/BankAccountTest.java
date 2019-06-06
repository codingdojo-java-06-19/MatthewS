class BankAccountTest {
  public static void main(String[] args) {
    BankAccount ba = new BankAccount();
    System.out.println(ba.accountCount());
    System.out.println(ba.accountNumber());
    ba.depositChecking(34.99);
    System.out.println(ba.getCheckBalance());
    ba.withdrawCheck(5.01);
    System.out.println(ba.getCheckBalance());
    System.out.println(ba.checkTotalBalance());

  }
}