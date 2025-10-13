import java.util.ArrayList;
import java.util.List;

public class Enemy {
    private String name;
    private int hp;
    private List<Skill> skills = new ArrayList<>();

    public Enemy(String name, int level) {
        this.name = name;
        this.hp = 50 + (level * 10);
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public int useSkill(int index) {
        if (index < 1 || index > skills.size()) {
            System.out.println(name + " fumbles its attack!");
            return 0;
        }
        int damage = skills.get(index - 1).useSkill();
        System.out.println(name + " used " + skills.get(index - 1).getName() + "!");
        return damage;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
        System.out.println(name + " took " + dmg + " damage! Remaining HP: " + hp);
    }


    public void reduceCooldowns() {
        for (Skill s : skills) s.reduceCooldown();
    }

    public int getHp() { return hp; }
    public String getName() { return name; }
}
