import blackjack.card.CardDeck;
import blackjack.card.CardDeckImpl;
import blackjack.game.Game;
import blackjack.player.Dealer;
import blackjack.player.DealerImpl;
import blackjack.player.Player;
import blackjack.player.PlayerImpl;

public class Main {
    public static void main(String[] args) {
        CardDeck cardDeck = new CardDeckImpl();
        Player player = new PlayerImpl(cardDeck);
        Dealer dealer = new DealerImpl(cardDeck);
        Game game = new Game(player, dealer);
        game.run();
    }
}