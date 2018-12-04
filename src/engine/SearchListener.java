package engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import indexer.Indexer;
import textProcessor.ProcessedBook;
import tabGUI.SearchTab;
import textProcessor.ProcessorListener;

public class SearchListener implements ActionListener, KeyListener, ListSelectionListener {
	private static SearchTab searchTab;
	private HashMap<Integer, ArrayList<Integer>> queryLocations;
	private static Engine engine;
	private static Indexer index = ProcessorListener.getIndex();
	private static Map<String, StringBuilder> format = new LinkedHashMap<String, StringBuilder>();
	private DefaultListModel<String> model;

	public SearchListener(SearchTab st) {
		SearchListener.searchTab = st;
	}
  

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			format.clear();
			int num = 0;
			ProcessedBook result;
			LinkedHashMap<Integer, ProcessedBook> map = ProcessorListener.getBooks();
			engine = new Engine(index);
			engine.addQuery(searchTab.getTextFieldQ().getText());
			if(!engine.queryFound()) {
				model = (DefaultListModel<String>) searchTab.docFound.getModel();
				model.removeAllElements();
				model.addElement("None");
				searchTab.displayCount.setText("Retrieved 0 documents");
			} else {
				model = (DefaultListModel<String>) searchTab.docFound.getModel();
				model.removeAllElements();
				for (String s : Engine.getQuery()) {
					if (engine.queryFound(s)) {
						queryLocations = engine.getHashMap(s);
						if (queryLocations != null) {
							for (Integer key : queryLocations.keySet()) {
								result = map.get(key);
								ArrayList<Integer> register = queryLocations.get(key);
								for (int i = 0; i<register.size(); i++) {
									StringBuilder header = new StringBuilder();
									header.append(" " +result.getAuthor()+"  "+result.getTitle()+"    "+register.get(i) + "  "+result.getShortForm(register.get(i)));
									this.format.put(header.toString(), result.getOpus().get(register.get(i)));
									num++;
								}
							}
							for (String key: format.keySet()) {
								model.addElement(key);
							}
						}
						searchTab.docFound.setModel(model);
						searchTab.displayCount.setText("Retrieved " + num + " documents");
					}
					searchTab.getLongFormOfDocument().setText("");
				}
			}
		}
	}
  
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(searchTab.getClear())) {
			searchTab.getTextFieldQ().setText("");
			format.clear();
    		searchTab.docFound.clearSelection();
    		DefaultListModel model = (DefaultListModel) searchTab.docFound.getModel();
    		model.removeAllElements();
    		searchTab.getLongFormOfDocument().setText("");
		}
	}


	@Override
	public void valueChanged(ListSelectionEvent ev) {
		JList<String> list =  ((JList<String>) ev.getSource());
		if (list.getSelectedValue() != null) {
			String sb = list.getSelectedValue();
			StringBuilder get = format.get(sb);
			searchTab.getLongFormOfDocument().setText(get.toString());
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
    }
  
	@Override
	public void keyTyped(KeyEvent e) {
		
    }
}