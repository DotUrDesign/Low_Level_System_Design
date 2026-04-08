package state;

import model.Card;

public interface AtmState {
    void insertCard(Card card);
    void enterPin(String pin);
    void enterOption(String option);
    void dispenseCash(int amount);
    void ejectCard();
}
