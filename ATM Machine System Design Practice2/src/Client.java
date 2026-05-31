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

        Atm atm1 = new Atm(
                2333,
                45,
                23,
                12
        );
        Atm atm2 = new Atm(
                2333,
                43,
                56,
                11
        );
        AtmRepository atmRepository = new AtmRepository();
        atmRepository.saveAtm(atm1);
        atmRepository.saveAtm(atm2);

        AtmMachine atmMachine = new AtmMachine(atm1, card, "IDLE_STATE");
        atmMachine.insertCard(card);
        atmMachine.enterPin("1889");
        atmMachine.enterOptions("WITHDRAW");
        atmMachine.dispenseCash(2000);
        atmMachine.ejectCard();
    }
}
