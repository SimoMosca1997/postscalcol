import java.util.Scanner;

public class Calcolatore {
    public static void main(String[] args) {
        // Creiamo un oggetto Scanner per leggere l'input
        Scanner scanner = new Scanner(System.in);

        // Chiediamo all'utente di inserire i valori per Engagement, Follower e SixMax
        System.out.print("Inserisci l'Engagement: ");
        double engagement = scanner.nextDouble();

        System.out.print("Inserisci il numero di Follower: ");
        int follower = scanner.nextInt();

        System.out.print("Inserisci il valore di SixMax: ");
        double sixMax = scanner.nextDouble();

        // Formula 1: calcolare Reach
        double reach = (engagement / sixMax) * follower;

        // Formula 2: calcolare EMV
        double emv = reach * 0.0325;

        // Formula 3: calcolare ReachH
        double reachH = 0.30 * follower;

        // Stampiamo i risultati
        System.out.println("Reach: " + reach);
        System.out.println("EMV: " + emv);
        System.out.println("ReachH: " + reachH);

        // Chiudiamo lo scanner per evitare memory leaks
        scanner.close();
    }
}
