package AdapterV1;

public class ICICIBankAPIAdapter implements BankAPI {
    @Override
    public int getBalance() {
        return ICICIBankAPI.checkBalance();
    }
}
