package textProcessor;

import java.util.LinkedHashMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import SerializationMethods;

import tabGUI.LoadTab;
import indexer.Indexer;

public class ProcessorListener implements ActionListener {
	private static LoadTab loadTab;
	private Indexer index;
	private static ProcessedBook book;
	private static int num = 0;
	private LinkedHashMap<Integer, ProcessedBook> books = new LinkedHashMap<Integer, ProcessedBook>();

	public ProcessorListener(LoadTab tab) {
		ProcessorListener.loadTab = tab;
	}
	  
	@Override
	public void actionPerformed(ActionEvent e) {

	    //LinkedHashMap<String, GutenbergBook> map = this.deserialize();
		//books = SerializationMethods.deserializeBooks();
		if (e.getActionCommand().equals(loadTab.getBROWSE())) {
			int browseVal = loadTab.getFC().showOpenDialog(loadTab.getFrame());
			if (browseVal == JFileChooser.APPROVE_OPTION) {
				if (books != null) num = books.size();
	        book = new ProcessedBook(loadTab.getFC().getSelectedFile(), num);
	        //JOptionPane.showMessageDialog(loadTab.getFrame(), "Loaded the document");
	        loadTab.getTextFileFieldL().setText((loadTab.getFC().getSelectedFile().getAbsolutePath()));
	        loadTab.getTextTitleFieldL().setText((book.getTitle()));
	        loadTab.getTextAuthorFieldL().setText((book.getAuthor()));
	        loadTab.getProcessButtonL().setEnabled(true);
			}
		} 
	    else if (e.getActionCommand().equals(loadTab.getPROCESS())) {
	    	book.setAuthor(loadTab.getTextAuthorFieldL().getText()); 
	    	book.setTitle(loadTab.getTextTitleFieldL().getText());
	    	if (books == null) {
	    		books = new LinkedHashMap<Integer, ProcessedBook>();
	    	}
	      
	    	//if(books.containsKey(book.getTitle()))
	    	if (books.containsKey(book.getOpusNum())) {
	    		JOptionPane.showMessageDialog(loadTab.getFrame(), "This opus has been processed already.", "Process Error", JOptionPane.WARNING_MESSAGE);
	    		loadTab.getProcessTextAreaL().setText("");
	    	}
	    	else {
	        books.put(book.getOpusNum(), book);
	        //SerializationMethods.serializeBooks(books);
	        if (index == null) {
	      	  	index = new Indexer();
	        }
	        index.addTerms(book);
	        //SerializationMethods.serializeIndexer(index);
	        System.out.print(index.toString());
	        //System.out.printf("Serialized data is saved"); 
	        loadTab.getTextFileFieldL().setText("");
	        loadTab.getTextTitleFieldL().setText("");
	        loadTab.getTextAuthorFieldL().setText("");
	        loadTab.getProcessTextAreaL().setText("Opus: " + book.getFile().getAbsolutePath()+"\n"
	      					+"Title: " + book.getTitle()+"\n"
	      					+"Author: " + book.getAuthor() +"\n"
	      					+ "Opus Size: " + book.getParagraphNum() + " documents\n"
	      					+"Opus number: " + book.getOpusNum() + "\n"
	      					+"New index terms: " + index.getSize() + "\n"
	      					+"New postings: "+ index.getPosting() + "\n"
	      					+"Total index terms: " + index.getIndexCount() + "\n"
	      					+"Total postings: " + index.getPostings() + "\n");
	        loadTab.getProcessButtonL().setEnabled(false);
	        num++;
	    	}
	    }
	}
}
