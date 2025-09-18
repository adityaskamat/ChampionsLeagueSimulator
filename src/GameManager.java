import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public <E> String returnListAsString(ArrayList<E> list) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
            if (i < list.size() - 1) {
                result += "\n";
            }
        }
        return result;
    }

    public void transferWindow(Team userTeam) {
        Scanner scnr = new Scanner(System.in);

        ArrayList<Player> availablePlayers = new ArrayList<>();
        availablePlayers.add(new Player("Nico Williams", 85, 75));
        availablePlayers.add(new Player("Julian Alvarez", 85, 80));
        availablePlayers.add(new Player("Vitinha", 88, 80));
        availablePlayers.add(new Player("Matthijs De Ligt", 82, 60));
        availablePlayers.add(new Player("Eduardo Camavinga", 84, 70));
        availablePlayers.add(new Player("Theo Hernandez", 85, 85));
        availablePlayers.add(new Player("Phil Foden", 85, 75));
        availablePlayers.add(new Player("Trent Alexander-Arnold", 86, 80));
        availablePlayers.add(new Player("Frenkie De Jong", 85, 70));

        while (userTeam.getBudget() > 0) {
            System.out.println("Budget: " + userTeam.getBudget() + "\n" + "Squad: " + returnListAsString(userTeam.getSquad()));

            System.out.println();
            System.out.println();

            System.out.println("---------- TRANSFER PORTAL ----------");

            for (int i = 0; i < availablePlayers.size(); i++) {
                System.out.println((i+1) + " - " + availablePlayers.get(i).getName() + ", Overall: " + availablePlayers.get(i).getOverall() + ", Cost: " + availablePlayers.get(i).getCost());
            }

            System.out.println();

            System.out.println("If you want to sign a player, choose the corresponding number. If you don't want to, type \"done\"");
            String userInput = scnr.next();

            if (isInteger(userInput) == true) {
                int choice = Integer.parseInt(userInput) - 1;

                if (choice >= 0 && choice < availablePlayers.size()) {
                    Player selectedPlayer = availablePlayers.get(choice);
                    if (userTeam.getBudget() >= selectedPlayer.getCost()) {
                        userTeam.addPlayer(selectedPlayer);
                        availablePlayers.remove(selectedPlayer);
                        System.out.println(selectedPlayer.getName() + " signed!");
                    } else {
                        System.out.println("You cannot afford to sign " + selectedPlayer.getName());
                    }
                }
            } else if (userInput.equalsIgnoreCase("done")) {
                break;
            }
            else {
                System.out.println("Invalid choice. Please enter a number or type \"done\"");
            }

        }//end while loop
        System.out.println("Transfer Window Closed! Final Squad: " + returnListAsString(userTeam.getSquad()));
    }//end transferWindow
}//end class
