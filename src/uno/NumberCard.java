package uno;

import java.util.Optional;
import java.util.Set;

/**
 * IMMUTABLE - Represents a card in UNO that has a number value
 * @author ricardogayle
 *
 */
public class NumberCard implements Card {
    private final CardColor color;
    private final CardValue value;
    private final Set<CardValue> legalValues = Set.of(CardValue.ZERO, CardValue.ONE, CardValue.TWO,
            CardValue.THREE, CardValue.FOUR, CardValue.FIVE, CardValue.SIX, CardValue.SEVEN, CardValue.EIGHT,
            CardValue.NINE);
    /**
     * Abstract Function:
     *      NumberCard(color, value, legalValues) = an UNO card with color 'color' and face value 'value' from legalValues
     * Rep Invariant:
     *      value is from legalValues
     * Safety from Rep Exposure :
     *      color is kept safe through creating a new Optional and cardColor is immutable
     *      value is kept safe because it is immutable
     *      legalValues is never returned
     */
    
    /**
     * Creates a card with color 'color' and value 'value'
     * @param color color for the card to be
     * @param value a number value from the cardValue types
     */
    public NumberCard(CardColor color, CardValue value) {
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
    }

    @Override
    public Optional<CardColor> getColor() {
        checkRep();
        return Optional.of(this.color);
    }

    @Override
    public CardValue getValue() {
        checkRep();
        return this.value;
    }

    @Override
    public boolean setColor(CardColor color) {
        checkRep();
        return false;
    }
    
    @Override
    public Card copy() {
        checkRep();
        return new NumberCard(this.getColor().get(), this.getValue());
    }

    @Override
    public boolean equals(Object that) {
        checkRep();
        return that instanceof NumberCard && this.sameValue((NumberCard) that);
    }
    
    /**
     * private helper method to compare a NumberCard with this
     * @param that card to be compared
     * @return true iff the two cards are equal as described in Card.java
     */
    private boolean sameValue(NumberCard that) {
        checkRep();
        return this.getColor().equals(that.getColor()) && this.getValue().equals(that.getValue());
    }
    
    @Override
    public int hashCode() {
        checkRep();
        return this.getColor().hashCode() * this.getValue().hashCode();
    }
    
    @Override
    public String toString() {
        checkRep();
        return this.getColor().toString() + " " + this.getValue().toString();
    }
}
