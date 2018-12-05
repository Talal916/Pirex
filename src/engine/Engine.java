package engine;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;

import indexer.Indexer;

public class Engine {
	private Map<String, HashMap<Integer, ArrayList<Integer>>> index;
	private static ArrayList<String> query;
	
	public Engine(Indexer i) {
		index = i.getIndex();
		query = new ArrayList<String>();
	}
	
	public void addQuery(String s) {
		query.clear();
		if(!s.contains(" ")) {
			query.add(s.toLowerCase());
			return;
		}
		else {
			s += " ";
			while(s.contains(" ")) {
				String word = s.substring(0,s.indexOf(" "));
				query.add(word.toLowerCase());
				s = s.substring(s.indexOf(" ")+1);
			}
		}
	}
	
	public ArrayList<StringBuilder> getResults(LinkedList<StringBuilder> list) {
		ArrayList<StringBuilder> results = new ArrayList<StringBuilder>();
		for (StringBuilder sb : list) {
			for(String s : query) {
				if (sb.toString().toLowerCase().contains(s)) {
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
