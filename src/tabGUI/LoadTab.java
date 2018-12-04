package tabGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import textProcessor.ProcessorListener;


public class LoadTab 
{
	JFrame frame;
	JTextField textFileFieldL, textTitleFieldL, textAuthorFieldL;
	JTextArea processTextAreaL;
	JButton processButtonL;
	final JFileChooser FC = new JFileChooser();
	final int BORDER = 10;
	final int TEXTFILEFIELD_LVALUE = 43, LONGTEXTFIELD_VALUE = 40, SHORTTEXTFIELD_VALUE = 20, TEXTTITLEFIELD_LVALUE = 28, COMBOBOX_VALUE = 535, PROCESSBUTTON_VALUE = 600;
	final String BROWSE = "Browse";
	final String PROCESS = "Process";
	
	final Dimension hSpacing = new Dimension(10, 0);
	final Dimension vSpacing = new Dimension(0, 10);

	public JFrame getFrame()
	{
		return frame;
	}

	public JTextField getTextFileFieldL() 
	{
		return textFileFieldL;
	}

	public JTextField getTextTitleFieldL() 
	{
		return textTitleFieldL;
	}

	public JTextField getTextAuthorFieldL() 
	{
		return textAuthorFieldL;
	}

	public JTextArea getProcessTextAreaL() 
	{
		return processTextAreaL;
	}

	public JButton getProcessButtonL() 
	{
		return processButtonL;
	}

	public JFileChooser getFC() 
	{
		return FC;
	}

	public String getBROWSE() 
	{
		return BROWSE;
	}

	public String getPROCESS() 
	{
		return PROCESS;
	}

	/**
	 * Creates the interactable Load panel for loading files to Pirex
	 * @return The load tab for Pirex
	 */
	public JPanel loadPanelTab() 
	{
		//Panel where the connect is added to; what the user sees
		JPanel loadPanel = new JPanel();
		loadPanel.setLayout(new BorderLayout());
		loadPanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
		
		processTextAreaL = new JTextArea();
		processTextAreaL.setEditable(false);
		
		//North part of loadPanel
		JPanel jPanelTopMostLSection = new JPanel();     
		
		jPanelTopMostLSection.setLayout(new BorderLayout());
		
		//center part of loadPanel
		JPanel jPanelCenterLSection = new JPanel();
		jPanelCenterLSection.setLayout(new BorderLayout());
		
		//Adding all the buttons to the Loading Tab
		
		
		jPanelTopMostLSection.add(createLoadBox(), BorderLayout.NORTH);
		jPanelTopMostLSection.add(createSectionDivision(), BorderLayout.CENTER);
		jPanelTopMostLSection.add(createProcessButton(), BorderLayout.SOUTH);
		
		loadPanel.add(jPanelTopMostLSection, BorderLayout.NORTH);
		
		jPanelCenterLSection.add(processTextAreaL, BorderLayout.CENTER);
		
		loadPanel.add(jPanelCenterLSection, BorderLayout.CENTER);
		
		return loadPanel;
	}
	
	/**
	 * Calls the three necessary methods for the load tab GUI construction
	 * for the top section
	 * @return Box with all the contents needed; text file, type, title, and author
	 */
	private Box createLoadBox()
	{
		/*
		 * Create a vertical box
		 * 
		 * Create several horizontal boxes which will contain load tab info
		 * add those boxes to the vertical box
		 * 
		 * Have spacing in between horizontal boxes.
		 */
		Box loadBoxMain = Box.createVerticalBox();
		Box textFileBox = Box.createHorizontalBox();
		Box textFileTypeBox = Box.createVerticalBox();
		Box titleAndAuthorBox = Box.createVerticalBox();
		
		textFileBox = createTextFileBox();
		textFileTypeBox = createTextFileTypeBox();
		titleAndAuthorBox = createTitleAndAuthorBox();
		
		loadBoxMain.add(textFileBox);
		loadBoxMain.add(Box.createRigidArea(vSpacing));
		loadBoxMain.add(textFileTypeBox);
		loadBoxMain.add(Box.createRigidArea(vSpacing));
		loadBoxMain.add(titleAndAuthorBox);
		loadBoxMain.add(Box.createRigidArea(vSpacing));
		
		return loadBoxMain;
	}
	
