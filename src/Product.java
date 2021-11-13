import java.util.ArrayList;

public class Product {


    //klassvariabler ("attributer")
   private String name;
   private String genre;
   private String description;

   private int price;




    //Konstruktor
    public Product (String movieTitle,String movieGenre, String description, int price) {

        this.name = movieTitle;
        this.genre = movieGenre;
        this.description = description;
        this.price = price;
    }


    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




}

