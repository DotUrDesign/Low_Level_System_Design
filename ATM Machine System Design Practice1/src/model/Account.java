package model;

public class Account {
    String accNo;
    int accBalance;

    public Account(String accNo, int accBalance) {
        this.accNo = accNo;
        this.accBalance = accBalance;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public int getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(int accBalance) {
        this.accBalance = accBalance;
    }
}
