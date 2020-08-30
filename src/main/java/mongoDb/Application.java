package mongoDb;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Application {
	
	private static final String MONGO_URI = "mongodb+srv://artur:artur13@cluster0.sx6bb.mongodb.net/test";
	
	public static void main(String[] args) {
		MongoClient client = new MongoClient(new MongoClientURI(MONGO_URI));
		MongoDatabase database = client.getDatabase("data");
		MongoCollection<Document> collection = database.getCollection("test");
		
		System.out.println("Connected to database");
		
		Document document = new Document("id", 1);
		document.put("priority", "HIGER");
		document.put("author6", "func");
		document.put("content", "some extra text like this lol");
		document.put("values", Arrays.asList("first", "second", "3", "double duo"));

		Document documents = new Document("id", 2);
		documents.put("priority", "HIGER");
		documents.put("author", "function");
		documents.put("content", "some extra text like this lol");
		documents.put("values", Arrays.asList("first", "second", "3", "double duo"));
		
		collection.insertOne(document);
		collection.insertOne(documents);
		
		System.out.println("Araji zaprosy uxarkvela");
		
		Document founded = collection.find(new Document("id",2)).first();
		
		if (founded != null) {
			System.out.println(founded.getString("author"));
			
		}
		
		collection.updateOne(Filters.eq("id", 2), new Document(
				"$set",
				new Document("some fild", "8")
				));

	}

}
