import enums.PlayerState;
import enums.SessionState;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Session {

    //    Player players
    private List<Player> players = new ArrayList<>();
    private SessionState state = SessionState.Started;
    private Iterator<Player> it;
    private Player currentPlayer;
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

        if (!this.checkWinner()){
            this.setCurrentPlayer();
        } else {
            this.setState(SessionState.Ended);
        }

    }

    public boolean checkWinner(){
        if(this.players.stream().filter(player -> player.getHandTotalPoints()==21).count() > 1 ){
            return true;
        } else if ( this.players.stream().filter(player -> player.getState()==PlayerState.InPlay).count() < 2  ) {
            return true;
        }
        return false;
    }

    public Player getWinner(){
        return this.currentPlayer;
//        return this.players.stream().filter(player -> player.getHandTotalPoints()==21);
    }

}
