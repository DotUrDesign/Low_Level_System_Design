package AdapterV0_TightCoupling;
/*
    OCP principle violated -> Multiple if-else blocks are present.
    DIP principle violated -> No 2 concrete classes should be directly dependent on each other[like PhonePe and ICICIBankAPI (or) PhonePe and YesBankAPI]. They should be dependent on each other via interfaces.
 */
public class PhonePe {
    public int checkBalance(String bankName) {
        int balance = 0;
        if(bankName.equals("Yes Bank")) {
            YesBankAPI obj = new YesBankAPI();
            balance = obj.getBalance();
        } else if(bankName.equals("ICICI Bank")) {
            ICICIBankAPI obj = new ICICIBankAPI();
            balance = obj.checkBalance();
        }
        return balance;
    }
}
