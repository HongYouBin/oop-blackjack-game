package blackjack.card;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CardDeck {
    private Map<Integer, Card> cards;
    private Integer cardCount;
    Random random = new Random();

    public CardDeck() {
        this.cards = new HashMap<>();
        this.cardCount = 52;
        initializeDeck();
    }

    private void initializeDeck() {
        String[] shapes = {"♠", "♥", "♦", "♣"}; // 스페이드, 하트, 다이아몬드, 클럽
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        int index = 0; // 카드 고유 번호 (1~52)

        for (String shape : shapes) {
            for (String number : numbers) {
                int score = getScore(number);
                cards.put(index++, new Card(shape, number, score));
            }
        }
    }

    private int getScore(String number) {
        if (number.equals("A")) return 1; // A는 기본 11점
        if (number.equals("J") || number.equals("Q") || number.equals("K")) return 10; // J, Q, K는 10점
        return Integer.parseInt(number); // 숫자 카드 그대로 점수 사용
    }


    public Card selectCard() {
        int randomNumber = random.nextInt(cardCount);
        Card card = cards.get(randomNumber);
        cards.remove(randomNumber);
        cardCount--;
        return card;
    }
}
