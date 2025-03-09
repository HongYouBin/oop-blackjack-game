package blackjack.player;

import blackjack.card.Card;
import blackjack.card.CardDeck;

import java.util.ArrayList;
import java.util.List;

public class DealerImpl implements Dealer {
    private CardDeck cardDeck;
    private List<Card> cardList;

    public DealerImpl(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
        cardList = new ArrayList<>();
    }

    @Override
    public Card showCard() {
        return cardList.get(0);
    }

    @Override
    public List<Card> showCards() {
        return cardList;
    }

    @Override
    public void hitWhileBelowSeventeen() {
        System.out.println("--- dealer hit ---");
        while(getScore() < 17) {
            Card card = cardDeck.selectCard();
            cardList.add(card);
            System.out.println("card is " + card);
            System.out.println("current sum : " + getScore());
        }
    }

    @Override
    public int getScore() {
        return cardList.stream().mapToInt(Card::getScore).sum();
    }

    @Override
    public void selectTwoCards() {
        cardList.add(cardDeck.selectCard());
        cardList.add(cardDeck.selectCard());
    }
}
