package AdapterV1_LooseCoupling;

public class Client {
    public static void main(String[] args) {
        String bankName = "Yes Bank"; // This is a simulation
        BankAPI adapter = PhonePe.getBankAdapter(bankName);
        int balance = adapter.checkBal();
        System.out.println(balance);

        System.out.println("-----------------------------");

        String bankName1 = "ICICI Bank"; // This is a simulation
        BankAPI adapter1 = PhonePe.getBankAdapter(bankName1);
        int balance1 = adapter1.checkBal();
        System.out.println(balance1);
    }
}
