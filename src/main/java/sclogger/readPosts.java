package sclogger;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import sclogger.post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scott on 11/9/2016.
 */
public class readPosts {
    public static String readPosts(MongoCollection<Document> collection) {
        List<Document> list = collection.find().into(new ArrayList<>());
        Gson gson = new Gson();
        post [] posts = new post[list.size()];
        for (int i=0;i<posts.length;i++){
            posts[i]= gson.fromJson(list.get(i).toJson(), post.class);
        }
        String result = gson.toJson(posts);
        System.out.println(result);
        return result;
    }
}
