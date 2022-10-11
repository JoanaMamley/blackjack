import enums.PlayerState;
import enums.Suit;
import enums.Value;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {

    Player player;
    Card card, card2, card3;

    @BeforeEach
    public void setUp(){
        player =  new Player();
        card = new Card(Suit.HEARTS, Value.ACE);
    }

    @Test
    public void stateTest(){
        player.setState(PlayerState.Ejected);
        assertEquals(PlayerState.Ejected, player.getState());

        player.setState(PlayerState.InPlay);
        assertEquals(PlayerState.InPlay, player.getState());
    }

    @Test
    public  void addCardTest(){
        player.addCardToHand(card);
        assertTrue(player.getHand().contains(card));
    }

    @Test
    public void getStateTest(){
        assertInstanceOf(PlayerState.class, player.getState());
    }

    @Test
    public void totalHandPointsTest(){
        player.addCardToHand(card);
        player.addCardToHand(new Card(Suit.DIAMONDS, Value.ACE));
        player.addCardToHand(new Card(Suit.SPADES, Value.ACE));
        assertEquals(33, player.getHand().stream().mapToInt(Card::getPoint).sum());
    }
}
