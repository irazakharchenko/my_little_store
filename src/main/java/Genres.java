

public enum Genres {
    ACTION("action"), MOBA("moba"), SIMULATION("simulation"), STATEGY("stategy"), ADVENTURE("adventure"),
    ROLE_PLAYING("role") ;

    private String name;

    Genres(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
