package uno;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Set;

/**
 * Mutable Deck ADT that represents the face down deck in a game of UNO
 * @author ricardogayle
 *
 */
public class Deck {
    private final Deque<Card> deck;
    private final Set<CardValue> numbers = Set.of(CardValue.ZERO, CardValue.ONE, CardValue.TWO, CardValue.THREE,
                                             CardValue.FOUR, CardValue.FIVE, CardValue.SIX,
                                             CardValue.SEVEN, CardValue.EIGHT, CardValue.NINE);
    private final Set<CardValue> actions = Set.of(CardValue.DRAW2, CardValue.SKIP, CardValue.REVERSE);
    private final Set<CardValue> wilds = Set.of(CardValue.WILD, CardValue.DRAW4);
    private final int totalNumberOfCards = 108;
    
    /**
     * Abstraction Function :
     *      Deck(deck, numbers, actions, wilds, totalNumberOfCards) = the 'deck' represents the cards in a game of UNO,
     *          where the order the cards are dequeued from the  deck is the current deck
     * Rep Invariant :
     *      deck.size <= 108
     * Safety from Rep Exposure :
     *      
     */
    
    /**
     * Creates a new UNO deck, filled with the correct amount of
     * cards for the classic game of UNO
     */
    public Deck() {
        this.deck = new LinkedList<>();
        for (CardColor color : CardColor.values()) {
            this.deck.add(new NumberCard(color, CardValue.ZERO));
            Set<CardValue> notZero = new HashSet<>();
            notZero.addAll(numbers);
            notZero.remove(CardValue.ZERO);
            for (CardValue value : notZero) {
                for (int i = 0; i < 2; i++) {
                    this.deck.add(new NumberCard(color, value));
                }
            }
            for (CardValue value : actions) {
                for (int i = 0; i < 2; i++) {
                    this.deck.add(new ActionCard(color, value));
                }
            }
        }
        for (CardValue value : wilds) {
            for (int i = 0; i < 4; i++) {
                Optional<CardColor> noColor = Optional.empty();
                this.deck.add(new WildCard(noColor, value));
            }
        }
        assert(this.deck.size() == totalNumberOfCards);
    }
    
    /**
     * The number of cards left in the deck
     * @return the number of cards in the deck
     */
    public int getSize() {
        return this.deck.size();
    }
    
    @Override
    /**
     * Prints out the deck in the order that the cards are
     * @return string representation of the deck
     */
    public String toString() {
        String deck = "Remaining Deck :";
        for (Card card : this.deck) {
            deck += "\n" + card.toString();
        }
        deck += "\n" + "End of deck";
        return deck;
    }
}
