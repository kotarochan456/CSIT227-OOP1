import java.util.InputMismatchException;
import java.util.Scanner;

package Game;
import java.util.*;

public class Game {

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Welcome to the Turn-Based Game! ===");

        try {
            Player hero = chooseCharacter();
            Enemy enemy = new Enemy("Kagubatang Halimaw", 300);
            System.out.println("\n⚔ Battle Start! ⚔");
            battle(hero, enemy);
        } catch (InvalidChoiceException e) {
            System.out.println("Error: " + e.getMessage());
        }
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
            case 3 -> player = new Player("Serenya", 240,
                    new Skill("Moonlit", 25, 0),
                    new Skill("Radiance (Heal 50%)", 0, 1, true),
                    new Skill("Eclipse (Heal All 30%)", 0, 4, true));
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

    public void battle(Player hero, Enemy enemy) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        while (hero.getHp() > 0 && enemy.getHp() > 0) {
            System.out.println("\n===== NEW TURN =====");
            System.out.println(hero.getName() + ": " + hero.getHp() + " HP");
            System.out.println(enemy.getName() + ": " + enemy.getHp() + " HP");

            hero.displayInfo();
            System.out.print("\nChoose skill (1-3): ");
            int choice = input.nextInt();
            Skill chosenSkill = null;

            if (choice >= 1 && choice <= 3)
                chosenSkill = hero.previewSkill(choice) != 0 ? hero.useSkill(choice) != 0 ? hero.useSkill(choice) > 0 ? null : null : null : null;

            int damage = hero.useSkill(choice);

            // Serenya’s special healing logic
            if (hero.getName().equals("Serenya")) {
                switch (choice) {
                    case 2 -> hero.healPercent(50); // Radiance
                    case 3 -> hero.healPercent(30); // Eclipse
                    default -> enemy.takeDamage(damage);
                }
            } else {
                enemy.takeDamage(damage);
            }

            if (enemy.getHp() <= 0) {
                System.out.println("\n🎉 " + hero.getName() + " defeated " + enemy.getName() + "!");
                break;
            }

            // Enemy turn
            int enemyDamage = random.nextInt(20) + 10;
            System.out.println(enemy.getName() + " attacks and deals " + enemyDamage + " damage!");
            hero.takeDamage(enemyDamage);

            if (hero.getHp() <= 0) {
                System.out.println("\n💀 " + hero.getName() + " has fallen in battle!");
                break;
            }

            // Reduce skill cooldowns
            hero.reduceCooldowns();
        }
    }
}
