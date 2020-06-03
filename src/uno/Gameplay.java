package uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Gameplay ADT to set up and execute gameplay of UNO
 * Gameplay and set up is described at https://service.mattel.com/instruction_sheets/42001pr.pdf
 * with only modification being that player order is chosen randomly
 * @author ricardogayle
 *
 */
public class Gameplay {
    private final List<Player> playerWheel;
    private final Deck deck;
    private final Table table;
    private final int playerTurn;
    
    /**
     * Abstraction Function :
     *      Gameplay(playerWheel, deck, table) = A game of UNO where the players of the game 
     *              are listed in play8ing order in 'playerWheel'. The game is being played 
     *              with 'deck' as the game's deck and 'table' as the discard pile. 'playerTurn'
     *              is a counter used to keep track of whose turn it is using 'playerTurn' as 
     *              the index in 'playerWheel'
     * Rep Invariant :
     *      2 <= players.size == playWheel.size <= 10
     *      playerTurn > 0
     * Safety from Rep Exposure :
     *      TODO
     */
    
    public Gameplay(Set<Player> opponents) {
        this.playerWheel = List.copyOf(opponents);
        Collections.shuffle(this.playerWheel);
        this.deck = new Deck();
        this.table = new Table();
        this.playerTurn = 0;
        this.setUp();
    }
    
    /**
     * Sets up the game of UNO
     */
    private void setUp() {
        for (Player player : this.playerWheel) {
            final int startingCards = 7;
            final List<Card> hand = this.deck.deal(startingCards);
            player.addCards(hand);
        }
        Card top = this.deck.peekTop().get();
        while (top.getValue() == CardValue.DRAW4) {
            this.deck.moveToEnd();
            top = this.deck.peekTop().get();
        }
        // TODO
    }
    
    private void nextTurn() {
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
    private void drawCard() {
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
    
    /**
     * Finds all the cards that can legally be placed 
     * by the player whose turn it is
     * @return the cards that are legal to play
     */
    public List<Card> findLegalPlays() {
        final List<Card> plays = new ArrayList<>();
        // TODO
        return plays;
    }
}
