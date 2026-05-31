package model;

public class Atm {
    long atmId;
    long twoThousands;
    long fiveHundreds;
    long oneHundreds;
    long cashAvailable;
    public Atm(long atmId, long twoThousands, long fiveHundreds, long oneHundreds) {
        this.atmId = atmId;
        this.twoThousands = twoThousands;
        this.fiveHundreds = fiveHundreds;
        this.oneHundreds = oneHundreds;
        this.cashAvailable = twoThousands * 2000 + fiveHundreds * 500 + oneHundreds * 100;
    }

    public long getAtmId() {
        return atmId;
    }

    public void setAtmId(long atmId) {
        this.atmId = atmId;
    }

    public long getTwoThousands() {
        return twoThousands;
    }

    public void setTwoThousands(long twoThousands) {
        this.twoThousands = twoThousands;
    }

    public long getFiveHundreds() {
        return fiveHundreds;
    }

    public void setFiveHundreds(long fiveHundreds) {
        this.fiveHundreds = fiveHundreds;
    }

    public long getOneHundreds() {
        return oneHundreds;
    }

    public void setOneHundreds(long oneHundreds) {
        this.oneHundreds = oneHundreds;
    }

    public long getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(long cashAvailable) {
        this.cashAvailable = cashAvailable;
    }
}
