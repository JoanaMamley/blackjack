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

    }

    public void setState(SessionState state){
        this.state = state;
    }

    public SessionState getState(){
        return this.state;
    }



    public void setCurrentPlayer(){
        System.out.println(players);
        if(!it.hasNext()){
            it = players.iterator();
        }
        this.currentPlayer = it.next();

        for(int i=0; i< 10; i++){
            System.out.println(this.currentPlayer);
        }

    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void start(){
        this.setState(SessionState.Started);
        this.setCurrentPlayer();
    }

}
