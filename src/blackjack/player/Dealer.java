package blackjack.player;

import blackjack.card.Card;

import java.util.List;

public interface Dealer {
    Card showCard();
    List<Card> showCards();
    void hitWhileBelowSeventeen();
    int getScore();
    void selectTwoCards();
}
