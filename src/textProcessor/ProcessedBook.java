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
	private String text;
	private int paragraphNum;
	private static final int LINE_AUTHOR_STARTS = 8;
	private static final int LINE_TITLE_STARTS = 7;
	
	//Constructor receives a gutenberg text file as well as the opus number. 
	//It then calls readBook() to set the author, title, and the text.
	
	public ProcessedBook(File file, int num) {
		opus = new LinkedList<StringBuilder>();
		opusNum = num;
		book = file;
		title = "";
		author = "";
		text = "";
		readBook();
	}
	
	//processes text file to find relevant information like author and title
	//adds each paragraph as a node to the opus
	public void readBook() {
		String line = null;
		try {
			FileReader fileReader = new FileReader(book.getAbsolutePath());
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuilder paragraph = new StringBuilder();
			while(((line = bufferedReader.readLine()) != null)) {
				if(line.contains("Author: ")) {
					if(line.substring(LINE_AUTHOR_STARTS).equals("")) author = "Anonymous";
					else author = line.substring(LINE_AUTHOR_STARTS);
				}
				if(line.contains("Title: ")) {
					if(line.substring(LINE_TITLE_STARTS).equals("")) title = "None";
					else title = line.substring(LINE_TITLE_STARTS);
				}
				if(line.contains("*** START OF") || line.contains("***START OF")) {
					while(((line = bufferedReader.readLine()) != null) && !(line.contains("*** END OF ") || line.contains("***END OF "))) {
					  if (!line.equals("")) paragraph.append(line + "\n");
					  else {
						  if (!paragraph.toString().equals("")) {
						    this.opus.add(paragraph);
						    paragraphNum++;
						  }
						  paragraph = new StringBuilder();
					  	}
					}
				}    
			}
			bufferedReader.close();	
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	//finds opus by its index number and then creates a String[] of each word
	//will essentially return the first 50 words found in the opus
	public String getShortForm(int index) {
		String[] words = opus.get(index).toString().split(" ");
		String line = "";
		int count = 0;
		boolean cont = true;
		while(cont) {
			line += words[count] + " ";
			cont = ((words.length-1)>count) && (line.length()<50);
			count++;
		}
		return line;
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
	
	public String getText() {
		return text;
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
