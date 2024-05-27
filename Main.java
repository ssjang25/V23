import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for person's name
        System.out.println("Please enter your valentine's name:");

        String valentine = scanner.nextLine();

        createGUI newGUI = new createGUI();

        newGUI.startUp(valentine);
    }
}