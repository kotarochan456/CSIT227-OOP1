package Game;

public class Skill {
    private String name;
    private int damage;
    private int cooldown;
    private int currentCooldown;
    private boolean isHealing;

    public Skill(String name, int damage, int cooldown) {
        this(name, damage, cooldown, false);
    }

    public Skill(String name, int damage, int cooldown, boolean isHealing) {
        this.name = name;
        this.damage = damage;
        this.cooldown = cooldown;
        this.isHealing = isHealing;
        this.currentCooldown = 0;
    }

    public int useSkill() {
        if (currentCooldown > 0) {
            System.out.println(name + " is on cooldown for " + currentCooldown + " more turns!");
            return 0;
        }

        currentCooldown = cooldown;

        if (isHealing) {
            System.out.println("✨ Used " + name + "! Healed allies for " + damage + " HP!");
            return -damage;
        } else {
            System.out.println("🔥 Used " + name + "! Dealt " + damage + " damage!");
            return damage;
        }
    }

    public void reduceCooldown() {
        if (currentCooldown > 0) currentCooldown--;
    }

    public String getName() { return name; }
    public int getDamage() { return damage; }
    public boolean isHealing() { return isHealing; }

    public String getStatus() {
        return name + (currentCooldown > 0 ? " (CD: " + currentCooldown + ")" : " (Ready)");
    }
}
