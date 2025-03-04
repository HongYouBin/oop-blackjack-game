package blackjack.player;

import blackjack.card.Card;

import java.util.List;

public interface Player {
    List<Card> showCards();
    void hit();
    int getSum();

    void initCard();
}
