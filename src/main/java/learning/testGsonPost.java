package learning;

import com.google.gson.Gson;
import sclogger.post;
import spark.Request;

import static spark.Spark.*;

//transform a json request into a sclogger.post object
public class testGsonPost {
    public static void main(String[] args) {
        staticFiles.location("/");
        post("/printrequest",((request, response) -> requestMethod(request)));


    }
    private static String requestMethod(Request request){
        Gson gson = new Gson();
        post post = gson.fromJson(request.body(), post.class);
        System.out.println("sclogger.post to string: " + post.toString());

        return "alright we printed it with java";
    }
}