package uno;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Mutable Deck ADT that represents the face down deck in a game of UNO
 * @author ricardogayle
 *
 */
public class Deck {
    private final Deque<Card> deck;
    
    /**
     * Abstraction Function :
     *      Deck(deck) = the 'deck' represents the cards in a game of UNO,
     *          where the order the cards are dequeued from the  deck is the
     *          current deck
     * Rep Invariant :
     *      deck.size <= 108
     * Safety from Rep Exposure :
     *      
     */
    
    public Deck() {
        this.deck = new LinkedList<>();
    }
}
