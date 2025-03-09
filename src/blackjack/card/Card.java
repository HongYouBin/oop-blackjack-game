package blackjack.card;

public class Card {
    public Card(String shape, String number, Integer score) {
        this.shape = shape;
        this.number = number;
        this.score = score;
    }

    private String shape;
    private String number;
    private Integer score;
    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Card{" +
                "shape='" + shape + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
