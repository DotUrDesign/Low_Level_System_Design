package AdapterV1;

public class Client{
    public static void main(String[] args) {
        String bankName = "ICICI Bank"; // this is a simulation
        BankAPI p = PhonePe.getAdapter(bankName); // ICICI_BankAPI_Adapter
        int balance = p.checkBalance();
        System.out.println("ICICI bank balance - " + balance);

        System.out.println("----------------------------");

        String bankName1 = "Yes Bank"; // this is a simulation
        BankAPI p1 = PhonePe.getAdapter(bankName1); // Yes_BankAPI_Adapter
        int balance1 = p1.checkBalance();
        System.out.println("Yes bank balance - " + balance1);
    }
}
