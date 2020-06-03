package uno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Tests for Gameplay ADT
 * @author ricardogayle
 *
 */
class GameplayTest {
    
    /**
     * Testing Strategy :
     *      Gameplay() :
     *          first card on table is number : yes, no
     *          first card on table is skip : yes, no
     *          first card on table is reverse : yes, no
     *          first card on table is draw2 : yes, no
     *          first card on table is wild : yes, no
     *          first card on table is draw4 : yes, no
     *          assert all players start with 7 cards
     *      playCard :
     *          card is number : yes, no
     *          card is skip : yes, no
     *          card is reverse : yes, no
     *          card is draw2 : yes, no
     *          card is wild : yes, no
     *          card is draw4 : yes, no
     *          this.table has a number : yes, no
     *          this.table has a skip : yes, no
     *          this.table has a reverse : yes, no
     *          this.table has a draw 2 : yes, no
     *          this.table has a wild : yes, no
     *          this.table has a draw 4 : yes, no
     *      whoseTurn :
     *          this has been reversed : yes, no
     *      drawCard :
     *          occurring because of a draw2 : yes, no
     *          occurring because of a draw4 : yes, no
     *          occuring becuase no move : yes, no
     *          num : 1, 2, 4
     *      findLegalPlays :
     *          this.table has a number : yes, no
     *          this.table has a skip : yes, no
     *          this.table has a reverse : yes, no
     *          this.table has a draw 2 : yes, no
     *          this.table has a wild : yes, no
     *          this.table has a draw 4 : yes, no
     *                    
     *          
     *  Due to the randomness of the game, I am attempting to test this unconventionally.
     *  I will use a an array of False for each case I will be testing, as shown above.
     *  As long as all of these things have not been tested, I want more games to run.
     *  
     */

    @Test
    public void test() {
        final Map<String, Integer> testCases = new HashMap<>();
        testCases.put("firstNumber", 0);
        testCases.put("firstSkip", 1);
        testCases.put("firstReverse", 2);
        testCases.put("firstDraw2", 3);
        testCases.put("firstWild", 4);
        testCases.put("firstDraw4", 5);
        testCases.put("playNumber", 6);
        testCases.put("playSkip", 7);
        testCases.put("playReverse", 8);
        testCases.put("playDraw2", 9);
        testCases.put("playWild", 10);
        testCases.put("playDraw4", 11);
        final ArrayList<Boolean> passed = new ArrayList<>();
        for (int i = 0; i < testCases.size(); i++) {
            passed.add(false);
        }
        while (passed.contains(false)) {
            final Random rand = new Random();
            final Set<Player> opponents = new HashSet<>();
            int num = rand.nextInt(9) + 2;
            for (int i = 0; i < num; i++) {
                opponents.add(new Player("" + i));
            }
            final Gameplay game = new Gameplay(opponents);
        }
    }

}
