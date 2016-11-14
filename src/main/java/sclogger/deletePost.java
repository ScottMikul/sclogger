package sclogger;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import spark.Request;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

/**
 * Created by scott on 11/10/2016.
 */
public class deletePost {
    public static String deletePost(Request request, MongoCollection<Document> collection){
        Gson gson = new Gson();
        System.out.println("request: "+ request.body());
        post query = gson.fromJson(request.body(), post.class);
        collection.deleteOne(and(eq("content", query.getContent()),eq("date",query.getDate()),eq("title", query.getTitle())));
        return "";
    }
}
