import enums.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardTests {
    private Card card;

    @BeforeEach
    public void setUp(){
        Suit suit = Suit.HEARTS;
        Value value = Value.ACE;
        card = new Card(suit, value);
    }

    @Test
    public void getPointTest(){
        int expected = 11;
        int actual = card.getPoint();
        Assertions.assertEquals(expected, actual);
    }

}
