package blackjack.game;

import blackjack.card.Card;
import blackjack.player.Dealer;
import blackjack.player.Player;

import java.util.Arrays;
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

        initCardSetting();
        if(player.getSum() == 21) {
            System.out.println("player win!!");
            return;
        }

        hitAndStand();

        if(player.getSum() <= 21 && dealer.getSum() <= 21) {

        }
    }

    private void hitAndStand() {
        while (true) {
            System.out.println("hit or stand");
            String in = sc.next();
            if(in.equals("hit")) {
                player.hit();
                showPlayerCards();
                System.out.println(player.getSum());
            } else if(in.equals("stand")) {
                break;
            }
        }

        showDealerCards();
        dealer.hit();
    }

    private void showPlayerCards() {
        System.out.println("----- cards of player -----");
        List<Card> cards = player.showCards();
        cards.forEach(System.out::println);
    }

    private void showDealerCards() {
        System.out.println("----- cards of dealer -----");
        List<Card> cards = dealer.showCards();
        cards.forEach(System.out::println);
    }

    private void initCardSetting() {
        player.initCard();
        dealer.initCard();

        showPlayerCards();
        System.out.println("----- card of dealer -----");
        System.out.println(dealer.showCard());
    }
}
