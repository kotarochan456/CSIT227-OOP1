package Game;

public interface BattleParticipant {
    void takeDamage(int damage);
    int useSkill(int choice);
    void reduceCooldowns();
    String getName();
    int getHp();
}
