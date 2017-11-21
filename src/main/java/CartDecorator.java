import java.util.ArrayList;

public class CartDecorator extends Cart {
    private Cart cartToDecorate;


    public Cart getCartToDecorate() {
        return cartToDecorate;
    }

    protected void setCartToDecorate(Cart cart) {
        this.cartToDecorate = cart;
    }

    public CartDecorator(Cart c){
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
        if (getPaymentStrategy().pay(computeTotalPrice())){
            getDeliveryStrategy().deliver(getGames());
            return true;
        }
        return false;
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
