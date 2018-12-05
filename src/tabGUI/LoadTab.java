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
import java.awt.Font;
import javax.swing.SwingConstants;


public class LoadTab 
{
	/**
	 * @wbp.parser.entryPoint
	 */
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
	 * @wbp.parser.entryPoint
	 */
	public JPanel loadPanelTab() 
	{
		//Panel for the load tab; interactable by user
		JPanel loadPanel = new JPanel();
		
		loadPanel.setLayout(new BorderLayout());
		loadPanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
		
		processTextAreaL = new JTextArea();
		processTextAreaL.setFont(new Font("Calibri", Font.PLAIN, 22));
		processTextAreaL.setEditable(false);
		
		//Contains the UI file loading elements
		JPanel jPanelTopMostLSection = new JPanel();
		
		jPanelTopMostLSection.setLayout(new BorderLayout());
		
		jPanelTopMostLSection.add(createLoadBox(), BorderLayout.NORTH);
		jPanelTopMostLSection.add(createSectionDivision(), BorderLayout.CENTER);
		jPanelTopMostLSection.add(createProcessButton(), BorderLayout.SOUTH);
		
		loadPanel.add(jPanelTopMostLSection, BorderLayout.NORTH);
		
		//Panel that displays information upon a successful load
		JPanel jPanelCenterLSection = new JPanel();
		
		jPanelCenterLSection.setLayout(new BorderLayout());
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
		textFileLabelL.setFont(new Font("Calibri", Font.BOLD, 22));
		textFileFieldL = new JTextField(TEXTFILEFIELD_LVALUE); 
		textFileFieldL.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		JButton browseButtonL = new JButton(BROWSE);
		browseButtonL.setFont(new Font("Calibri", Font.PLAIN, 22));
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
		textFileTypeL.setFont(new Font("Calibri", Font.BOLD, 22));
		
		String[] types = new String[1];
		types[0] = "Project Gutenberg";
		
		JComboBox textFileTypeComboBoxL = new JComboBox(types);
		textFileTypeComboBoxL.setFont(new Font("Calibri", Font.PLAIN, 22));
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
		textTitleL.setFont(new Font("Calibri", Font.BOLD, 22));
		textTitleFieldL = new JTextField(TEXTTITLEFIELD_LVALUE);
		textTitleFieldL.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		JLabel textAuthorL = new JLabel("Author: ", JLabel.RIGHT);
		textAuthorL.setFont(new Font("Calibri", Font.BOLD, 22));
		textAuthorFieldL = new JTextField(SHORTTEXTFIELD_VALUE);
		textAuthorFieldL.setFont(new Font("Calibri", Font.PLAIN, 22));
		
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
	
	/**
	 * Creates the process button for loading files
	 * @return JPanel with button component named Process
	 */
	private JPanel createProcessButton()
	{
		JPanel processPanel = new JPanel();
		
		processButtonL = new JButton(PROCESS);
		processButtonL.setEnabled(false);
		processButtonL.setFont(new Font("Calibri", Font.BOLD, 22));
		processButtonL.addActionListener(new ProcessorListener(this));
		
		processPanel.setLayout(new BorderLayout());
		processPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, BORDER, PROCESSBUTTON_VALUE));
		processPanel.add(processButtonL, BorderLayout.WEST);
		
		return processPanel;
	}
}