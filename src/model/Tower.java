package model;

//Interfaccia base per le torri
public interface Tower {
	    void upgrade();
	    void attack(Enemy enemy);
	    boolean isInRange(Enemy enemy);
	    void setPosition(Position position);
	    Position getPosition();
	    String getName();
	    int getCost();
	    int getUpgradeLevel();
}
