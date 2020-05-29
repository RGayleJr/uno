package uno;

import java.util.Optional;

/**
 * The pile created from players placing cards in UNO
 * WARNING : Although this is the 'pile', it only consists of the
 *          top card, because the cards underneath are not really 
 *          necessary
 * @author ricardogayle
 *
 */
public class Table {
    private final Optional<Card> card = Optional.empty();
    
    /**
     * Abstraction Function :
     *      Table(card) = The pile created from players placing cards in UNO. If card is empty,
     *                    there is a new table with no cards yet.
     * Rep Invaraint :
     *      true
     * Safetry from Rep Exposure :
     *      card is protected through defensive copying
     */
    
    /**
     * creates an empty table
     */
    public Table() {}
    
    /**
     * Checks if table is empty or not
     * @return true iff there is no card on the pile
     */
    public boolean isPilePresent() {
        return card.isEmpty();
    }
    
    /**
     * Gets the card that is on the top pile
     * WARNING : this method returns a copy of the card on the deck
     * @return a copy of the card on the table
     */
    public Optional<Card> getCard() {
        if (card.isPresent()) {
            return Optional.of(card.get().copy());
        } else {
            return Optional.empty();
        }
    }
    
    @Override
    /**
     * Compares two Tables to each other. They are equal
     *      iff they share equal cards on the top of their
     *      respective piles, or both piles are empty
     * @return true iff they are equal as described above
     */
    public boolean equals(Object that) {
        return that instanceof Table && this.sameValue((Table) that);
    }
    
    /**
     * Private method to ensure the equality of two Tables as described in
     * equals method
     * @param that Table being compared to this
     * @return true iff Table is equal to this
     */
    public boolean sameValue(Table that) {
        return this.getCard().equals(that.getCard());
    }
    
    @Override
    public int hashCode() {
        return this.getCard().hashCode();
    }
    
    @Override
    public String toString() {
        if (this.getCard().isEmpty()) {
            return "No Cards on Table";
        } else {
            return this.getCard().get().toString();
        }
    }
}
