package AdapterV1;

public class Client {
    public static void main(String[] args) {
        String bankName = "ICICI Bank";
        BankAPI adapter = PhonePe.getAdapter(bankName);
        int balance = adapter.getBalance();
        System.out.println("Balance - " + balance);
    }
}
