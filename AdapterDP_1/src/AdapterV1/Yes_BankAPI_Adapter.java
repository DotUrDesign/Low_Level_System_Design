package AdapterV1;

public class Yes_BankAPI_Adapter implements BankAPI{
    @Override
    public int checkBalance() {
        return Yes_BankAPI.getBalance();
    }
}
