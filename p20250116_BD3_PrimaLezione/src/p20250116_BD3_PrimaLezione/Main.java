package p20250116_BD3_PrimaLezione;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {

	public static void main(String[] args) {
	    String uri = "mongodb+srv://xeyewal413:68Dh9bXsBQPPZani@bd3cluster.857gz.mongodb.net/?retryWrites=true&w=majority&appName=BD3Cluster";

	    try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase("BD3");
	        MongoCollection<org.bson.Document> collection = database.getCollection("test");
	        Document doc = collection.find().first();
	        if (doc != null) {
	            System.out.println(doc.toJson());
	        } else {
	            System.out.println("No matching documents found.");
	        }
	        //insert(collection);
	        findAll(collection);
	    }
	}

	private static void findAll(MongoCollection<Document> collection) {
		FindIterable<Document> docs = collection.find();
		for (Document doc : docs) {
			System.out.println(doc.toJson());
		}
	}
	
	private static void insert(MongoCollection<Document> collection) {
		Document car = new Document("brand", "Fiat")
				.append("model", "PandaMarocco");
		Document newDoc = new Document("name", "Osama")
				.append("age", 35)
				.append("car", car);
		
		collection.insertOne(newDoc);
	}

	private static Document search(MongoCollection<Document> collection) {
		
		Document newDoc = new Document("name", "Osama")
				.append("age", 35);
		
		return (Document) collection.find(newDoc);
	}
}
