package sclogger;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static spark.Spark.*;

public class app {
    public static void main(String[] args) {
        staticFiles.location("/");
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("test2");
        MongoCollection<Document> collection = database.getCollection("post");

        post("/createPost",((request, response) -> createPosts.createPost(request,collection)));
        get("/readAll",((request, response) -> readPosts.readPosts(collection)));
        post("/updatePost",((request, response) -> updatePosts.updatePost(request,collection)));
        post("/deletePost",(request, response) -> deletePost.deletePost(request,collection));



    }
}