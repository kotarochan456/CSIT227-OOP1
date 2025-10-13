import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int hp;
    private List<Skill> skills = new ArrayList<>();

    // ✅ Default constructor
    public Player(String name) {
        this.name = name;
        this.hp = 100;
    }

    // ✅ Added constructor that matches Game.java calls
    public Player(String name, int hp, Skill skill1, Skill skill2, Skill skill3) {
        this.name = name;
        this.hp = hp;
        this.skills.add(skill1);
        this.skills.add(skill2);
        this.skills.add(skill3);
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void displayInfo() {
        System.out.println("\n=== " + name + " ===");
        System.out.println("HP: " + hp);
        System.out.println("Skills:");
        for (int i = 0; i < skills.size(); i++) {
            Skill s = skills.get(i);
            System.out.println((i + 1) + ". " + s.getStatus() + " | Damage: " + s.getDamage());
        }
    }


    public int useSkill(int index) {
        if (index < 1 || index > skills.size()) {
            System.out.println(name + " fumbles the attack!");
            return 0;
        }
        Skill skill = skills.get(index - 1);
        int dmg = skill.useSkill();
        if (dmg > 0)
            System.out.println("Used " + skill.getName() + "! Dealt " + dmg + " damage!");
        return dmg;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
    }

    public void reduceCooldowns() {
        for (Skill s : skills) s.reduceCooldown();
    }

    public int getHp() { return hp; }
    public String getName() { return name; }
}
