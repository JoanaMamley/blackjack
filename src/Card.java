import enums.*;

public class Card {

    private Suit suit;
    private Value value;
    private int points;

    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public int getPoint(){
        return value.getPointValue();
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value='" + value + '\'' +
                ", points=" + value.getPointValue() +
                '}';
    }
}
