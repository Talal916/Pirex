package indexer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import textProcessor.ProcessedBook;

public class Indexer {
	private Map<String, HashMap<Integer, ArrayList<Integer>>> index;
	private int indexCount;
	private int fileCount;
	private int posting;
	String[] stopList = {"", "a", "an", "and", "are", "but", "did", "do", "does", "for", "had", "has", "is", 
						 "it", "its", "of", "or", "that", "the", "this", "to", "were", "which", "with"};	
	
	public Indexer() {
		index = new TreeMap<String, HashMap<Integer, ArrayList<Integer>>>();
		indexCount = 0;
	}
	
	public void addTerms(ProcessedBook book) {
		fileCount = 0;
		posting = 0;
		ProcessedBook b = book;
		int opusNum = b.getOpusNum();
		LinkedList<StringBuilder> words = b.getOpus();
		String line = "";
		for(int i = 0; i<words.size(); i++) {
			line = words.get(i).toString().toLowerCase();
			for(String s : line.split("[\\W_]")) {
				s.trim();
				if(!searchStopList(s)) {
					HashMap<Integer, ArrayList<Integer>> map = index.get(s);
					if (map == null) {
						map = new HashMap<Integer, ArrayList<Integer>>();
						index.put(s, map);
						map.put(opusNum, new ArrayList<Integer>());
						this.fileCount++;
						this.indexCount++;
					} 
					else if (!map.containsKey(opusNum)) {
						map.put(opusNum, new ArrayList<Integer>());
					} 
					if (!map.get(opusNum).contains(i)) {
						map.get(opusNum).add(i);
						posting++;
					}
				}
			}
		}			
	}
	
	public int getPostings() {
		int posting = 0;
		for(String word: this.index.keySet()) {
			HashMap<Integer, ArrayList<Integer>> pList = this.index.get(word);
			for(Integer key: pList.keySet()) {
				posting += pList.get(key).size();
			}   
		}
		return posting;
	}
	
	private boolean searchStopList(String s) {
		return(Arrays.asList(stopList).contains(s));
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
		return this.index.size();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String s: this.index.keySet()) {
			sb.append("Key: "+ s + " Value: "+ this.index.get(s).toString() + "\n");
		}
		return sb.toString();
	}
}
