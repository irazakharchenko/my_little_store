import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BonusDecoratorTest {
    private Cart cart = new Cart(), cart1 ;
    private ComputerGame cg, cg1, cg2, cg3;
    private ComputerGameParams cgp, cgp1, cgp2, cgp3;
    private ArrayList<ComputerGame> acg = new ArrayList<>(), acg1 =  new ArrayList<>();
    ArrayList<Genres> genres = new ArrayList<>(), genres1 = new ArrayList<>();
    private BonusDecorator bd ;
    private CartDecorator cd;
    private DiscountCart discountCart;
    @Before
    public void initializationOfObject(){

        genres.add(Genres.ACTION);
        cgp = new ComputerGameParams("counter Strike", genres);
        cg = new ComputerGame(cgp);
        acg.add(cg);
        cart1 = new Cart(acg, new DeliveryDHL(), new PrivatPayment());
        cgp1 = new ComputerGameParams("Pony", genres);
        cg1 = new ComputerGame(cgp1);
        cart.addGame(cg1);
        bd = new BonusDecorator(cart);
        cd = new CartDecorator(cart1);
        cd.addGame(cg1);
        discountCart = new DiscountCart(cart);
    }

    @Test
    public void ship() throws Exception {
        assertEquals(true, bd.ship());
        assertEquals(true, cd.ship());
    }

    @Test
    public void computeTotalPrice() throws Exception {
        assertEquals(19.6, bd.computeTotalPrice(), 0.01);
        assertEquals(19.6*2, cd.computeTotalPrice(), 0.01);
        assertEquals(cart, bd.getCartToDecorate());
        assertEquals(cart1, cd.getCartToDecorate());
        cd.setPaymentStrategy(new CashStrategy());
        assertEquals(true, cd.getPaymentStrategy().pay(12.3));
        assertEquals( "Cash", cd.getPaymentStrategy().toString());
        cd.setDeliveryStrategy(new DeliveryNovaPoshta());
        assertEquals(true, cd.getDeliveryStrategy().deliver(cd.getGames()));
        assertEquals("Nova poshta", cd.getDeliveryStrategy().toString());
        //
        assertEquals(17.64, discountCart.computeTotalPrice(),0.04);

    }

}