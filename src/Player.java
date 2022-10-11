import enums.PlayerState;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private PlayerState state = PlayerState.InPlay;
    private String name;

    public Player(){
        this(Player.generateDefaultName());
    }

    public Player(String name){
        this.name = name;
    }

    public static String generateDefaultName(){
        return "Player-" + UUID.randomUUID();
    }

    public List<Card> getHand(){
        return this.hand;
    }

    public void setState(PlayerState state){
        this.state = state;
    }

    public PlayerState getState(){
        return this.state;
    }

    public void addCardToHand(Card card){
        hand.add(card);
        if(this.getHandTotalPoints()>21){
            this.setState(PlayerState.Ejected);
        }
    }

    public int getHandTotalPoints(){
        return hand.stream().mapToInt(Card::getPoint).sum();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
