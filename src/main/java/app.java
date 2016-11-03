import static spark.Spark.*;

public class app {
    public static void main(String[] args) {
        staticFiles.location("/");
        get("/hello", (req, res) -> "Hello World");


    }
}