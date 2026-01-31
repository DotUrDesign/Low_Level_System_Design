package AdapterV1_LooseCoupling;

public class PhonePe {
    public static BankAPI getBankAdapter(String bankName) {
        if(bankName.equals("Yes Bank")) {
            return new YesBankAPIAdapter();
        } else if(bankName.equals("ICICI Bank")) {
            return new ICICIBankAPIAdapter();
        }
        return null;
    }
}
