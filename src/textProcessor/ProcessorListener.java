package textProcessor;

import java.util.LinkedHashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import tabGUI.LoadTab;
import indexer.Indexer;

public class ProcessorListener implements ActionListener {
	private static LoadTab loadTab;
	private static LinkedHashMap<Integer, ProcessedBook> books = new LinkedHashMap<Integer, ProcessedBook>();
	private static Indexer index = new Indexer();
	private static ProcessedBook book;
	private int num = 0;

	public ProcessorListener(LoadTab tab) {
		ProcessorListener.loadTab = tab;
	}
	
	public static Indexer getIndex() {
		return index;
	}
	
	public static LinkedHashMap <Integer, ProcessedBook> getBooks() {
		return books;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(loadTab.getBROWSE())) {
			int browseVal = loadTab.getFC().showOpenDialog(loadTab.getFrame());
			num++;
			if (browseVal == JFileChooser.APPROVE_OPTION) {
				book = new ProcessedBook(loadTab.getFC().getSelectedFile(), num);
				JOptionPane.showMessageDialog(loadTab.getFrame(), "Loaded the document");
				loadTab.getTextFileFieldL().setText((loadTab.getFC().getSelectedFile().getAbsolutePath()));
				loadTab.getTextTitleFieldL().setText((book.getTitle()));
				loadTab.getTextAuthorFieldL().setText((book.getAuthor()));
				loadTab.getProcessButtonL().setEnabled(true);
			}
		} 
	    else if (e.getActionCommand().equals(loadTab.getPROCESS())) {
	    	book.setTitle(loadTab.getTextTitleFieldL().getText());
	    	book.setAuthor(loadTab.getTextAuthorFieldL().getText());
	    	if (checkDuplicate(book.getTitle())) {
	    		JOptionPane.showMessageDialog(loadTab.getFrame(), "This opus has been processed already.", "Process Error", JOptionPane.WARNING_MESSAGE);
	    		loadTab.getProcessTextAreaL().setText("");
	    	} else {
	    		books.put(book.getOpusNum(), book);
	    		index.addTerms(book);
	    		loadTab.getTextFileFieldL().setText("");
	    		loadTab.getTextTitleFieldL().setText("");
	    		loadTab.getTextAuthorFieldL().setText("");
	    		loadTab.getProcessTextAreaL().setText("Opus: " + book.getFile().getAbsolutePath() + "\n" + "Title: " + book.getTitle() + "\n" + "Author: " + book.getAuthor() + "\n" + "Opus Size: " + book.getParagraphNum() + " paragraphs\n" + "Opus number: " + book.getOpusNum() + "\n" + "New index terms: " + index.getSize() + "\n" + "New postings: " + index.getPosting() + "\n" + "Total index terms: " + index.getIndexCount() + "\n" + "Total postings: " + index.getPostings() + "\n");
	    		loadTab.getProcessButtonL().setEnabled(false);
	    	}
	    }
	}
	
	public boolean checkDuplicate(String s) {
		s = s.trim();
		for(Integer i : books.keySet()) {
			if (books.get(i).getTitle().equalsIgnoreCase(s)) return true;
		}
		return false;
	}
}
