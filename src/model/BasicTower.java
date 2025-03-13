package model;

// Classe che rappresenta una torre difensiva
public class BasicTower implements Tower{
    private String name;
    private int cost;
    private int attackPower;
    private int range;
    private int upgradeLevel;
    private Position position;

    public BasicTower(String name, int cost, int attackPower, int range) {
        this.name = name;
        this.cost = cost;
        this.attackPower = attackPower;
        this.range = range;
        this.upgradeLevel = 1;
        this.position = null;
    }

    public void upgrade() {
        if (upgradeLevel < 5) {
            attackPower += 10;
            range += 5;
            upgradeLevel++;
        }
    }

    public void attack(Enemy enemy) {
        if (isInRange(enemy)) {
            enemy.takeDamage(attackPower);
        }
    }

    public boolean isInRange(Enemy enemy) {
        if (position == null || enemy.getCurrentPosition() == null) return false;
        int dx = position.getX() - enemy.getCurrentPosition().getX();
        int dy = position.getY() - enemy.getCurrentPosition().getY();
        return Math.sqrt(dx * dx + dy * dy) <= range;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getUpgradeLevel() {
        return upgradeLevel;
    }
}
