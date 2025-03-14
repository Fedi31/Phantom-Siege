package model;

import java.util.List;

//Classe che rappresenta un nemico
class Enemy {
    private String name;
    private int health;
    private int speed;
    private List<Position> path;
    private int pathIndex;
    private Position currentPosition;

    public Enemy(String name, int health, int speed, List<Position> path) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.path = path;
        this.pathIndex = 0;
        this.currentPosition = path.get(pathIndex);
    }

    public void move() {
        if (pathIndex < path.size() - 1) {
            pathIndex++;
            currentPosition = path.get(pathIndex);
        }
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            die();
        }
    }

    public void die() {
        System.out.println(name + " is defeated!");
    }

    public boolean reachedEnd() {
        return pathIndex == path.size() - 1;
    }

    public String getName() {
        return name;
    }
}



