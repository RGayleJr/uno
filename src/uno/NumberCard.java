package uno;

import java.util.Optional;
import java.util.Set;

/**
 * Represents a card in UNO that has a number value
 * @author ricardogayle
 *
 */
public class NumberCard implements Card {
    private final Optional<CardColor> color;
    private final CardValue value;
    private final Set<CardValue> legalValues = Set.of(CardValue.ZERO, CardValue.ONE, CardValue.TWO,
            CardValue.THREE, CardValue.FOUR, CardValue.FIVE, CardValue.SIX, CardValue.SEVEN, CardValue.EIGHT,
            CardValue.NINE);
    /**
     * Abstract Function:
     *      NumberCard(color, value) = an UNO card with color 'color' and face value 'value' from legalValues
     * Rep Invariant:
     *      value is from legalValues
     *      color is not empty
     * Safety from Rep Exposure :
     *      color is kept safe through creating a new Optional and cardColor is immutable
     *      value is kept safe because it is immutable
     *      
     */
    
    /**
     * Creates a card with color 'color' and value 'value'
     * @param color color for the card to be
     * @param value a number value from the cardValue types
     */
    public NumberCard(Optional<CardColor> color, CardValue value) {
        this.color = color;
        this.value = value;
        checkRep();
    }
    
    /**
     * method ensuring rep invariant is kept, should be used 
     * at end of every method
     */
    private void checkRep() {
        assert(legalValues.contains(this.value));
        assert(!this.color.isEmpty());
    }

    @Override
    public Optional<CardColor> getColor() {
        CardColor coloring = this.color.get();
        return Optional.of(coloring);
    }

    @Override
    public CardValue getValue() {
        return this.value;
    }

    @Override
    public boolean setColor() {
        return false;
    }

    @Override
    public boolean equals(Object that) {
        return that instanceof NumberCard && this.sameValue((NumberCard) that);
    }
    
    /**
     * private helper method to compare a NumberCard with this
     * @param that card to be compared
     * @return true iff the two cards are equal as described in Card.java
     */
    private boolean sameValue(NumberCard that) {
        return this.getColor().equals(that.getColor()) && this.getValue().equals(that.getValue());
    }
    
    @Override
    public int hashCode() {
        return this.getColor().hashCode() * this.getValue().hashCode();
    }
    
    @Override
    public String toString() {
        return this.getColor().toString() + " " + this.getValue().toString();
    }
}
