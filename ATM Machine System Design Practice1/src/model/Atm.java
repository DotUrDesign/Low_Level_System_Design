package model;

public class Atm {
    String atmId;
    int TwoThousands;
    int fiveHundreds;
    int OneHundreds;
    int cashAvailable;

    public Atm(String atmId, int twoThousands, int fiveHundreds, int oneHundreds) {
        this.atmId = atmId;
        TwoThousands = twoThousands;
        this.fiveHundreds = fiveHundreds;
        OneHundreds = oneHundreds;
        this.cashAvailable = twoThousands * 2000 + fiveHundreds * 500 + oneHundreds * 100;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public int getTwoThousands() {
        return TwoThousands;
    }

    public void setTwoThousands(int twoThousands) {
        TwoThousands = twoThousands;
    }

    public int getFiveHundreds() {
        return fiveHundreds;
    }

    public void setFiveHundreds(int fiveHundreds) {
        this.fiveHundreds = fiveHundreds;
    }

    public int getOneHundreds() {
        return OneHundreds;
    }

    public void setOneHundreds(int oneHundreds) {
        OneHundreds = oneHundreds;
    }

    public int getCashAvailable() {
        return cashAvailable;
    }

    public void setCashAvailable(int cashAvailable) {
        this.cashAvailable = cashAvailable;
    }
}
