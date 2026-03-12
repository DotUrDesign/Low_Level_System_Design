package AdapterV0;
/*
    DIP - dependency inversion principle
        - 2 concrete classes are being dependent on each other without any involvement of
        interfaces.

    PhonePe should be connected with bank Apis directly.
    Any crash on APIs can directly affect the PHonepe application.
 */
public class Client {
    public static void main(String[] args) {
        String bankName = "ICICI Bank";
        PhonePe p = new PhonePe(bankName);
        int balance = p.getBalance();
        System.out.println("Balance - " + balance);
    }
}
