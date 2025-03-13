package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Game gestisce la logica del gioco e il movimento dei nemici.
public class Game {
    private Map map;
    private List<Enemy> enemies;
    private List<Tower> towers;
    private Economy economy;
    private int lives;

    public Game(Map map) {
        this.map = map;
        this.enemies = new ArrayList<>();
        this.towers = new ArrayList<>();
        this.economy = new Economy();
        this.lives = 20; // Numero di vite iniziali
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void addTower(Tower tower, Position position) {
        if (economy.spendCoins(tower.getCost())) {
            tower.setPosition(position);
            towers.add(tower);
            System.out.println("Tower placed: " + tower.getName() + " at " + position);
        } else {
            System.out.println("Not enough coins to place: " + tower.getName());
        }
    }

    public void update() {
        // Aggiorna la posizione dei nemici
        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            enemy.move();

            // Verifica se i nemici hanno raggiunto l'obiettivo
            if (enemy.reachedEnd()) {
                System.out.println(enemy.getName() + " has reached the objective!");
                lives--;
                if (lives <= 0) {
                    System.out.println("Game Over! You have lost all lives.");
                }
                enemyIterator.remove();
            }
        }

        // Controlla le torri e se possono attaccare i nemici
        for (Tower tower : towers) {
            for (Enemy enemy : enemies) {
                if (tower.isInRange(enemy)) {
                    tower.attack(enemy);
                    if (enemy.getHealth() <= 0) {
                        economy.earnCoins(10);
                        System.out.println(enemy.getName() + " defeated! Coins earned: 10");
                        enemyIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    public void printGameState() {
        // Visualizza lo stato attuale del gioco (posizioni torri, nemici, ecc.)
        System.out.println("Mappa: " + map.getName());
        System.out.println("Coins: " + economy.getCoins());
        System.out.println("Lives: " + lives);
        
        for (Tower tower : towers) {
            System.out.println("Torre: " + tower.getName() + " | Posizione: " + tower.getPosition() + " | Livello: " + tower.getUpgradeLevel());
        }
        for (Enemy enemy : enemies) {
            System.out.println("Nemico: " + enemy.getName() + " | Posizione: " + enemy.getCurrentPosition() + " | Salute: " + enemy.getHealth());
        }
    }

    public boolean isGameOver() {
        return lives <= 0;
    }
}