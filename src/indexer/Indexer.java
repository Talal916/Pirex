package indexer;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;

import textProcessor.ProcessedBook;

public class Indexer {
	private Map<String, HashMap<Integer, ArrayList<Integer>>> index;
	private int indexCount;
	private int fileCount;
	private int posting;	
	
	public Indexer() {
		index = new TreeMap<String, HashMap<Integer, ArrayList<Integer>>>();
		indexCount = 0;
		fileCount = 0;
		posting = 0;
	}
	
	public void addTerms(ProcessedBook book) {
		LinkedList<StringBuilder> opus = book.getOpus();
		int opusNum = book.getOpusNum();
		String line = "";
		for(int i = 0; i<opus.size(); i++) {
			line = opus.get(i).toString().toLowerCase();
			for(String s : line.split("\\s+")) {
				HashMap<Integer, ArrayList<Integer>> map = index.get(s);
				if (map == null) {
					map = new HashMap<Integer, ArrayList<Integer>>();
					map.put(opusNum, new ArrayList<Integer>());
					index.put(s, map);
					fileCount++;
					indexCount++;
				} else if (!map.containsKey(opusNum)) {
					map.put(opusNum, new ArrayList<Integer>());
				} 
				if (!map.get(opusNum).contains(i)) {
					map.get(opusNum).add(i);
					posting++;
				}	
			}
		}			
	}
	
	public int getPostings() {
		int postings = 0;
		for(String s: index.keySet()) {
			HashMap<Integer, ArrayList<Integer>> map = index.get(s);
			for(Integer i: map.keySet()) {
				postings += map.get(i).size();
			}   
		}
		return postings;
	}

	public boolean searchIndex(String s) {
		return index.containsKey(s);
	}

	public void clear() {
		index.clear();
	}
	
	public Map<String, HashMap<Integer, ArrayList<Integer>>> getIndex() {
		return index;
	}
	
	public int getIndexCount() {
		return indexCount;
	}
	
	public int getFileCount() {
		return fileCount;
	}
	
	public int getPosting() {
		return posting;
	}
	
	public int getSize() {
		return index.size();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String s: index.keySet()) {
			sb.append("Key: " + s + " Value: " + index.get(s).toString() + "\n");
		}
		return sb.toString();
	}
}
