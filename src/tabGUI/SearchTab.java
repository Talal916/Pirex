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

public class SearchTab 
{
	JTextField textFieldQ;
	TextArea searchDocumentsFound; 
	TextArea longFormOfDocument;
	public JTextField displayCount;
	final int BORDER = 10;
	final int TEXTFIELD_QVALUE = 45, LONGTEXTFIELD_VALUE = 40, SHORTTEXTFIELD_VALUE = 20;
	final int VISIBLE_ROW_COUNT = 10, FIXED_CELL_HEIGHT = 15, FIXED_CELL_WIDTH = 100;
	final String CLEAR = "Clear";
	public static JList<String> docFound = new JList<String>();
	static JScrollPane shortFormOfDocument;

	public TextArea getLongFormOfDocument() 
	{
		return longFormOfDocument;
	}

	public TextArea getSearchDocumentsFound() 
	{
		return searchDocumentsFound;
	}

	public JTextField getTextFieldQ() 
	{
		return textFieldQ;
	}

	public String getClear() 
	{
		return CLEAR;
	}
	
	public JPanel searchPanelTab() 
	{
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
		searchDocumentsFound = new TextArea();
		
		//text field to type in query
		textFieldQ = new JTextField(TEXTFIELD_QVALUE);
		textFieldQ.addKeyListener(new SearchListener(this));
		
		//DisplayCount is the number of documents that were returned from the search
		displayCount = new JTextField(LONGTEXTFIELD_VALUE);
		displayCount.setEditable(false);
		displayCount.setMinimumSize(new Dimension(Integer.MAX_VALUE, 20));
		displayCount.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
		displayCount.setBorder(null);
		displayCount.setText("No Documents currently searched");
		
		//Adding buttons to the Searching Tab
		searchPanel.setLayout(new BorderLayout());
		JPanel jPanelQ1 = new JPanel();
		jPanelQ1.add(labelQ);
		jPanelQ1.add(textFieldQ);
		jPanelQ1.add(clearButtonQ);
		searchPanel.add(jPanelQ1,  BorderLayout.NORTH);
		Box box = Box.createVerticalBox();
		
		//short form display for search results
		shortFormOfDocument  = new JScrollPane(docFound);
		shortFormOfDocument.setMinimumSize(new Dimension(Integer.MAX_VALUE, 153));
		shortFormOfDocument.setMaximumSize(new Dimension(Integer.MAX_VALUE, 153));
		box.add(shortFormOfDocument);
		
		box.add(Box.createRigidArea(new Dimension(0, 5)));
		
		box.add(displayCount);
		
		box.add(Box.createRigidArea(new Dimension(0, 5)));
		
		//long form display of documents
		longFormOfDocument = new TextArea();
		longFormOfDocument.setMinimumSize(new Dimension(Integer.MAX_VALUE, 200));
		box.add(longFormOfDocument);
		
		searchPanel.add(box, BorderLayout.CENTER);
		searchPanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
		
		return searchPanel;
	}
}