package sclogger;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import spark.Request;

/**
 * Created by scott on 11/10/2016.
 */
public class createPosts {
    public static String createPost(Request request, MongoCollection<Document> collection){
        Gson gson = new Gson();
        System.out.println("request: "+ request.body());
        post query = gson.fromJson(request.body(), post.class);
         Document doc = new Document("content", query.getContent())
                .append("title", query.getTitle())
                .append("date",query.getDate());
        collection.insertOne(doc);
        return "";
    }
}
