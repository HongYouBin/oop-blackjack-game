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
        if(getSum() > 21) {
            System.out.println("score is : " + getSum() + ". you can't hit.");
            return;
        }
        Card card = cardDeck.selectCard();
        cardList.add(card);
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
        hit();
        hit();
    }
}
