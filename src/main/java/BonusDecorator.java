public class BonusDecorator extends CartDecorator {


    public BonusDecorator(Cart c) {
        super(c);

    }

    @Override
    public boolean ship() {
        addBonus();
        return getCartToDecorate().ship();
    }


    public boolean addBonus() {
        System.out.println("Add bonus");
        //ArrayList<Genres> ag = new ArrayList<Genres>();
        //ag.add(Genres.SIMULATION);
        //cd.addGame(new ComputerGame(new ComputerGameParams("Happy Farm", ag)));
        return true;
    }
}
