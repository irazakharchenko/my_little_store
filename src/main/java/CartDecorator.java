import java.util.ArrayList;

public class CartDecorator extends Cart {
    private Cart cartToDecorate;


    private Cart getCartToDecorate() {
        return cartToDecorate;
    }

    private void setCartToDecorate(Cart cart) {
        this.cartToDecorate = cart;
    }

    private CartDecorator(Cart c){
        setCartToDecorate(c);
    }

    @Override
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        cartToDecorate.setPaymentStrategy(paymentStrategy);
    }
    @Override
    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        cartToDecorate.setDeliveryStrategy(deliveryStrategy);
    }

    @Override
    public PaymentStrategy getPaymentStrategy() {
        return cartToDecorate.getPaymentStrategy();
    }
    @Override
    public DeliveryStrategy getDeliveryStrategy() {
        return cartToDecorate.getDeliveryStrategy();
    }

    @Override
    public double computeTotalPrice(){
        return  cartToDecorate.computeTotalPrice();
    }
    @Override
    public boolean ship(){
        return (getPaymentStrategy().pay(computeTotalPrice())) && getDeliveryStrategy().deliver(getGames());

    }

    @Override
    public ArrayList<ComputerGame> getGames() {
        return this.cartToDecorate.getGames();
    }
    @Override
    public void setGames(ArrayList<ComputerGame> games) {
        this.cartToDecorate.setGames(games);
    }




    @Override
    public void addGame(ComputerGame game) {

        cartToDecorate.addGame(game);


    }




}
