package AdapterV0_TightCoupling;

public class Client {
    public static void main(String[] args) {
        String bankName = "Yes Bank";
        PhonePe p = new PhonePe();
        int balance = p.checkBalance(bankName);
        System.out.println("Balance - " + balance);

        System.out.println("-------------------------------------");

        String bankName1 = "ICICI Bank";
        PhonePe p1 = new PhonePe();
        int balance1 = p1.checkBalance(bankName1);
        System.out.println("Balance - " + balance1);
    }
}
