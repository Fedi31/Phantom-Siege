package model;

//Classe che gestisce l'economia del giocatore
class Economy {
    private int coins;

    public Economy() {
        coins = 100;
    }

    public void earnCoins(int amount) {
        coins += amount;
    }

    public boolean spendCoins(int amount) {
        if (coins >= amount) {
            coins -= amount;
            return true;
        }
        return false;
    }

    public int getCoins() {
        return coins;
    }
}
