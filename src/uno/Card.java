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
    public Optional<cardColor> getColor();
    
    /**
     * @return the face value of the Card
     */
    public cardValue getValue();
    
    /**
     * changes the color of Wild Cards that have not had a color chosen yet
     * has no effect on cards with colors chosen already 
     * @return true if color is set, false if color was already chosen
     */
    public boolean setColor();
}
