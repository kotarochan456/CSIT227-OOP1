package Game;

public abstract class Entity implements BattleParticipant {
    protected String name;
    protected int hp;
    protected int maxHp;

    public Entity(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp; // Set max HP to initial HP by default
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}


