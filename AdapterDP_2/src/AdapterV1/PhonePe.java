package AdapterV1;

public class PhonePe {
    public static BankAPI getAdapter(String bankName) {
        if(bankName.equals("ICICI Bank")) {
            return new ICICIBankAPIAdapter();
        } else if(bankName.equals("Yes Bank")) {
            return new YesBankAPIAdapter();
        }
        return null;
    }
}
