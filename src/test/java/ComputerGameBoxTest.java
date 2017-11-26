import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ComputerGameBoxTest {
    private ComputerGame cg, cg1, cg2, cg3;
    private ComputerGameParams cgp, cgp1, cgp2, cgp3, cgp4;
    private ComputerGameBox cgbox, cgbox2;

    @Before
    public void initializationOfObject(){
        ArrayList<Genres> genres = new ArrayList<>(), genres1 = new ArrayList<>();
        genres.add(Genres.ACTION);
        genres.add(Genres.SIMULATION);
        genres1.add(Genres.ADVENTURE);

        cgp = new ComputerGameParams("counter Strike", genres);
        cgp1 = new ComputerGameParams(cgp);
        genres.add(Genres.MOBA);
        cgp2 = new ComputerGameParams("Some name", "short description", 12.9, 12,
                genres);
        cg = new ComputerGame(cgp);
        cg1 = new ComputerGame(cgp1);
        cg2 = new ComputerGame(cgp2);
        cgbox = new ComputerGameBox();
        cgp3 = new ComputerGameParams("Other", genres1);
        cg3 = new ComputerGame(cgp3);
        cgbox.addGame(cg);
        cgp4 = new ComputerGameParams("counter Strike", genres);

        cgbox.addGame(cg2);
        cgbox2 = new ComputerGameBox(cgbox.getObj());
    }

    @Test
    public void getObj() throws Exception {
        assertEquals(cgbox2.getObj().contains(cg), true);
        assertEquals(cgbox2.getObj().contains(cg1), false);
        assertEquals(cgbox.getObj().get(1), cg2);
        assertEquals(cgbox2.getObj().get(0), cg);
    }

    @Test
    public void search() throws Exception {


        cgbox2.search(cgp);
        assertEquals( cg,cgbox.search(cgp1).get(0));
        assertEquals( cg,cgbox2.search(cgp1).get(0));
        assertEquals( 0,cgbox2.search(cgp4).size());
        cgbox.addGame(cg3);
        cgp2 = new ComputerGameParams("Other","short description1", 12.9, 12, cgp.getGenres());
        assertEquals(0, cgbox2.search(cgp2).size());
        cgp2.setDescription("short description");
        cgp2.setPrice(13.4);
        assertEquals(0,  cgbox2.search(cgp2).size());
        cgp2.setPrice(12.9);
        cgp2.setAgeRestrinct(13);
        assertEquals(0, cgbox2.search(cgp2).size());


        assertEquals("ComputerGameParams{name='counter strike', description='interesting game', price=19.6," +
                " ageRestrinct=18, genres=[action, simulation]}", cgbox2.getObj().get(0).getSpec().toString());
    }

    @Test
    public void getGame() throws Exception {

        assertEquals(cgbox2.getGame("counter strike"), cg);
        assertEquals(cgbox2.getGame(cg3.getSpec().getName()), null);
        assertEquals(cgbox.getGame("some name"), cg2);
    }

    @Test
    public void testToString() throws  Exception{
        assertEquals( "Game with ComputerGameParams{name='counter strike', " +
                "description='interesting game', price=19.6, ageRestrinct=18, genres=[action, simulation]}\n" +
                "Game with ComputerGameParams{name='some name', description='short description', price=12.9," +
                " ageRestrinct=12, genres=[action, simulation, moba]}\n", cgbox2.toString());
    }

}