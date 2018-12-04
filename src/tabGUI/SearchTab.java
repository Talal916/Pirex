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
	
	final Dimension QUERY_SPACING = new Dimension(10, 0);
	final Dimension V_SPACING = new Dimension (0, 5);
	final Dimension DISPLAY_COUNT_SIZE = new Dimension(Integer.MAX_VALUE, 20);
	final Dimension SHORT_FORM_SIZE = new Dimension(Integer.MAX_VALUE, 153);
	final Dimension LONG_FORM_SIZE = new Dimension(Integer.MAX_VALUE, 200);
	
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
		searchPanel.setLayout(new BorderLayout());
		
		JLabel labelQ = new JLabel("Query: ", JLabel.RIGHT);
		JButton clearButtonQ = new JButton(CLEAR);
		clearButtonQ.addActionListener(new SearchListener(this));

		searchDocumentsFound = new TextArea();
		
		//text field to type in query
		textFieldQ = new JTextField(TEXTFIELD_QVALUE);
		textFieldQ.addKeyListener(new SearchListener(this));
		
		//Adding buttons to the Searching Tab
		
		//Keeps the query search box left aligned and resizes with screen
		Box boxQuery = Box.createHorizontalBox();
		
		boxQuery.add(labelQ);
		boxQuery.add(Box.createRigidArea(QUERY_SPACING));
		boxQuery.add(textFieldQ);
		boxQuery.add(Box.createRigidArea(QUERY_SPACING));
		boxQuery.add(clearButtonQ);
		
		searchPanel.add(boxQuery, BorderLayout.NORTH);
		
		Box resultBox = createSearchResultBox();
		
		searchPanel.add(resultBox, BorderLayout.CENTER);
		searchPanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
		
		return searchPanel;
	}
	
	/**
	 * Creates a vertical box for displaying contents of a successful search
	 * @return Box - Vertical box; Contains short form, docs found, and long form
	 */
	private Box createSearchResultBox()
	{
		Box box = Box.createVerticalBox();
		
		box.add(Box.createRigidArea(new Dimension(Integer.MAX_VALUE, 10)));
		
		//short form display for search results
		shortFormOfDocument  = new JScrollPane(docFound);
		shortFormOfDocument.setMinimumSize(SHORT_FORM_SIZE);
		shortFormOfDocument.setMaximumSize(SHORT_FORM_SIZE);
		
		box.add(shortFormOfDocument);
		
		box.add(Box.createRigidArea(V_SPACING));
		
		//DisplayCount is the number of documents that were returned from the search
		displayCount = new JTextField(LONGTEXTFIELD_VALUE);
		displayCount.setEditable(false);
		displayCount.setMinimumSize(DISPLAY_COUNT_SIZE);
		displayCount.setMaximumSize(DISPLAY_COUNT_SIZE);
		displayCount.setBorder(null);
		displayCount.setText("No Documents currently searched");
		
		box.add(displayCount);
		
		box.add(Box.createRigidArea(V_SPACING));
		
		//long form display of documents
		longFormOfDocument = new TextArea();
		longFormOfDocument.setMinimumSize(LONG_FORM_SIZE);
		box.add(longFormOfDocument);
		
		return box;
	}
}