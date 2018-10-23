package menu;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
    	port(8008);
        get("/hola", (req, res) -> "Hola amiguitos");
    }
}