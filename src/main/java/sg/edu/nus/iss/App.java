package sg.edu.nus.iss;

public class App {

    private static String defaultdb = "db"; // Has to be static since it is used in static main method

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("arg db directory provided");
            App.defaultdb = args[0]; // defaultdb will be "db"
        }
        System.out.println(defaultdb);

        ShoppingCartDB db = new ShoppingCartDB(defaultdb);

        // Object for Session
        Session session = new Session(db);
        session.start();
    }
}
