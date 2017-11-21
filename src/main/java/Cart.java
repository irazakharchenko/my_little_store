
import java.util.ArrayList;

public class Cart {

    private ArrayList<ComputerGame> games = new ArrayList<ComputerGame>();
    private PaymentStrategy paymentStrategy;
    private DeliveryStrategy deliveryStrategy;
    private boolean isCash;

    public ArrayList<ComputerGame> getGames() {
        return games;
    }

    public void setGames(ArrayList<ComputerGame> games) {
        this.games = games;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }


    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public DeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }

    public Cart(){}

    public Cart(ArrayList<ComputerGame> games, DeliveryStrategy deliveryStrategy, boolean isCash) {

        setGames(games);
        setDeliveryStrategy(deliveryStrategy);
        this.isCash = isCash;
    }

    public void addGame(ComputerGame game) {

        games.add(game);

    }
    public double computeTotalPrice(){
        return  100.500;
    }
    public boolean ship(){
        return true;
    }



    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("");
        for (ComputerGame scg : getGames()) {
            line.append(scg.toString()).append("\n");
        }
        return line.toString();
    }
}
