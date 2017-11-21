import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CartTest {
    private Cart cart = new Cart(), cart1 ;
    private ComputerGame cg, cg1, cg2, cg3;
    private ComputerGameParams cgp, cgp1, cgp2, cgp3;
    private ArrayList<ComputerGame> acg = new ArrayList<>();
    ArrayList<Genres> genres = new ArrayList<>(), genres1 = new ArrayList<>();
    @Before
    public void initializationOfObject(){
        cart1 = new Cart();
    }
    @Test
    public void addGame() throws Exception {
    }

    @Test
    public void computeTotalPrice() throws Exception {
    }

    @Test
    public void ship() throws Exception {
    }

}