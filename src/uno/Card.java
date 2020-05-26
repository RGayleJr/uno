package uno;

import java.util.Optional;

/**
 * Card interface to represent any generic card in the classic Uno game
 * @author ricardogayle
 *
 */
public interface Card {
    /**
     * Datatype Definition :
     * Card = NumberCard(color : Optional<cardColor>, value : cardValue)
     *      + ActionCard(color : Optional<cardColor>, value : cardValue)
     *      + WildCard(color : Optional<cardColor>, value : cardValue)
     */
    
    /**
     * @return the color of the Card, empty if Wild Card and the color 
     *         has not been chosen yet
     */
    public Optional<CardColor> getColor();
    
    /**
     * @return the face value of the Card
     */
    public CardValue getValue();
    
    /**
     * changes the color of Wild Cards that have not had a color chosen yet
     * has no effect on cards with colors chosen already 
     * @return true if color is set, false if color was already chosen
     */
    public boolean setColor();
    
    /**
     * returns true iff the two cards are identical to their look in a classic game
     * (Wild Cards will be equal to all Wild Cards and all Draw4 will be equal to all Draw4)
     * @param that object to be compared
     * @return true if the condition in description is met
     */
    @Override
    public boolean equals(Object that);
    
    /**
     * @return an appropriate hashCode given equals function
     */
    @Override
    public int hashCode();
    
    @Override
    public String toString();
}
