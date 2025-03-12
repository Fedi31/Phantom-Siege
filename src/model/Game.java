package model;

import java.util.ArrayList;
import java.util.List;

//Game gestisce la logica del gioco e il movimento dei nemici.
public class Game {
	    private Map map;
	    private List<Enemy> enemies;
	    private List<Tower> towers;

	    public Game(Map map) {
	        this.map = map;
	        this.enemies = new ArrayList<>();
	        this.towers = new ArrayList<>();
	    }

	    public void addEnemy(Enemy enemy) {
	        enemies.add(enemy);
	    }

	    public void addTower(Tower tower) {
	        towers.add(tower);
	    }

	    public void update() {
	        // Aggiorna la posizione dei nemici
	        for (Enemy enemy : enemies) {
	            enemy.move();
	            // Verifica se i nemici hanno raggiunto l'obiettivo
	            if (enemy.reachedEnd()) {
	                System.out.println("Nemico ha raggiunto l'obiettivo!");
	            }
	        }

	        // Controlla le torri e se possono attaccare i nemici
	        for (Tower tower : towers) {
	            for (Enemy enemy : enemies) {
	                tower.attack(enemy);
	            }
	        }
	    }

	    public void printGameState() {
	        // Visualizza lo stato attuale del gioco (posizioni torri, nemici, ecc.)
	        System.out.println("Mappa: " + map.getName());
	        for (Tower tower : towers) {
	            System.out.println("Torre: " + tower);
	        }
	        for (Enemy enemy : enemies) {
	            System.out.println("Nemico: " + enemy.getCurrentPosition());
	        }
	    }
}

