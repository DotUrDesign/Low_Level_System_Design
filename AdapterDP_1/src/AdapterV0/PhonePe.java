package AdapterV0;

public class PhonePe {
    String BankName;
    PhonePe(String BankName) {
        this.BankName = BankName;
    }
    public int checkBalance() {
        if(BankName.equals("ICICI Bank")) {
            return ICICI_BankAPI.checkBalance();
        } else if(BankName.equals("Yes Bank")) {
            return YesBank_BankAPI.getBalance();
        }
        return 0;
    }
}
