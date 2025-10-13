public class Skill {
    private String name;
    private int damage;
    private int cooldown;
    private int currentCooldown;

    public Skill(String name, int damage, int cooldown) {
        this.name = name;
        this.damage = damage;
        this.cooldown = cooldown;
        this.currentCooldown = 0;
    }

    public int useSkill() {
        if (currentCooldown > 0) {
            System.out.println(name + " is on cooldown for " + currentCooldown + " more turns!");
            return 0;
        }
        currentCooldown = cooldown;
        System.out.println("Used " + name + "! Dealt " + damage + " damage!");
        return damage;
    }

    public void reduceCooldown() {
        if (currentCooldown > 0) {
            currentCooldown--;
        }
    }
    public String getStatus() {
        if (currentCooldown == 0) {
            return name + " (Ready!)";
        } else {
            return name + " (CD: " + currentCooldown + ")";
        }
    }


    public String getName() { return name; }
    public int getDamage() { return damage; }
    public int getCooldown() { return cooldown; }
}
