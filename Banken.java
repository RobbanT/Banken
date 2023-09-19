import java.util.Scanner;

public class Banken {
    public static void main(String[] args) {
        int balance = 0;
        int choice = 0;
        Scanner input = new Scanner(System.in);

        do {
            printMenu();
            if (checkIntInput(input)) {
                choice = input.nextInt();
                if (choice > 0 && choice < 5) {
                    switch (choice) {
                        case 1:
                            printBalance(balance);
                            break;
                        case 2:
                            balance += addBalance(input);
                            break;
                        case 3:
                            balance = removeBalance(input, balance);
                            break;
                        case 4:
                            endProgram();
                            break;
                    }
                } else {
                    System.out.println("\nFelaktig input. Ange bara ett heltal mellan 1-4!");
                }
            }
            input = new Scanner(System.in);
        } while (choice != 4);
    }

    // Skriver ut programmets meny.
    public static void printMenu() {
        System.out.println("\n-------Banken-------");
        System.out.println("Ange ett av följande alternativ (1-4):");
        System.out.println("1. Se saldo");
        System.out.println("2. Sätt in pengar");
        System.out.println("3. Ta ut pengar");
        System.out.println("4. Avsluta");
        System.out.print("Alternativ: ");
    }

    // Kontrollerar så att användaren bara matar in heltal.
    public static boolean checkIntInput(Scanner input) {
        if (input.hasNextInt()) {
            return true;
        } else {
            System.out.println("\nFelaktig input. Ange bara heltal!");
            return false;
        }
    }

    // Skriver ut saldo.
    public static void printBalance(int balance) {
        System.out.println("\nDitt saldo är " + balance + " kronor.");
    }

    // Lägger till pengar för vårt saldo.
    public static int addBalance(Scanner input) {
        System.out.println("\nHur mycket pengar vill du sätta in?");
        System.out.print("Insättning: ");
        return checkIntInput(input) ? input.nextInt() : 0;
    }

    // Tar bort pengar från vårt saldo.
    public static int removeBalance(Scanner input, int balance) {
        int removedBalance = 0;
        System.out.println("\nHur mycket pengar vill du ta ut?");
        System.out.print("Uttagning: ");
        if (checkIntInput(input)) {
            removedBalance = input.nextInt();
            if (balance >= removedBalance) {
                return balance - removedBalance;
            } else {
                System.out.println("\nDu försöker ta ut mer än vad du har på ditt saldo. Försök igen!");
            }
        }
        return balance;
    }

    // Avslutar programmet.
    public static void endProgram() {
        System.out.println("\nProgrammet avslutas...\n");
    }
}