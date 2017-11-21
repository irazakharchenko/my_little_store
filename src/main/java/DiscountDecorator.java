public class DiscountDecorator extends CartDecorator{


    public DiscountDecorator(Cart c) {
        super(c);
    }

    @Override
    public double computeTotalPrice(){
        return this.getCartToDecorate().computeTotalPrice() * 0.90;
    }
}
