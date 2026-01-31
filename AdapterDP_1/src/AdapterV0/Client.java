package AdapterV0;
/*
    1. Tight coupling between the PhonePe class and the bank APIs. There should not be any sort of tight coupling between the application and the 3rd party apps.
    2. OCP principle is violated - multiple if-else blocks are present.
    3. DIP(Dependency Inversion Principle) is violated - It says that 2 concrete classes should not dependent on each other directly, rather they should be dependent on each other via interfaces.
 */
public class Client {
    public static void main(String[] args) {
        PhonePe p = new PhonePe("ICICI Bank");
        int balance = p.checkBalance();
        System.out.println("ICICI Bank balance - " + balance);
    }
}
