package learning;

import spark.Request;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

/**
 * Created by scott on 11/9/2016.
 */
// let's see if we can get the contents of http sclogger.post body.
public class testRequest {
    public static void main(String[] args) {
        staticFiles.location("/");
        post("/printrequest",((request, response) -> requestMethod(request)));

    }
    private static String requestMethod(Request request){
        System.out.println(request.body());
        return "alright we printed it with java";
    }
}
