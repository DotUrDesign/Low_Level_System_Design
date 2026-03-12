package AdapterV0;

public class PhonePe {
    private String bankName;
    public PhonePe(String bankName) {
        this.bankName = bankName;
    }
    public int getBalance() {
        if(this.bankName.equals("ICICI Bank")) {
            return ICICIBankAPI.checkBalance();
        } else if(this.bankName.equals("Yes Bank")) {
            return YesBankAPI.getBalance();
        }
        return 0;
    }
}
