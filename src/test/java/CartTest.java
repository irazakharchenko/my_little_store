import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CartTest {
    private Cart cart = new Cart(), cart1 ;
    private ComputerGame cg, cg1, cg2, cg3;
    private ComputerGameParams cgp, cgp1, cgp2, cgp3;
    private ArrayList<ComputerGame> acg = new ArrayList<>(), acg1 =  new ArrayList<>();
    private ArrayList<Genres> genres = new ArrayList<>(), genres1 = new ArrayList<>();
    private Observer ob = new User(), ob1 = new Seller();
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
        cart.addObserver(ob);


    }
    @Test
    public void addGame() throws Exception {

        assertEquals("Cart: Game with ComputerGameParams{name='counter strike', description='interesting game', price=19.6, ageRestrinct=18, genres=[action]}\n" +
                "DHL\n" +
                "Privat 24\n", cart1.toString());
    }

    @Test
    public void computeTotalPrice() throws Exception {
        assertEquals(19.6,cart1.computeTotalPrice(), 0.01);
    }

    @Test
    public void ship() throws Exception {
        assertEquals(true,cart1.ship());
    }

    @Test
    public void addObserver() throws Exception{
        assertEquals(true, cart.addObserver(ob));
    }

    @Test
    public void notifyObserver() throws Exception{
        assertEquals(true, cart.notifyObservers());
    }

    @Test
    public void removeObserver() throws Exception{
        assertEquals(true, cart.removeObserver(ob));
        assertEquals(false, cart.removeObserver(ob1));
    }


}