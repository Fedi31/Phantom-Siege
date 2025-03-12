package model;

import java.util.ArrayList;
import java.util.List;

//Map gestisce il percorso dei nemici.
public class Map {
	    private String name;
	    private List<Position> path; // Percorso predefinito per i nemici

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

	    public Position getNextPathPosition(int index) {
	        if (index >= 0 && index < path.size()) {
	            return path.get(index);
	        }
	        return null; // Se l'indice è fuori dai limiti
	    }
}
