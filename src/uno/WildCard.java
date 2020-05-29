package uno;

import java.util.Optional;
import java.util.Set;

/**
 * Represents a card in UNO that is either a Wild Card or Draw 4
 * @author ricardogayle
 *
 */
public class WildCard implements Card {
    private Optional<CardColor> color;
    private final CardValue value;
    private final Set<CardValue> legalValues = Set.of(CardValue.WILD, CardValue.DRAW4);
    
    /**
     * Abstract Function:
     *      WildCard(color, value, legalValues) = an UNO card with color 'color' and face value 'value' from legalValues
     * Rep Invariant:
     *      value is from legalValues
     * Safety from Rep Exposure:
     *      color and value are immutable
     *      legalValues is never returned
     */

    /**
     * Creates a card with color 'color' and value 'value'
     * @param color color for the card to be
     * @param value a number value from the CardValue types
     */
    public WildCard(Optional<CardColor> color, CardValue value) {
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
        assert(color != null);
        assert(value != null);
    }
    
    @Override
    public Optional<CardColor> getColor() {
        if (this.color.isEmpty()) {
            checkRep();
            return Optional.empty();
        }
        CardColor coloring = this.color.get();
        checkRep();
        return Optional.of(coloring);
    }

    @Override
    public CardValue getValue() {
        checkRep();
        return this.value;
    }

    @Override
    public boolean setColor(CardColor color) {
        if (this.color.isEmpty()) {
            this.color = Optional.of(color);
            checkRep();
            return true;
        }
        return false;
    }
    
    @Override
    public Card copy() {
        return new WildCard(this.getColor(), this.getValue());
    }
    
    @Override
    public boolean equals(Object that) {
        checkRep();
        return that instanceof WildCard && this.sameValue((WildCard) that);
    }
    
    /**
     * private helper method to compare a WildCard with this
     * @param that card to be compared
     * @return true iff the two cards are equal as described in Card.java
     */
    private boolean sameValue(WildCard that) {
        checkRep();
        return this.getValue().equals(that.getValue());
    }
    
    @Override
    public int hashCode() {
        checkRep();
        return this.getValue().hashCode();
    }
    
    @Override
    public String toString() {
        if (this.getColor().isEmpty()) {
            checkRep();
            return "NoColor " + this.getValue().toString();
        }
        checkRep();
        return this.getColor().get().toString() + " " + this.getValue().toString();
    }
}
