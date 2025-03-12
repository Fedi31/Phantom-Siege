package model;

//Tower rappresenta la torre che può attaccare i nemici se si trovano nel suo raggio.
public class Tower {
	    private String name;
	    private Position position;
	    private int cost;
	    private int attackPower;
	    private int range;
	    private int upgradeLevel;

	    public Tower(String name, int cost, int attackPower, int range, Position position) {
	        this.name = name;
	        this.position = position;
	        this.cost = cost;
	        this.attackPower = attackPower;
	        this.range = range;
	        this.upgradeLevel = 1;
	    }

	    public void upgrade() {
	        if (upgradeLevel < 5) {
	            attackPower += 10; // Incremento dell'attacco
	            range += 5; // Incremento del raggio
	            upgradeLevel++;
	        }
	    }

	    public void attack(Enemy enemy) {
	        if (isInRange(enemy)) {
	            enemy.takeDamage(attackPower);
	        }
	    }

	    private boolean isInRange(Enemy enemy) {
	        // Calcola se il nemico è all'interno del raggio della torre
	        return true; // Logica da implementare
	    }

	    public String toString() {
	        return "Tower{" +
	                "name='" + name + '\'' +
	                ", position=" + position +
	                ", cost=" + cost +
	                ", attackPower=" + attackPower +
	                ", range=" + range +
	                ", upgradeLevel=" + upgradeLevel +
	                '}';
	    }
	    // Getters and Setters
}
