package uno;

import java.util.Optional;
import java.util.Set;

/**
 * Represents a card in UNO that is either a Skip, Reverse or Draw2
 * @author ricardogayle
 *
 */

public class ActionCard implements Card {
    private final CardColor color;
    private final CardValue value;
    private final Set<CardValue> legalValues = Set.of(CardValue.REVERSE, CardValue.SKIP, CardValue.DRAW2);
    /**
     * Abstract Function:
     *      ActionCard(color, value, legalValues) = an UNO card with color 'color' and face value 'value' from legalValues
     * Rep Invariant:
     *      value is from legalValues
     * Safety from Rep Exposure :
     *      
     */
    
    /**
     * Creates a card with color 'color' and value 'value'
     * @param color color for the card to be
     * @param value a number value from the cardValue types
     */
    public ActionCard(CardColor color, CardValue value) {
        this.color = color;
        this.value = value;
        checkRep();
    }

    /**
     * method ensuring rep invaraint is kept, should be used
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
    public boolean equals(Object that) {
        checkRep();
        return that instanceof ActionCard && this.sameValue((ActionCard) that);
    }
    
    /**
     * private helper method to compare an ActionCard with this
     * @param that card to be compared
     * @return true iff the two cards are equal as described in Card.java
     */
    private boolean sameValue(ActionCard that) {
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
