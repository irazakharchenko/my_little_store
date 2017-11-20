import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ComputerGameBoxTest {
    private ComputerGame cg, cg1, cg2, cg3;
    private ComputerGameParams cgp, cgp1, cgp2, cgp3;
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
        assertEquals(cgbox.search(cgp1).get(0), cg);
        assertEquals(cgbox2.search(cgp1).get(0), cg);
        //assertEquals(cgbox2.search(cgp1), );


        assertEquals(cgbox2.getObj().get(0).getSpec().toString(), "ComputerGameParams{name='counter strike', " +
                "description='null', price=0.0, ageRestrinct=0, genres=[action, simulation]}");
    }

    @Test
    public void getGame() throws Exception {

        assertEquals(cgbox2.getGame("counter strike"), cg);
        assertEquals(cgbox2.getGame(cg3.getSpec().getName()), null);
        assertEquals(cgbox.getGame("some name"), cg2);
    }

    @Test
    public void testToString() throws  Exception{
        assertEquals(cgbox2.toString(), "Game with ComputerGameParams{name='counter strike', " +
                "description='null', price=0.0, ageRestrinct=0, genres=[action, simulation]}\n" +
                "Game with ComputerGameParams{name='some name', description='short description', price=12.9," +
                " ageRestrinct=12, genres=[action, simulation, moba]}\n");
    }

}