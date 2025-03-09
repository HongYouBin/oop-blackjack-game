package blackjack.game;

import blackjack.card.Card;
import blackjack.player.Dealer;
import blackjack.player.Player;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private Dealer dealer;
    private Scanner sc = new Scanner(System.in);

    public Game(Player player, Dealer dealer) {
        this.player = player;
        this.dealer = dealer;
    }

    public void run() {
        System.out.println('\n' + '\n' + "Game start");

        selectTwoCards();
        if(player.getScore() == 21) {
            System.out.println("player win!!!");
            return;
        }
        hitAndStand();
        getWinner();
    }

    private void getWinner() {
        if (player.getScore() > 21) {
            System.out.println("player lose!!!"); // 플레이어 점수가 21 초과 → 무조건 패배
        } else if (dealer.getScore() > 21 || player.getScore() > dealer.getScore()) {
            System.out.println("player win!!!"); // 딜러 점수가 21 초과하거나, 플레이어 점수가 더 크면 승리
        } else if (player.getScore() == dealer.getScore()) {
            System.out.println("Push");
        } else {
            System.out.println("player lose!!!"); // 나머지 경우는 플레이어 패배
        }
    }

    private void hitAndStand() {
        while (player.getScore() <= 21) {
            System.out.println("hit or stand");
            String in = sc.next();
            if(in.equals("hit")) {
                player.hit();
                System.out.println("----- cards of player -----");
                showCards(player.showCards());
                System.out.println(player.getScore());
            } else if(in.equals("stand")) {
                break;
            }
        }

        if(player.getScore() > 21) {
            return;
        }

        System.out.println("----- cards of dealer -----");
        showCards(dealer.showCards());
        dealer.hitWhileBelowSeventeen();
    }

    private void showCards(List<Card> cards) {
        cards.forEach(System.out::println);
        System.out.println("score : " + cards.stream().mapToInt(Card::getScore).sum());
    }

    private void selectTwoCards() {
        System.out.println("----- select two cards -----");
        player.selectTwoCards();
        dealer.selectTwoCards();

        System.out.println("----- card of player -----");
        showCards(player.showCards());
        System.out.println("----- card of dealer -----");
        System.out.println(dealer.showCard());
    }
}
