package sclogger;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import spark.Request;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

/**
 * Created by scott on 11/9/2016.
 */
public class updatePosts {
    public static void main(String[] args) {
        Gson gson = new Gson();
        post post = new post("stuff", "blog title 1", "12/7/2017");

        System.out.println(gson.toJson(post));

        post replace = new post("donald trump won.", "I can not believe it", "12/7/2018");

        System.out.println(gson.toJson(replace));
    }
    public static String updatePost(Request request, MongoCollection<Document> collection){
        Gson gson = new Gson();
        System.out.println("request: "+ request.body());
        post [] posts = gson.fromJson(request.body(),post[].class);
        post query = posts[0];
        System.out.println("query: "+query.toString());
        post relacement = posts[1];
        System.out.println("replacement: " +relacement.toString());
        Document updateDoc = new Document("content", relacement.getContent())
                .append("title", relacement.getTitle())
                .append("date",relacement.getDate());
        collection.replaceOne(and(eq("content", query.getContent()),eq("date",query.getDate()),eq("title", query.getTitle())),updateDoc);
        return "";
    }
}
