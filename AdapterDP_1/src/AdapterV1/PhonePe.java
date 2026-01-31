package AdapterV1;

public class PhonePe {
    public static BankAPI getAdapter(String bankName) {
        if(bankName.equals("ICICI Bank")) {
            return new ICICI_BankAPI_Adapter();
        } else if(bankName.equals("Yes Bank")) {
            return new Yes_BankAPI_Adapter();
        }
        return null;
    }
}
