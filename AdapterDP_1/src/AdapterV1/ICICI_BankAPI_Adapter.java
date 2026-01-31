package AdapterV1;

public class ICICI_BankAPI_Adapter implements BankAPI{
    @Override
    public int checkBalance() {
        return ICICI_BankAPI.checkBalance();
    }
}
