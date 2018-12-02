package engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import indexer.Indexer;

public class Engine {
	private Map<String, HashMap<Integer, ArrayList<Integer>>> index;
	private static ArrayList<String> query;
	String[] stopList = {"", "a", "an", "and", "are", "but", "did", "do", "does", "for", "had", "has", "is", 
						 "it", "its", "of", "or", "that", "the", "this", "to", "were", "which", "with"};
	
	public Engine(Indexer i) {
		index = i.getIndex();
		query = new ArrayList<String>();
	}
	
	public void addQuery(String s) {
		query.clear();
		String phrase = s;
		if(!phrase.contains(" ")) {
			query.add(phrase.toLowerCase());
			return;
		}
		else {
			phrase += " ";
			while(phrase.contains(" ")) {
				String word = phrase.substring(0,phrase.indexOf(" "));
				if(!Arrays.asList(stopList).contains(word)) {
					query.add(word.toLowerCase());
				}
				phrase = phrase.substring(phrase.indexOf(" ")+1);
			}
		}
	}
	
	public ArrayList<StringBuilder> getResults(LinkedList<StringBuilder> list) {
		ArrayList<StringBuilder> results = new ArrayList<StringBuilder>();
		for (StringBuilder sb : list) {
			for(String temp : query) {
				if (sb.toString().toLowerCase().contains(temp)) {
					  results.add(sb);
				}
			}
		}
		return results;
	}
	
	public HashMap<Integer, ArrayList<Integer>> getHashMap(String s) {
		return index.get(s);
	}

	public static ArrayList<String> getQuery() {
		return query;
	}
	
	//Flags if queries were found
	public boolean queryFound(String s) {
		return index.containsKey(s);
	}

	public boolean queryFound() {
		for(String s : query) {
			if(index.containsKey(s)) return true;
		}
		return false;
	}
}
