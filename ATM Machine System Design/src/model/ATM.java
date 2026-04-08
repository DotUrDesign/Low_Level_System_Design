package model;

public class ATM {
    private String atmId;
    private int thousands;
    private int fivehundreds;
    private int onehundreds;
    private double cashAvailable;

    public ATM(String atmId, int thousands, int fivehundreds, int onehundreds) {
        this.atmId = atmId;
        this.thousands = thousands;
        this.fivehundreds = fivehundreds;
        this.onehundreds = onehundreds;
        this.cashAvailable = 2000 * thousands + 500 * fivehundreds + 100 * onehundreds;
    }

    public double getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(double cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public int getThousands() {
        return thousands;
    }

    public void setThousands(int thousands) {
        this.thousands = thousands;
    }

    public int getFivehundreds() {
        return fivehundreds;
    }

    public void setFivehundreds(int fivehundreds) {
        this.fivehundreds = fivehundreds;
    }

    public int getOnehundreds() {
        return onehundreds;
    }

    public void setOnehundreds(int onehundreds) {
        this.onehundreds = onehundreds;
    }
}
