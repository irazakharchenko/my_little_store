

public class ComputerGame {

    private int id;
    private ComputerGameParams params;


    public ComputerGame(ComputerGameParams param) {
        params = new ComputerGameParams(param);
    }

    public ComputerGameParams getSpec() {
        return params;
    }


    public int getId() {
        return id;
    }

    public ComputerGame setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Game with " + params.toString();
    }
}