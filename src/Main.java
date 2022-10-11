import enums.SessionState;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int playerCount;

        do {
            System.out.println("Enter number of players, from 2-6");
            playerCount = scanner.nextInt();
        } while (playerCount <= 1 || playerCount>6);

        Session session = new Session(playerCount);
        session.start();

        while (session.getState() != SessionState.Ended){
            System.out.println("thinking...");
            session.move();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(session.getWinner()+" has won the game, point: "+session.getWinner().getHandTotalPoints());

    }
}