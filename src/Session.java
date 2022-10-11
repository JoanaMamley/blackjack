import enums.SessionState;

import java.util.ArrayList;
import java.util.List;

public class Session {

    //    Player players
    private List<Player> players = new ArrayList<>();
    private SessionState state = SessionState.Started;
    private Deck deck;

    public Session(int playerCount){
        this.deck = new Deck();
        for (int i=0; i<playerCount; i++){
            this.players.add(new Player());
        }

    }

    public void setState(SessionState state){
        this.state = state;
    }

    public SessionState getState(){
        return this.state;
    }

    public void start(){
        this.setState(SessionState.Started);
    }

}
