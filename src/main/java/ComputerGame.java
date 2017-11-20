

public class ComputerGame {
    private static int generalId = 0;
    private static int id = ComputerGame.generalId++;
    private ComputerGameParams params;


    public ComputerGame(ComputerGameParams param) {
        params = new ComputerGameParams(param);
    }

    public ComputerGameParams getSpec() {
        return params;
    }

    public static int getGeneralId() {
        return generalId;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Game with " + params.toString();
    }
}