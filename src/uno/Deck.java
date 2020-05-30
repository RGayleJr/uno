package uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
     *          where the order the cards are dequeued from the  deck is the current deck. numbers, actions, and wilds
     *          are sets of the values for each corresponding type of card. totalNumberOfCards is the total number of
     *          cards in an UNO deck
     * Rep Invariant :
     *      deck.size <= 108
     * Safety from Rep Exposure :
     *      all fields are private, final and never returned.
     *      no card within deck is ever returned, except through defensive copying
     */
    
    /**
     * Creates a new UNO deck, filled with the correct amount of
     * cards for the classic game of UNO
     */
    public Deck() {
        List<Card> cards = new ArrayList<>();
        for (CardColor color : CardColor.values()) {
            cards.add(new NumberCard(color, CardValue.ZERO));
            Set<CardValue> notZero = new HashSet<>();
            notZero.addAll(numbers);
            notZero.remove(CardValue.ZERO);
            for (CardValue value : notZero) {
                for (int i = 0; i < 2; i++) {
                    cards.add(new NumberCard(color, value));
                }
            }
            for (CardValue value : actions) {
                for (int i = 0; i < 2; i++) {
                    cards.add(new ActionCard(color, value));
                }
            }
        }
        for (CardValue value : wilds) {
            for (int i = 0; i < 4; i++) {
                Optional<CardColor> noColor = Optional.empty();
                cards.add(new WildCard(noColor, value));
            }
        }
        Collections.shuffle(cards);
        this.deck = new LinkedList<>(cards);
        assert(this.deck.size() == totalNumberOfCards);
    }
    
    /**
     * The number of cards left in the deck
     * @return the number of cards in the deck
     */
    public int getSize() {
        return this.deck.size();
    }
    
    /**
     * Shuffles the deck of cards
     */
    public void shuffle() {
        List<Card> currDeck = new ArrayList<>(this.deck);
        Collections.shuffle(currDeck);
        this.deck.clear();
        this.deck.addAll(currDeck);
    }
    
    /**
     * Deals the top card on the deck
     * @return the card on the top of the deck
     */
    public Card deal() {
        return this.deck.removeFirst();
    }
    
    /**
     * Deals multiple cards
     * @param num number of cards being dealt
     * @return the set of cards that are dealt
     */
    public Set<Card> deal(int num) {
        Set<Card> dealt = new HashSet<>();
        for (int i = 0; i < num; i++) {
            dealt.add(this.deal());
        }
        return dealt;
    }
    
    /**
     * Moves top card in deck to the bottom
     */
    public void moveToEnd() {
        Card top = this.deal();
        this.deck.addLast(top);
    }
    
    /**
     * Looks at, but does not deal, a copy of the first card
     * @return empty if deck is empty, otherwise the first card in the deck
     */
    public Optional<Card> peekTop() {
        Card top = this.deck.peekFirst();
        if (top == null) {
            return Optional.empty();
        } else {
            return Optional.of(top.copy());
        }
    }
    
    @Override
    /**
     * Compares a Deck object to another Object, equal if that is an equivalent
     *      UNO deck (all the same cards in the same order)
     * @param that object to be compared to this
     * @return true iff the other object is a Deck and has the same cards 
     *         in the same order as this
     */
    public boolean equals(Object that) {
        return that instanceof Deck && this.deck.equals(((Deck) that).deck);
    }
    
    @Override
    public int hashCode() {
        return this.deck.hashCode();
    }
    
    @Override
    /**
     * Prints out the deck in the order that the cards are
     * @return string representation of the deck
     */
    public String toString() {
        String strDeck = "Remaining Deck :";
        for (Card card : this.deck) {
            strDeck += "\n" + card.toString();
        }
        strDeck += "\n" + "End of deck";
        return strDeck;
    }
}
