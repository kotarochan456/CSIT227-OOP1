import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private String chosenMap;

    public void startGame() {
        System.out.println("==================================");
        System.out.println("\t\tINHERITOR’S RIFT");
        System.out.println("==================================");
        System.out.printf("\n\tIn the year 30XX in the country of Kalerios, a sudden rift called the “Singularity” has opened," +
                "\n\tunleashing unknown mystical creatures to the world. Ever since that day, more rifts have opened," +
                "\n\tdestroying everything they see, including humanity. In the struggle to fight back," +
                "\n\thumanity later discovered the power to destroy and seal the rifts. “Inheritors”," +
                "\n\tthe chosen individuals who have awakened their powers, can wield forgotten mystic arts gained " +
                "\n\tfrom ancient spirits and have the power to challenge the mystical creatures." +
                "\n\tYou (player) will lead a group of inheritors to destroy all enemies to seal the rift.\n");

        try {
            chooseMap();
            System.out.println("\nPLAYER 1, choose your character:");
            Player player1 = chooseCharacter();

            System.out.println("\nPLAYER 2, choose your character:");
            Player player2 = chooseCharacter();

            startBattle(player1, player2);
        } catch (InvalidChoiceException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Restarting game...\n");
            startGame(); // restart safely
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }


    public void chooseMap() throws InvalidChoiceException {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        try {
            System.out.println("\nChoose your battlefield:");
            System.out.println("1. The Whispering Forest (Kagubatang Alitaptap)");
            System.out.println("2. The Molten Caverns (Yungib ng Apoy)");
            System.out.println("3. The Abyssal Coast (Dalampasigan ng Multo)");
            System.out.print("Enter choice (1-3): ");
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidChoiceException("Invalid input type. Please enter a number (1-3).");
        }

        switch (choice) {
            case 1 -> chosenMap = "The Whispering Forest";
            case 2 -> chosenMap = "The Molten Caverns";
            case 3 -> chosenMap = "The Abyssal Coast";
            default -> throw new InvalidChoiceException("Invalid map choice! Please choose between 1-3.");
        }

        System.out.println("You have chosen: " + chosenMap);
    }

    public Player chooseCharacter() throws InvalidChoiceException {
        Scanner input = new Scanner(System.in);
        int choice;

        try {
            System.out.println("\n===== CHARACTER SELECTION =====");
            System.out.println("1: Aurelia Amihan (Attacker)");
            System.out.println("2: Daeneks Landral (Defender)");
            System.out.println("3: Serenya (Utility)");
            System.out.println("4: Targaryen Sikat’thar (Attacker)");
            System.out.println("5: Nyx Silabryn (Controller)");
            System.out.print("Choose your Character (1-5): ");
            choice = input.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidChoiceException("Invalid input type. Please enter a number (1-5).");
        }

        Player player;
        switch (choice) {
            case 1 -> player = new Player("Aurelia Amihan", 250,
                    new Skill("Zephyr Rend", 30, 1),
                    new Skill("Veil of Tempest", 35, 2),
                    new Skill("Winged Ascent (AOE)", 50, 4));
            case 2 -> player = new Player("Daeneks Landral", 350,
                    new Skill("Heavy Shield", 10, 0),
                    new Skill("Ground Splitter (AOE)", 25, 3),
                    new Skill("Protector", 40, 5));
            case 3 -> player = new Player("Serenya", 230,
                    new Skill("Moonlit", 25, 1),
                    new Skill("Radiance", 0, 3),
                    new Skill("Eclipse", 0, 4));
            case 4 -> player = new Player("Targaryen Sikat’thar", 260,
                    new Skill("Inferno", 35, 1),
                    new Skill("Firestorm (AOE)", 43, 2),
                    new Skill("Flame of Ifrit (AOE)", 60, 4));
            case 5 -> player = new Player("Nyx Silabryn", 250,
                    new Skill("Disorient", 20, 1),
                    new Skill("Murmur", 35, 2),
                    new Skill("Rewind", 0, 3));
            default -> throw new InvalidChoiceException("Invalid character choice! Please choose between 1-5.");
        }

        player.displayInfo();
        return player;
    }

    public void startBattle(Player player1, Player player2) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n===== BATTLE START =====");
        System.out.println(player1.getName() + " (Player 1) VS " + player2.getName() + " (Player 2)");
        System.out.println("=======================================");

        int turn = 1;
        while (player1.getHp() > 0 && player2.getHp() > 0) {
            System.out.println("\n========= TURN " + turn + " =========");

            // ===== Player 1's Turn =====
            System.out.println("\n🟦 " + player1.getName() + "'s Turn!");
            player1.displayInfo();
            System.out.print("Choose a skill (1-3): ");

            int skillChoice1;
            try {
                skillChoice1 = input.nextInt();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input! Turn skipped.");
                skillChoice1 = -1;
            }

            int damage1 = player1.useSkill(skillChoice1);
            player2.takeDamage(damage1);
            System.out.println("\n💥 " + player1.getName() + " dealt " + damage1 + " damage to " + player2.getName() + "!");
            System.out.println(player2.getName() + "'s HP: " + player2.getHp());

            if (player2.getHp() <= 0) {
                System.out.println("\n💀 " + player2.getName() + " has been defeated!");
                break;
            }

            // ===== Player 2's Turn =====
            System.out.println("\n🟥 " + player2.getName() + "'s Turn!");
            player2.displayInfo();
            System.out.print("Choose a skill (1-3): ");

            int skillChoice2;
            try {
                skillChoice2 = input.nextInt();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input! Turn skipped.");
                skillChoice2 = -1;
            }

            int damage2 = player2.useSkill(skillChoice2);
            player1.takeDamage(damage2);
            System.out.println("\n💥 " + player2.getName() + " dealt " + damage2 + " damage to " + player1.getName() + "!");
            System.out.println(player1.getName() + "'s HP: " + player1.getHp());

            if (player1.getHp() <= 0) {
                System.out.println("\n💀 " + player1.getName() + " has been defeated!");
                break;
            }

            // ===== End of Turn Status =====
            player1.reduceCooldowns();
            player2.reduceCooldowns();

            System.out.println("\n--- End of Turn " + turn + " ---");
            System.out.println(player1.getName() + " HP: " + player1.getHp());
            System.out.println(player2.getName() + " HP: " + player2.getHp());
            System.out.println("=======================================");

            turn++;
        }

        System.out.println("\n===== BATTLE ENDED =====");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
