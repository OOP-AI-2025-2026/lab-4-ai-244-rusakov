package ua.opnu.java.inheritance.account;

public class BankingAccount {
    private int balance;
    public BankingAccount(Startup s) {
        this.balance = s.getInitialBalance();
    }
    public int getBalance() { return balance; }
    public void debit(Debit d) { this.balance += d.getAmount(); }
    public void credit(Credit c) { this.balance += c.getAmount(); }
}
