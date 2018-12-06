package indexer;

import java.util.HashMap;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import indexer.Indexer;
import tabGUI.SumTab;
import textProcessor.ProcessedBook;
import textProcessor.ProcessorListener;

public class SumListener implements ChangeListener {
	private SumTab sumtab;
	
	public SumListener(SumTab st) {
		this.sumtab = st;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
	    JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
	    int i = sourceTabbedPane.getSelectedIndex();
	    if (sourceTabbedPane.getTitleAt(i).equals("Summarize Documents")) {
	    	Indexer index = ProcessorListener.getIndex();
	    	HashMap<Integer, ProcessedBook> map = ProcessorListener.getBooks();
	    	StringBuilder sb = new StringBuilder();
	    	if (map.size() != 0) {
	    		for (Integer key : map.keySet()) {
	    			sumtab.getTextAreas().setText("");
	    			ProcessedBook book = map.get(key);
	    			sb.append("Opus " + book.getOpusNum() + ": " + book.getTitle() + ", by " + book.getAuthor() + "; " + book.getParagraphNum() + " total paragraphs" + "\n" + book.getFile().getAbsolutePath() + "\n");
	    			sumtab.getTextAreas().append(sb.toString());
	    		}
	    		sumtab.getTextAreas().append("\nIndex terms: "+index.getIndexCount()+"\n");
	    		sumtab.getTextAreas().append("Postings: "+index.getPostings());
	    	}
	    	else {
	    		sumtab.getTextAreas().append("No files currently saved in Pirex"); 
	    	}
	    }
	}
}
