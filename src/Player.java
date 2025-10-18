package Game;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {
    private List<Skill> skills = new ArrayList<>();

    public Player(String name) {
        super(name, 100);
    }

    public Player(String name, int hp, Skill s1, Skill s2, Skill s3) {
        super(name, hp);
        skills.add(s1);
        skills.add(s2);
        skills.add(s3);
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void displayInfo() {
        System.out.println("\n=== " + getName() + " ===");
        System.out.println("HP: " + getHp());
        System.out.println("Skills:");
        for (int i = 0; i < skills.size(); i++) {
            Skill s = skills.get(i);
            System.out.println((i + 1) + ". " + s.getStatus() + " | Damage: " + s.getDamage());
        }
    }

    public int previewSkill(int choice) {
        if (choice < 1 || choice > skills.size()) return 0;
        Skill s = skills.get(choice - 1);
        if (s.getStatus().contains("CD:")) {
            System.out.println(s.getName() + " is on cooldown!");
            return 0;
        }
        return s.isHealing() ? -s.getDamage() : s.getDamage();
    }

    public int useSkill(int index) {
        if (index < 1 || index > skills.size()) {
            System.out.println(getName() + " fumbles the attack!");
            return 0;
        }
        Skill skill = skills.get(index - 1);
        return skill.useSkill();
    }

    public void takeDamage(int dmg) {
        setHp(getHp() - dmg);
        if (getHp() < 0) setHp(0);
    }

    public void heal(int amount) {
        setHp(getHp() + amount);
        if (getHp() > getMaxHp()) setHp(getMaxHp());
        System.out.println(getName() + " recovered " + amount + " HP! (Current HP: " + getHp() + ")");
    }

    public void healPercent(int percent) {
        int healAmount = (getMaxHp() * percent) / 100;
        setHp(getHp() + healAmount);
        if (getHp() > getMaxHp()) {
            setHp(getMaxHp());
        }
        System.out.println(getName() + " healed for " + healAmount + " HP!");
    }

    public void reduceCooldowns() {
        for (Skill s : skills) s.reduceCooldown();
    }
}
