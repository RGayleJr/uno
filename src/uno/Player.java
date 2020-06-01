package uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Player ADT representing a player in a game of UNO
 * @author ricardogayle
 *
 */
public class Player {
    private final List<Card> hand;
    private final String name;
    
    /**
     * Abstraction Function :
     *      Player(hand, name) = a player with the name of 'name' and has the cards
     *          in 'hand' in his hand
     * Rep Invariant :
     *      name.length > 0
     * Safety From Rep Exposure :
     *      name is private, final, and immutable
     *      hand is never returned, except through deep copying
     *      a Card that remains in hand is never returned
     */
    
    /**
     * Creates Player with empty hand and name 'name'
     * @param name the name given to this
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        checkRep();
    }
    
    private void checkRep() {
        assert (this.name.length() > 0);
        assert (this.hand != null && !this.hand.contains(null));
    }
    
    /**
     * Returns the name of this
     * @return name of player
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Player plays the card in hand at index 'index' and removes card from 'hand'
     * @param index index of card in this.hand
     * @return the card being played
     */
    public Card play(int index) {
        Card card = hand.remove(index);
        checkRep();
        return card;
    }
    
    /**
     * Looks at cards in player's hand
     * WARNING : returns deep copy list of player's hand
     * @return copy of player's hand
     */
    public List<Card> peekHand() {
        List<Card> handCopy = new ArrayList<>();
        for (Card card : this.hand) {
            handCopy.add(card.copy());
        }
        checkRep();
        return Collections.unmodifiableList(handCopy);
    }
    
    @Override
    /**
     * Compares an object against this
     * @param that object to compared against this
     * @return true iff that is a Player and is structurally equal to this --
     *          share same name and hand
     */
    public boolean equals(Object that) {
        return that instanceof Player && this.sameValue((Player) that);
    }
    
    /**
     * Compares a Player to this
     * @param that Player to be compared
     * @return true iff the two players are structurally equal -- share
     *          the same name and hand
     */
    private boolean sameValue(Player that) {
        return this.getName().equals(that.getName()) && this.peekHand().equals(that.peekHand());
    }
    
    @Override
    /**
     * Hash Code consistent with equals()
     * @return hash code of Player
     */
    public int hashCode() {
        return this.getName().hashCode() * this.peekHand().hashCode();
    }
    
    @Override
    public String toString() {
        return this.getName() + "\n" + this.peekHand().toString();
    }
}
