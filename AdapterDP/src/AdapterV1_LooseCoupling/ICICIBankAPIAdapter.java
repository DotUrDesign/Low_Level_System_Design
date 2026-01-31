package AdapterV1_LooseCoupling;

public class ICICIBankAPIAdapter implements BankAPI{
    @Override
    public int checkBal() {
        ICICIBankAPI bankApiObj = new ICICIBankAPI();
        int balance = bankApiObj.checkBalance();
        return balance;
    }
}
