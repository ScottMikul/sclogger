package learning;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

/**
 * Created by scott on 11/7/2016.
 */
public class mongoBasicCrudTest {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("test2");

        MongoCollection<Document> collection = database.getCollection("test");

        //insert into the database a document to test.
        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new Document("x", 203).append("y", 102));

        collection.insertOne(doc);

        //try a read of all of the stuff.
        System.out.println("after inserting:" +printStuff(collection));

        //update one document
        collection.updateOne(eq("name", "MongoDB"), set("name","SQL" ));
        System.out.println("After updating name to SQL: "+printStuff(collection));

        //replace a document
        collection.replaceOne(eq("name","SQL"),doc);
        System.out.println("Replacing the document with original:"+ printStuff(collection));


        //delete one
        collection.deleteOne(eq("name","MongoDB"));
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
