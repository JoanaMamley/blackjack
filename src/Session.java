import enums.PlayerState;
import enums.SessionState;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Session {

    //    Player players
    private List<Player> players = new ArrayList<>();
    private SessionState state = SessionState.Started;
    private Iterator<Player> it;
    private Player currentPlayer;
    Optional<Player> winner;
    private Deck deck;

    public Session(int playerCount){
        this.deck = new Deck();
        for (int i=0; i<playerCount; i++){
            this.players.add(new Player());
        }
        it = players.iterator();
        this.setCurrentPlayer();
    }

    public void setState(SessionState state){
        this.state = state;
    }

    public SessionState getState(){
        return this.state;
    }

    public void setCurrentPlayer(){
        if(!it.hasNext()){
            it = players.iterator();
        }
        this.currentPlayer = it.next();
        if (this.currentPlayer.getState() != PlayerState.InPlay){
            if(false){
                this.setCurrentPlayer();
            }
        }
    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void start(){
        this.setState(SessionState.Started);

        for (Player player : this.players){
            player.addCardToHand(this.deck.getCards().poll());
            player.addCardToHand(this.deck.getCards().poll());
        }

        this.setCurrentPlayer();
    }

    public void move(){
        System.out.println(this.getCurrentPlayer()+" your turn");

        if(this.currentPlayer.getHandTotalPoints()<17){
            System.out.println("hit me");
            this.currentPlayer.addCardToHand(this.deck.getCards().poll());
        } else if (this.currentPlayer.getHandTotalPoints()>=17 && this.currentPlayer.getHandTotalPoints()<21) {
            int control = (int) ((Math.random()*10)+1);
            if(control % 2!=0){
                System.out.println("hit me");
                this.currentPlayer.addCardToHand(this.deck.getCards().poll());
            }else {
                System.out.println("stick");
            }
        } else {
            System.out.println("bust");
        }

        System.out.println("points: "+this.currentPlayer.getHandTotalPoints());

        winner = this.checkWinner();

        if (!winner.isPresent()){
            this.setCurrentPlayer();
        } else {
            this.setState(SessionState.Ended);
        }

    }
    
    public Optional<Player> checkWinner(){
        Optional<Player> player = Optional.ofNullable(null);
        if(this.players.stream().filter(p -> p.getHandTotalPoints()==21).count() >= 1 ){
            player = this.players.stream().filter(p -> p.getHandTotalPoints()==21).findFirst();
        } else if ( this.players.stream().filter(p -> p.getState()==PlayerState.InPlay).count() < 2  ){
            player = this.players.stream().filter(p -> p.getState()==PlayerState.InPlay).findFirst();
        }
//        else if (this.players.stream().filter(p -> p.getState()==PlayerState.Ejected).count() == players.size()) {
//            player = player;
//        }
        return player;
    }

    public Player getWinner(){
        return this.winner.get();
    }

//    add deal card here

}
