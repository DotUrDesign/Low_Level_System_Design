package AdapterV1;

public class YesBankAPIAdapter implements BankAPI {
    @Override
    public int getBalance() {
        return YesBankAPI.getBalance();
    }
}
