

import java.util.ArrayList;

public class ComputerGameParams {
    private String name;
    private String description;
    private double price;
    private int ageRestrinct;
    private ArrayList<Genres> genres;



    public ComputerGameParams(ComputerGameParams param) {
        setName(param.name);
        setGenres( new ArrayList<Genres>(param.genres));
        setDescription(param.description);
        setPrice(param.price);
        setAgeRestrinct(param.ageRestrinct);


    }

    public ComputerGameParams(String name, ArrayList<Genres> genres) {
        setName(name);
        setGenres( new  ArrayList<Genres>(genres));
        setAgeRestrinct(18);
        setDescription("interesting game");
        setPrice(19.6);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAgeRestrinct() {
        return ageRestrinct;
    }

    public void setAgeRestrinct(int ageRestrinct) {
        this.ageRestrinct = ageRestrinct;
    }

    public ArrayList<Genres> getGenres() { return genres; }

    public void setGenres(ArrayList<Genres> genres) { this.genres = genres; }

    public ComputerGameParams(String name,
                              String description,
                              double price,
                              int ageRestrinct,
                              ArrayList<Genres> genres){
        setName(name.toLowerCase());
        setAgeRestrinct(ageRestrinct);
        setDescription(description.toLowerCase());
        setPrice(price);
        setGenres(genres);
        //new ComputerGame();
    }

    public boolean matches(ComputerGameParams otherPar){
        if( getName() != null && !getName().equals("")  &&  !getName().equals(otherPar.getName()) )
            return false;
        if( getDescription() != null && !getDescription().equals("") &&
                !getDescription().equals(otherPar.getDescription()))
            return false;
        if (getPrice() != 0.0 && getPrice() != otherPar.getPrice())
            return false;
        if (getAgeRestrinct() != otherPar.getAgeRestrinct())
            return false;
        for(Genres gen: otherPar.getGenres()){
            if(!getGenres().contains(gen))
                return false;
        }
        return true;

    }


    @Override
    public String toString() {
        return "ComputerGameParams{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", ageRestrinct=" + ageRestrinct +
                ", genres=" + genres +
                '}';
    }
}