	/**
	 * Creates a box which displays the selected file 
	 * @return Box with Text File selection
	 * 
	 */
	private Box createTextFileBox() 
	{
		Box textFileBoxContents = Box.createHorizontalBox();
		
		JLabel textFileLabelL = new JLabel("Text File: ", JLabel.RIGHT);
		textFileFieldL = new JTextField(TEXTFILEFIELD_LVALUE); 
		
		JButton browseButtonL = new JButton(BROWSE);
		browseButtonL.addActionListener(new ProcessorListener(this));
		
		textFileBoxContents.add(textFileLabelL);
		textFileBoxContents.add(Box.createRigidArea(hSpacing));
		textFileBoxContents.add(textFileFieldL);
		textFileBoxContents.add(Box.createRigidArea(hSpacing));
		textFileBoxContents.add(browseButtonL);
		
		return textFileBoxContents;
	}
	
	/**
	 * create the box which displays the selection for text file type
	 * @return Box with functionality to change the file which is loaded into system
	 */
	private Box createTextFileTypeBox()
	{
		Box textFileTypeBoxContents = Box.createHorizontalBox();
		
		JLabel textFileTypeL = new JLabel("Text File Type: ", JLabel.RIGHT);
		
		String[] types = new String[1];
		types[0] = "Project Gutenberg";
		
		JComboBox textFileTypeComboBoxL = new JComboBox(types);
		textFileTypeComboBoxL.setPreferredSize(new Dimension(COMBOBOX_VALUE, SHORTTEXTFIELD_VALUE));
		
		textFileTypeBoxContents.add(textFileTypeL);
		textFileTypeBoxContents.add(Box.createRigidArea(hSpacing));
		textFileTypeBoxContents.add(textFileTypeComboBoxL);
		
		return textFileTypeBoxContents;
	}
	
	/**
	 * Creates the title and author fields for display
	 * @return A box which displays the title and author for a loaded file
	 */
	private Box createTitleAndAuthorBox()
	{
		Box titleAndAuthorBoxContents = Box.createHorizontalBox();
		
		JLabel textTitleL = new JLabel("Title: ", JLabel.RIGHT);
		textTitleFieldL = new JTextField(TEXTTITLEFIELD_LVALUE);
		
		JLabel textAuthorL = new JLabel("Author: ", JLabel.RIGHT);
		textAuthorFieldL = new JTextField(SHORTTEXTFIELD_VALUE);
		
		titleAndAuthorBoxContents.add(textTitleL);
		titleAndAuthorBoxContents.add(Box.createRigidArea(hSpacing));
		titleAndAuthorBoxContents.add(textTitleFieldL);
		titleAndAuthorBoxContents.add(Box.createRigidArea(hSpacing));
		titleAndAuthorBoxContents.add(textAuthorL);
		titleAndAuthorBoxContents.add(Box.createRigidArea(hSpacing));
		titleAndAuthorBoxContents.add(textAuthorFieldL);
		
		return titleAndAuthorBoxContents;
	}
	
	/**
	 * Creates the section divider between file info and process button
	 * @return JPanel with a straight horizontal line to act as a divider
	 */
	private JPanel createSectionDivision()
	{
		JPanel jPanelTopLSectionDivision = new JPanel();
		
		jPanelTopLSectionDivision.setLayout(new BorderLayout());
		jPanelTopLSectionDivision.setBorder(BorderFactory.createEmptyBorder(BORDER, 0, BORDER, 0));
		jPanelTopLSectionDivision.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);
		
		return jPanelTopLSectionDivision;
	}
	
	private JPanel createProcessButton()
	{
		JPanel processPanel = new JPanel();
		
		processButtonL = new JButton(PROCESS);
		processButtonL.setEnabled(false);
		processButtonL.addActionListener(new ProcessorListener(this));
		
		processPanel.setLayout(new BorderLayout());
		processPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, BORDER, PROCESSBUTTON_VALUE));
		processPanel.add(processButtonL, BorderLayout.WEST);
		
		return processPanel;
	}
	
}
