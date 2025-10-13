public abstract class Entity implements BattleParticipant {
        protected String name;
        protected int hp;

        public Entity(String name, int hp) {
            this.name = name;
            this.hp = hp;
        }

        public void takeDamage(int damage) {
            hp -= damage;
            if (hp < 0) hp = 0;
            System.out.println(name + " takes " + damage + " damage. Remaining HP: " + hp);
        }

        public String getName() { return name; }
        public int getHp() { return hp; }
    }


