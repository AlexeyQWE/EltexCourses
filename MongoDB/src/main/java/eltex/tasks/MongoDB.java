package eltex.tasks;

import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import java.io.*;
import java.util.*;

public class MongoDB {

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop.load(fis);

        MongoClient mongoClient = MongoClients.create(prop.getProperty("db.host"));
        MongoDatabase db = mongoClient.getDatabase(prop.getProperty("db.name"));
        MongoCollection<Document> collection = db.getCollection(prop.getProperty("db.table"));

       Document doc = new Document("name", "Ivan")
            .append("phone", "900")
            .append("lang", Arrays.asList("java", "c++"));
        collection.insertOne(doc);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set", new BasicDBObject().append("clients", 110));
        BasicDBObject searchQuery = new BasicDBObject().append("name", "Ivan");
        collection.updateMany(searchQuery, newDocument);

        Document myDoc = collection.find().first();

        for (Document cur : collection.find()) {
            System.out.println(cur.toJson());
        }

        collection.deleteMany(searchQuery);

    }
}
