package model;

import java.util.ArrayList;
import java.util.List;
//Classe che rappresenta una mappa con un percorso predefinito
class Map {
    private String name;
    private List<Position> path;

    public Map(String name) {
        this.name = name;
        this.path = new ArrayList<>();
    }

    public void addPath(Position position) {
        path.add(position);
    }

    public List<Position> getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
}
