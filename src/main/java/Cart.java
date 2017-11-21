
import java.util.ArrayList;

public class Cart {

    private ArrayList<ComputerGame> games = new ArrayList<ComputerGame>();
    private PaymentStrategy paymentStrategy;
    private DeliveryStrategy deliveryStrategy;


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

    public Cart(ArrayList<ComputerGame> games, DeliveryStrategy deliveryStrategy, PaymentStrategy paySt) {
        setGames(games);
        setDeliveryStrategy(deliveryStrategy);
        setPaymentStrategy(paySt);
    }

    public void addGame(ComputerGame game) {

        games.add(game);

    }
    public double computeTotalPrice(){
        double tot_price = 0;
        for (ComputerGame cg:getGames()) {
            tot_price += cg.getSpec().getPrice();
        }
        return  tot_price;
    }
    public boolean ship(){
        return true;
    }



    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append("Cart: ");
        for (ComputerGame scg : getGames()) {
            line.append(scg.toString()).append("\n");
        }
        line.append(getDeliveryStrategy().toString()).append("\n").append(getPaymentStrategy().toString()).append("\n");
        return line.toString();
    }
}
