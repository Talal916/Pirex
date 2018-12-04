package tabGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	final int DISPLAY_COUNT_MAX_SIZE = 20, SHORT_FORM_MAX_SIZE = 153, LONG_FORM_MAX_SIZE = 200;
	final Dimension QUERY_SPACING = new Dimension(10, 0);
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
		displayCount.setMinimumSize(new Dimension(Integer.MAX_VALUE, DISPLAY_COUNT_MAX_SIZE));
		displayCount.setMaximumSize(new Dimension(Integer.MAX_VALUE, DISPLAY_COUNT_MAX_SIZE));
		displayCount.setBorder(null);
		displayCount.setText("No Documents currently searched");
		
		//Adding buttons to the Searching Tab
		searchPanel.setLayout(new BorderLayout());
		
		//Keeps the query search box left aligned and resizes with screen
		Box boxQuery = Box.createHorizontalBox();
		
		boxQuery.add(labelQ);
		boxQuery.add(Box.createRigidArea(QUERY_SPACING));
		boxQuery.add(textFieldQ);
		boxQuery.add(Box.createRigidArea(QUERY_SPACING));
		boxQuery.add(clearButtonQ);
		searchPanel.add(boxQuery, BorderLayout.NORTH);
		
		Box box = Box.createVerticalBox();
		
		box.add(Box.createRigidArea(new Dimension(Integer.MAX_VALUE, 10)));
		
		//short form display for search results
		shortFormOfDocument  = new JScrollPane(docFound);
		shortFormOfDocument.setMinimumSize(new Dimension(Integer.MAX_VALUE, SHORT_FORM_MAX_SIZE));
		shortFormOfDocument.setMaximumSize(new Dimension(Integer.MAX_VALUE, SHORT_FORM_MAX_SIZE));
		box.add(shortFormOfDocument);
		
		box.add(Box.createRigidArea(new Dimension(0, 5)));
		
		box.add(displayCount);
		
		box.add(Box.createRigidArea(new Dimension(0, 5)));
		
		//long form display of documents
		longFormOfDocument = new TextArea();
		longFormOfDocument.setMinimumSize(new Dimension(Integer.MAX_VALUE, LONG_FORM_MAX_SIZE));
		box.add(longFormOfDocument);
		
		searchPanel.add(box, BorderLayout.CENTER);
		searchPanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
		
		return searchPanel;
	}
}