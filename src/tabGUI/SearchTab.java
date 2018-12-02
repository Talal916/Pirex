package tabGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import engine.SearchListener;

public class SearchTab {
	JTextField textFieldQ;
	TextArea searchDocumentsFound; 
	TextArea longFormOfDocument;
	public JTextField displayCount;
	final int BORDER = 10;
	final int TEXTFIELD_QVALUE = 45, LONGTEXTFIELD_VALUE = 40, SHORTTEXTFIELD_VALUE = 20;
	final int VISIBLE_ROW_COUNT = 10, FIXED_CELL_HEIGHT = 15, FIXED_CELL_WIDTH = 100;
	final String CLEAR = "Clear";
	public static JList<String> docFound = new JList<String>();
	static JScrollPane scrollPane;

	public TextArea getLongFormOfDocument() {
		return longFormOfDocument;
	}

	public TextArea getSearchDocumentsFound() {
		return searchDocumentsFound;
	}

	public JTextField getTextFieldQ() {
		return textFieldQ;
	}

	public String getClear() {
		return CLEAR;
	}
	
	public JPanel searchPanelTab() {
		DefaultListModel<String> model = new DefaultListModel<String>();
		docFound.setModel(model);
		docFound.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		docFound.setLayoutOrientation(JList.VERTICAL);
		docFound.setVisibleRowCount(VISIBLE_ROW_COUNT);
		docFound.setFixedCellHeight(FIXED_CELL_HEIGHT);
		docFound.setFixedCellWidth(FIXED_CELL_WIDTH);
		docFound.addListSelectionListener(new SearchListener(this));
		JPanel searchPanel = new JPanel();
		JLabel labelQ = new JLabel("Query: ", JLabel.RIGHT);
		JButton clearButtonQ = new JButton(CLEAR);
		clearButtonQ.addActionListener(new SearchListener(this));
		textFieldQ = new JTextField(TEXTFIELD_QVALUE);
		textFieldQ.addKeyListener(new SearchListener(this));
		displayCount = new JTextField(LONGTEXTFIELD_VALUE);
		displayCount.setEditable(false);
		//Adding buttons to the Searching Tab
		searchPanel.setLayout(new BorderLayout());
		JPanel jPanelQ1 = new JPanel();
		jPanelQ1.add(labelQ);
		jPanelQ1.add(textFieldQ);
		jPanelQ1.add(clearButtonQ);
		searchPanel.add(jPanelQ1,  BorderLayout.NORTH);
		Box box = Box.createVerticalBox();
		scrollPane  = new JScrollPane(docFound);
		searchDocumentsFound = new TextArea();
		box.add(scrollPane);
		box.add(displayCount);
		displayCount.setText("No Documents currently searched");
		longFormOfDocument = new TextArea();
		box.add(longFormOfDocument);
		searchPanel.add(box, BorderLayout.CENTER);
		searchPanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
		return searchPanel;
	}
}
