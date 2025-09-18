import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Team liverpool = new Team("Liverpool", 90);
        liverpool.addPlayer(new Player("Alisson", 89, 0));
        liverpool.addPlayer(new Player("Jeremie Frimpong", 83, 0));
        liverpool.addPlayer(new Player("Ibrahima Konate", 86, 0));
        liverpool.addPlayer(new Player("Virgil Van Dijk", 90, 0));
        liverpool.addPlayer(new Player("Milos Kerkez", 83, 0));
        liverpool.addPlayer(new Player("Ryan Gravenberch", 85, 0));
        liverpool.addPlayer(new Player("Dominik Szoboszlai", 84, 0));
        liverpool.addPlayer(new Player("Florian Wirtz", 88, 0));
        liverpool.addPlayer(new Player("Cody Gakpo", 84, 0));
        liverpool.addPlayer(new Player("Mohamed Salah", 91, 0));
        liverpool.addPlayer(new Player("Alexandar Isak", 87, 0));

        Team bayernMunich = new Team("Bayern Munich", 110);
        bayernMunich.addPlayer(new Player("Manuel Neuer", 87, 0));
        bayernMunich.addPlayer(new Player("Sacha Boey", 80, 0));
        bayernMunich.addPlayer(new Player("Jonathan Tah", 87, 0));
        bayernMunich.addPlayer(new Player("Dayot Upamecano", 84, 0));
        bayernMunich.addPlayer(new Player("Alphonso Davies", 84, 0));
        bayernMunich.addPlayer(new Player("Joshua Kimmich", 87, 0));
        bayernMunich.addPlayer(new Player("Leon Goretzka", 85, 0));
        bayernMunich.addPlayer(new Player("Michael Olise", 85, 0));
        bayernMunich.addPlayer(new Player("Kingsley Coman", 84, 0));
        bayernMunich.addPlayer(new Player("Jamal Musiala", 88, 0));
        bayernMunich.addPlayer(new Player("Harry Kane", 90, 0));

        Team barcelona = new Team("Barcelona", 85);
        barcelona.addPlayer(new Player("Marc Andre Ter Stegen", 85, 0));
        barcelona.addPlayer(new Player("Jules Kounde", 88, 0));
        barcelona.addPlayer(new Player("Pau Cubarsi", 85, 0));
        barcelona.addPlayer(new Player("Ronald Araujo", 82, 0));
        barcelona.addPlayer(new Player("Alejandro Balde", 86, 0));
        barcelona.addPlayer(new Player("Pedri", 91, 0));
        barcelona.addPlayer(new Player("Frenkie De Jong", 87, 0));
        barcelona.addPlayer(new Player("Dani Olmo", 85, 0));
        barcelona.addPlayer(new Player("Lamine Yamal", 90, 0));
        barcelona.addPlayer(new Player("Raphinha", 91, 0));
        barcelona.addPlayer(new Player("Robert Lewandowski", 85, 0));

        Team interMilan = new Team("Inter Milan", 70);
        interMilan.addPlayer(new Player("Yann Sommer", 87, 0));
        interMilan.addPlayer(new Player("Yann Bisseck", 83, 0));
        interMilan.addPlayer(new Player("Francesco Acerbi", 83, 0));
        interMilan.addPlayer(new Player("Alessandro Bastoni", 88, 0));
        interMilan.addPlayer(new Player("Denzel Dumfries", 83, 0));
        interMilan.addPlayer(new Player("Federico Dimarco", 84, 0));
        interMilan.addPlayer(new Player("Nicolo Barella", 87, 0));
        interMilan.addPlayer(new Player("Hakan Calhanoglu", 84, 0));
        interMilan.addPlayer(new Player("Henrikh Mkhitaryan", 82, 0));
        interMilan.addPlayer(new Player("Lautaro Martinez", 88, 0));
        interMilan.addPlayer(new Player("Marcus Thuram", 86, 0));

        System.out.println("Choose a team!");
        System.out.println("1 - Liverpool");
        System.out.println("2 - Bayern Munich");
        System.out.println("3 - Barcelona");
        System.out.println("4 - Inter Milan");

        int choice = scnr.nextInt();

        Team userTeam = null;

        switch (choice) {
            case 1:
                userTeam = liverpool;
                System.out.println("You Chose Liverpool!");
                break;
            case 2:
                userTeam = bayernMunich;
                System.out.println("You Chose Bayern Munich!");
                break;
            case 3:
                userTeam = barcelona;
                System.out.println("You Chose Barcelona!");
                break;
            case 4:
                userTeam = interMilan;
                System.out.println("You Chose Inter Milan!");
                break;
            default:
                System.out.println("Invalid Choice! Defaulting to Team #1: Liverpool!");
                userTeam = liverpool;
                break;
        }

        GameManager gm = new GameManager();
        gm.transferWindow(userTeam);

        //Test Group Stage
        System.out.println("\n--- GROUP STAGE STARTING ---");

        //Put 4 teams into a group
        ArrayList<Team> groupTeams = new ArrayList<>();
        groupTeams.add(liverpool);
        groupTeams.add(bayernMunich);
        groupTeams.add(barcelona);
        groupTeams.add(interMilan);

        Group groupA = new Group("Group A", groupTeams);

        //Play the group stage (home + away matches)
        groupA.playGroupStage();

        //show the table
        groupA.printStandings();

    }
}