package uno;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Gameplay ADT to set up and execute gameplay of UNO
 * Gameplay and set up is described at https://service.mattel.com/instruction_sheets/42001pr.pdf
 * @author ricardogayle
 *
 */
public class Gameplay {
    private Map<Integer, Integer> players;
    private final List<Player> playerWheel;
    private final Deck deck;
    private final Table table;
    private final int playerTurn;
    
    /**
     * Abstraction Function :
     *      Gameplay(players, playerWheel, deck, table) = A game of UNO where the key in 'players'
     *              is the index of the Player in 'playerWheel' who has the score, of the 
     *              corresponding value. The game is being played with 'deck' as the game's deck
     *              and 'table' as the discard pile. 'playerTurn' is a counter used to keep track
     *              of whose turn it is using 'playerTurn' as the index in 'playerWheel'
     * Rep Invariant :
     *      2 <= players.size == playWheel.size <= 10
     *      playerTurn > 0
     * Safety from Rep Exposure :
     *      TODO
     */
    
    public Gameplay(Set<Player> opponents) {
        this.playerWheel = List.copyOf(opponents);
        Collections.shuffle(this.playerWheel);
        this.players = new HashMap<>();
        for (int i = 0; i < this.playerWheel.size(); i++) {
            this.players.put(i, 0);
        }
        this.deck = new Deck();
        this.table = new Table();
        this.playerTurn = 0;
    }
    
    /**
     * Sets up the game of UNO
     */
    public void setUp() {
        // TODO 
    }
    
    /**
     * The player whose turn it is plays a card
     * @param card the Card being played
     */
    public void playCard(Card card) {
        // TODO
    }
    
    /**
     * Returns the player whose turn it is
     * @return Player whose turn it is
     */
    public Player whoseTurn() {
        // TODO
        return new Player("a");
    }
    
    /**
     * The player whose turn it is draws a card
     * from the deck
     */
    public void drawCard() {
        // TODO
    }
    
    /**
     * The player whose turn it is draws multiple cards
     * from the deck
     * @param num the number of cards that are drawn
     */
    public void drawCard(int num) {
        // TODO
    }
}
