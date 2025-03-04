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
    public void hit() {
        while(getSum() < 17) {
            Card card = cardDeck.selectCard();
            cardList.add(card);
            System.out.println("card is " + card);
            System.out.println("current sum : " + getSum());
        }
    }

    @Override
    public int getSum() {
        int sum = 0;
        for(int i=0;i<cardList.size();++i) {
            sum += cardList.get(i).getScore();
        }
        return sum;
    }

    @Override
    public void initCard() {
        cardList.add(cardDeck.selectCard());
        cardList.add(cardDeck.selectCard());
    }
}
