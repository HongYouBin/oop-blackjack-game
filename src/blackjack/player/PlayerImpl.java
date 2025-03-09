package blackjack.player;

import blackjack.card.Card;
import blackjack.card.CardDeck;

import java.util.ArrayList;
import java.util.List;

public class PlayerImpl implements Player {
    private CardDeck cardDeck;
    private List<Card> cardList;

    public PlayerImpl(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
        cardList = new ArrayList<>();
    }


    @Override
    public List<Card> showCards() {
        return cardList;
    }

    @Override
    public void hit() {
        if(getScore() > 21) {
            System.out.println("score is : " + getScore() + ". you can't hit.");
            return;
        }
        Card card = cardDeck.selectCard();
        cardList.add(card);
    }

    @Override
    public int getScore() {
        return cardList.stream().mapToInt(Card::getScore).sum();
    }

    @Override
    public void selectTwoCards() {
        hit();
        hit();
    }
}
