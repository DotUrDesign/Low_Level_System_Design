import model.ATM;
import model.Account;
import model.Card;
import repository.AtmRepository;
import service.AtmMachine;

public class Client {
    public static void main(String[] args) {
        // adding a card
        Card card = new Card(
                "Card123",
                "1234",
                new Account("Acc123",5000)
        );

        // adding the atms
        ATM atm1 = new ATM("ATM1",5,5,20);
        ATM atm2 = new ATM("ATM2",0,2,5);

        // adding the Atm repository - we are referring in-memory storage in our design
        AtmRepository atmRepository = new AtmRepository();

        // saving the atm banks
        atmRepository.save(atm1);
        atmRepository.save(atm2);

        // Now all the preconfigurations are over.
        // Lets start with the atm-machine and the processing of user's requests.
        AtmMachine atmMachine = new AtmMachine("IDLE-STATE", atmRepository);

        // now, we will be triggering each user operations
        atmMachine.insertCard(card);
        atmMachine.enterPin("1234");
        atmMachine.enterOption("WITHDRAW");
        atmMachine.dispenseCash(2000);
        atmMachine.ejectCard();
    }
}
