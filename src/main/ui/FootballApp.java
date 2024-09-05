package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

// The FootballApp class serves as the entry point for the application, managing the main menu and delegating user 
// interactions to the TournamentUI class. It provides options for creating tournaments, adding clubs and players, 
// recording match results, and viewing tournament details.

public class FootballApp {
    private static Scanner scanner = new Scanner(System.in); // read user input from the console
    private static TournamentUI tournamentUI = new TournamentUI();

    // EFFECTS: keep the tournament running until the player wants to exit
    //          while running, read the user's menu choice
    //          and execute based on the user's choice
    public void run() {
        boolean keepGoing = true;
        while (keepGoing) { 
            printMainMenu();

            int choice = getUserChoice(); 

            if (isValidChoice(choice)) {
                keepGoing = handleUserChoice(choice);
            } else {
                handleInvalidOption();
            }
        }
    }

    // EFFECTS: display the main menu that user will be using for the application
    private void printMainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Create Tournament");
        System.out.println("2. Add Club");
        System.out.println("3. Add Player to Club");
        System.out.println("4. Record Match Result");
        System.out.println("5. View Tournament Details");
        System.out.println("6. Save Tournament");
        System.out.println("7. Load Tournament");
        System.out.println("8. Exit");
        System.out.println("Choose an option: ");
    }

    // EFFECTS: return the user's choice
    private int getUserChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 8");
        }
        scanner.nextLine(); // consume newline
        return choice;
    }

    // EFFECTS: set the boundaries of a valid choice
    private boolean isValidChoice(int choice) {
        return choice >= 1 && choice <= 8;
    }

    // EFFECTS: handle invalid option
    private void handleInvalidOption() {
        System.out.println("Invalid option. Please try again!"); 
    }

    // EFFECTS: handle the user's choice
    private boolean handleUserChoice(int choice) {
        if (choice == 8) {
            System.out.println("Exiting ...");
            return false;
        }
        processUserChoice(choice);
        return true;
    }

    // EFFECTS: same effect as the handleUserChoice, but created to ensure no method exceeds 25 lines
    private void processUserChoice(int choice) {
        switch (choice) {
            case 1:
                tournamentUI.createTournament();
                break;
            case 2:
                tournamentUI.addclub();
                break;
            case 3:
                tournamentUI.addPlayerToClub();
                break;
            case 4:
                tournamentUI.recordMatchResult();
                break;
            case 5:
                tournamentUI.viewTournamentDetails();
                break;
            case 6:
                tournamentUI.saveTournament();
                break;
            case 7:
                tournamentUI.loadTournament();
                break;
        }
    }
}
