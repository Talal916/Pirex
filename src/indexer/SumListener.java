package indexer;

import java.util.HashMap;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import indexer.Indexer;
import tabGUI.SumTab;
import textProcessor.ProcessedBook;

public class SumListener implements ChangeListener {
	private SumTab sumtab;
	
	public SumListener(SumTab st) {
		this.sumtab = st;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		sumtab.getTextAreas().setText("");
	    JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
	    int index = sourceTabbedPane.getSelectedIndex();
	    if (sourceTabbedPane.getTitleAt(index).equals("Summarize Documents")) {
	    	HashMap<Integer, ProcessedBook> map = new HashMap<Integer, ProcessedBook>();
	    	Indexer i = new Indexer();
	    	if (map != null && !map.isEmpty()) {
	    		for (Integer key : map.keySet()) {
	    			ProcessedBook book = map.get(key);
	    			StringBuilder sb = new StringBuilder();
	    			sb.append("Opus   " + book.getOpusNum() + ": ");
	    			sb.append(book.getAuthor() + "  " + book.getTitle());
	    			sb.append("   " + book.getParagraphNum() + " documents\n");
	    			sb.append("             " + book.getFile().getAbsolutePath() + "\n" );
	    			sumtab.getTextAreas().append(sb.toString());
	    		}
	    		sumtab.getTextAreas().append("\nIndex terms: "+i.getIndexCount()+"\n");
	    		sumtab.getTextAreas().append("Postings: "+i.getPostings());
	    	}
	    	else
	    	{
	    		sumtab.getTextAreas().append("No files currently saved in Pirex");
	    	}
	    }
	}
}
