import java.util.ArrayList;


public class ComputerGameBox {
    private ArrayList<ComputerGame> obj = new ArrayList<ComputerGame>();

    public ComputerGameBox(ArrayList<ComputerGame> obj) {
        setObj(new ArrayList<ComputerGame>(obj));
    }

    public ComputerGameBox() {
    }

    public ArrayList<ComputerGame> getObj() {
        return obj;
    }


    public void setObj(ArrayList<ComputerGame> obj) {
        this.obj = obj;
    }

    public ComputerGame getGame(String name) {
        name = name.toLowerCase();
        for (ComputerGame game : obj) {
            if (game.getSpec().getName().equals(name)) {
                return game;
            }
        }
        return null;
    }

    public void addGame(ComputerGame game) {

        obj.add(game);


    }

    public ArrayList<ComputerGame> search(ComputerGameParams searchPar) {
        ArrayList<ComputerGame> matchingGames = new ArrayList<ComputerGame>();

        for (ComputerGame game : obj) {
            if (game.getSpec().matches(searchPar)) {
                matchingGames.add(game);
            }
        }
        return matchingGames;


    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("");
        for (ComputerGame scg : getObj()) {
            line.append(scg.toString()).append("\n");
        }
        return line.toString();
    }
}

