import java.util.ArrayList;

public class BonusDecorator extends CartDecorator{

    private CartDecorator cd;


    public void setCd(CartDecorator cd) {

    }


    public BonusDecorator(Cart c){
        super(c);


    }

    @Override
    public boolean ship(){
        try{
            return addBonus();
        }
        catch (Exception e){
            return false;
        }


    }

    @Override
    public double computeTotalPrice(){
        return  cd.computeTotalPrice() + 1;
    }

    public boolean addBonus(){
        System.out.println("Add bonus");
        ArrayList<Genres> ag = new ArrayList<Genres>();
        ag.add(Genres.SIMULATION);
        cd.addGame(new ComputerGame(new ComputerGameParams("Happy Farm", ag)));
        return true;
    }
}
