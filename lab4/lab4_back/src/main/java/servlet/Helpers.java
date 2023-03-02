package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import Entity.MyEntity;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import jakarta.servlet.http.HttpServletRequest;

public class Helpers {
	
	public static JsonElement bodyParse(HttpServletRequest request) {
		JsonElement jsonElement=null;	
		
		try {
			jsonElement = JsonParser.parseReader(request.getReader());
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonElement;
	}
	
	public static MyEntity Parse(HttpServletRequest request) {
		MyEntity ent = new MyEntity();
		JsonElement jsonElement = bodyParse(request);
		ent.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
		ent.setName(jsonElement.getAsJsonObject().get("name").getAsString());
		ent.setDescription(jsonElement.getAsJsonObject().get("description").getAsString());
		ent.setimg(jsonElement.getAsJsonObject().get("img").getAsString());
		return ent;
	}
	
	
	public static int getNext(List<MyEntity> list) {
		int maxId = 0;
		Iterator<MyEntity> iterator = list.iterator();
		while(iterator.hasNext()) {
			int currentCat = iterator.next().getId();
			if(currentCat>maxId) maxId=currentCat;
		}
		return maxId+1;
	}
	
	public static int getIndexById(int cat,List<MyEntity> list) {
		int listId = cat;
		
		Iterator<MyEntity> iterator = list.iterator();
		while(iterator.hasNext()) {
			MyEntity temp =iterator.next();
			if(temp.getId()==listId) {
				listId=list.indexOf(temp);
				break;
			}
		}
		return listId;
	}

}