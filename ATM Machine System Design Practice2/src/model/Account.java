package model;

public class Account {
    String accNo;
    long accBalance;
    public Account(String accNo, long accBalance) {
        this.accNo = accNo;
        this.accBalance = accBalance;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public long getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(long accBalance) {
        this.accBalance = accBalance;
    }
}
