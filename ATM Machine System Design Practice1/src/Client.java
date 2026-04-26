import model.Account;
import model.Atm;
import model.Card;
import repository.AtmRepository;
import service.AtmMachine;

public class Client {
    public static void main(String[] args) {
        Card card = new Card(
                "14443",
                "1889",
                new Account("19990002992", 80000900)
        );

        Atm atm1 = new Atm("Atm1", 5, 10, 15);
        Atm atm2 = new Atm("Atm2", 14, 12, 9);

        AtmRepository atmRepository = new AtmRepository();
        atmRepository.save(atm1);
        atmRepository.save(atm2);

        AtmMachine atmMachine = new AtmMachine(
                card,
                atm1,
                "IDLE_STATE"
        );

        atmMachine.insertCard(card);
        atmMachine.enterPin("1889");
        atmMachine.enterOptions("WITHDRAW");
        atmMachine.dispenseCash(5900);
        atmMachine.ejectCard();
    }
}
