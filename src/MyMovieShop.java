import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;



public class MyMovieShop {
    static ArrayList<String> movieLists = new ArrayList<String>();
    static ArrayList<Product> items = new ArrayList<Product>();


    //Inne i start-metoden anropas alla metoder/funktioner här.
    public static void start() {

        //Här nedan skapas konstruktorn
        Product movie1 = new Product("Prometheus", "Sci-Fi", "Adventurous alien movie", 99);
        items.add(movie1);

        Product movie2 = new Product("Arrival", "Sci-Fi", "Louise Banks, a linguist \n" +
                "enlisted by the United States Army's discover how to communicate with extraterrestrial aliens who \n" +
                "have arrived on Earth, before tensions lead to war.", 59);
        items.add(movie2);

        Product movie3 = new Product("Gladiator", "Action", "Roman Empire", 100);
        items.add(movie3);




        boolean runProgram = true;
        while (runProgram) {

            printMeny();
            int userPickedOptions = getUserInt();

            switch (userPickedOptions) {
                case 1:
                    allMovies();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    movieDescriptions();
                    break;
                case 4:
                    runProgram = false;
                    System.out.println("Program has ended");
                    break;
                case 5:
                    System.out.println("");
                    break;
                default:
            }
        }


    }




    public static void printMeny() {
        System.out.println("--------------------------");
        System.out.println(" Welcome to my MovieShop");
        System.out.println("           *****");
        System.out.println(" Please choose an option");
        System.out.println("--------------------------");
        System.out.println("1. All movies in the shop");
        System.out.println("2. Add movies to the cart");
        System.out.println("3. Ask about the product");
        System.out.println("4. Quit program");
        System.out.println("--------------------------");
        System.out.print("> ");
    }

    public static String getUserString() {
        Scanner myScan = new Scanner(System.in);
        String userInput = myScan.nextLine();

        return userInput;
    }

    //override 
    public static String getUserString2(String question) {

        System.out.println(question);

        return getUserString();
    }



    public static int getUserInt() {
        Scanner myScan = new Scanner(System.in);
        int userInput;

        while (true) {
            try {
                userInput = Integer.parseInt(myScan.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Sorry, I didn't catch that. Please try again");
            }
        }
        return userInput;
    }


    public static void allMovies() {
       for (int i = 0; i < items.size(); i++) {
           System.out.println(items.get(i).getName() + ", " + items.get(i).getGenre() + ", " +
                   items.get(i).getPrice() + " kr");
       }
    }

    public static void addToCart() {
        System.out.println("Add the movie you'd like to buy");
        System.out.println("> ");
        String userChoice = getUserString();

        for (int i = 0; i < items.size(); i++) { //For-loops kan användas för att hämta ut den data som användaren
           //skrivit in innan utifrån det som finns i listan.

            if (Objects.equals(userChoice, items.get(i).getName())) {
                System.out.println(items.get(i).getName() + " " + items.get(i).getPrice() + ", kr");
                movieLists.add(userChoice);

            }
        }
        Choice();
    }




    public static void movieDescriptions() {
        System.out.print("Look for the movie > ");
        String choice = getUserString();
        System.out.println(" ");
        System.out.println("--------------------");
        System.out.println("About the movie:");
        System.out.println("--------------------");

        for (int i = 0; i < items.size(); i++) {
            if (Objects.equals(choice, items.get(i).getName())) {
                System.out.println(items.get(i).getDescription());
            }
        }

    }

    public static void Choice() {


        if (getUserString2("Vill du shoppa vidare").equals("yes")) {
            addToCart();

        } if (getUserString2("Vill du avsluta köpet?").equals("buy")) {

            //int totalCost = 0;
            for (String i : movieLists) {
                System.out.println("You have now bought " + i);
            }

            System.out.println("Thank you for your purchase.");
            printMeny();
        } else {
            System.out.println("Sorry, I didn't catch that. Please type 'yes' or 'no'.");
        }
    }
}

/*

istället som jag gjort högst uppe med static ArrayList products = new Arraylist<Product>
så kan man enligt Björn skriva och testa i konstruktorn istället:

public MyMovieSHop () {
products = new ArrayList<Product>;
}

för att det ska bli mer framtidssäkert
 */

