package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import jakarta.servlet.http.HttpServletRequest;
import paint.paint;

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
	
	public static paint paintParse(HttpServletRequest request) {
		paint paint = new paint();
		JsonElement jsonElement = bodyParse(request);
		paint.setCat(jsonElement.getAsJsonObject().get("cat").getAsInt());
		paint.setTitle(jsonElement.getAsJsonObject().get("title").getAsString());
		paint.setPrice(jsonElement.getAsJsonObject().get("price").getAsFloat());
		paint.setType(jsonElement.getAsJsonObject().get("type").getAsString());
		return paint;
	}
	
	
	public static int getNextCat(List<paint> list) {
		int maxCat = 0;
		Iterator<paint> iterator = list.iterator();
		while(iterator.hasNext()) {
			int currentCat = iterator.next().getCat();
			if(currentCat>maxCat) maxCat=currentCat;
		}
		return maxCat+1;
	}
	
	public static int getIndexByPaintCat(int cat,List<paint> list) {
		int listCat = cat;
		
		Iterator<paint> iterator = list.iterator();
		while(iterator.hasNext()) {
			paint temp =iterator.next();
			if(temp.getCat()==listCat) { 
				listCat=list.indexOf(temp);
				break;
			}
		}
		return listCat;
	}

}