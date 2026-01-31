package AdapterV1_LooseCoupling;

public class YesBankAPIAdapter implements BankAPI{
    @Override
    public int checkBal() {
        YesBankAPI bankApiObj = new YesBankAPI();
        int balance = bankApiObj.getBalance();
        return balance;
    }
}
