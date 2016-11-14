package learning;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import sclogger.post;
/**
 * Created by scott on 11/9/2016.
 */
public class postCrudPojo {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("test2");

        MongoCollection<Document> collection = database.getCollection("testpost");

        post post = new post("content 1","title 1", "date 1");
        //insert into the database a document to test.
        Document doc = new Document("content", post.getContent())
                .append("title", post.getTitle())
                .append("date",post.getDate());

        collection.insertOne(doc);

        //try a read of all of the stuff.
        System.out.println("after inserting:" +printStuff(collection));

        //update one document
        collection.updateOne(eq("title", "title 1"), set("title","title 3" ));
        System.out.println("After updating name to SQL: "+printStuff(collection));

        //replace a document
        collection.replaceOne(and(eq("title","title 3"),eq("date","date 1"),eq("content","content 1")),doc);
        System.out.println("Replacing the document with original:"+ printStuff(collection));


        //delete one
        collection.deleteOne(eq("title","title 1"));
        System.out.println("Deleting the document:"+ printStuff(collection));

    }

    private static String printStuff(MongoCollection<Document> collection ){
        List<Document> list= collection.find().into(new ArrayList<>() );
        String returnString = "";
        for(int i=0;i<list.size();i++){
            returnString += list.get(i).toJson();
        }
        return returnString;
    }
}
