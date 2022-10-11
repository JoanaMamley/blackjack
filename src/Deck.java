import enums.Suit;
import enums.Value;
import java.util.*;

public class Deck {

    private Queue<Card> cards;

    public Deck(){
        List<Card> cs = new ArrayList<>(52);

//        use builder pattern to create cards
        for(Suit suit: Suit.values()){
            for (Value value: Value.values()){
                cs.add(new Card(suit, value));
            }
        }
        Deck.shuffle(cs);
        cards = new LinkedList<>(cs);
    }

    public Queue<Card> getCards(){
        return this.cards;
    }

    public Card getNextCard(){
        return cards.poll();
    }

    public static void shuffle(List<Card> cards){
        Collections.shuffle(cards);
    }

}
