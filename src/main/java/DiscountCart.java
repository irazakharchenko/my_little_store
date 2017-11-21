public class DiscountCart extends CartDecorator{


    public DiscountCart(Cart c) {
        super(c);
    }

    @Override
    public double computeTotalPrice(){
        return this.getCartToDecorate().computeTotalPrice() * 0.90;
    }
}
