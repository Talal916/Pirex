package textProcessor;

import java.util.LinkedList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class ProcessedBook {
	private LinkedList<StringBuilder> opus;
	private int opusNum;
	private File book;
	private String title;
	private String author;
	private int paragraphNum;
	
	public ProcessedBook(File file, int num) {
		opus = new LinkedList<StringBuilder>();
		opusNum = num;
		book = file;
		title = "";
		author = "";
		readBook();
	}

	public void readBook() {
		try {
			FileReader fr = new FileReader(book.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line = "";
			while((line = br.readLine()) != null) {
				if(line.contains("Title: ")) {
					if(line.substring(7).equals("")) title = "None";
					else title = line.substring(7); 
				}
				if(line.contains("Author: ")) {
					if(line.substring(8).equals("")) author = "Anonymous";
					else author = line.substring(8); 
				}
				if(line.contains("***START") || line.contains("*** START")) {
					while((((line = br.readLine()) != null) && !(line.contains("***END") || line.contains("*** END")))) {
					  if (!line.equals("")) sb.append(line + "\n");
					  else {
						  if (!sb.toString().equals("")) {
							  opus.add(sb);
							  paragraphNum++;
						  }
						  sb = new StringBuilder();
					  	}
					}
				}    
			}
			br.close();	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public String getShortForm(int i) {
		String[] s = opus.get(i).toString().split("\\W");
		String sf = "";
		int count = 0;
		while((s.length-1)>count) {
			sf += s[count] + " ";
			count++;
		}
		return sf;
	}
	
	public LinkedList<StringBuilder> getOpus() {
		return opus;
	}
	
	public int getOpusNum() {
		return opusNum;
	}
	
	public File getFile() {
		return book;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}	

	public int getParagraphNum() {
	  return paragraphNum;
	}
		
	public void setTitle(String name) {
		title = name;
	}
	
	public void setAuthor(String person) {
		author = person;
	}
}
