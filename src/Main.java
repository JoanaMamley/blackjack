import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int playerCount;

        do {
            System.out.println("Enter number of players, from 2-6");
            playerCount = scanner.nextInt();
        } while (playerCount <= 1 && playerCount>6);

        Session session = new Session(playerCount);
        session.start();


    }
}