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
		
		JLabel textFileLabelL = new JLabel("Text File: ", JLabel.RIGHT);
		textFileFieldL = new JTextField(TEXTFILEFIELD_LVALUE); 
		
		JButton browseButtonL = new JButton(BROWSE);
		browseButtonL.addActionListener(new ProcessorListener(this));
		
		JLabel textFileTypeL = new JLabel("Text File Type: ", JLabel.RIGHT);
		String[] types = new String[1];
		types[0] = "Project Gutenberg";
		JComboBox textFileTypeComboBoxL = new JComboBox(types);
		textFileTypeComboBoxL.setPreferredSize(new Dimension(COMBOBOX_VALUE, SHORTTEXTFIELD_VALUE));
		
		JLabel textTitleL = new JLabel("Title: ", JLabel.RIGHT);
		textTitleFieldL = new JTextField(TEXTTITLEFIELD_LVALUE);
		
		JLabel textAuthorL = new JLabel("Author: ", JLabel.RIGHT);
		textAuthorFieldL = new JTextField(SHORTTEXTFIELD_VALUE);
		
		processButtonL = new JButton(PROCESS);
		processButtonL.setEnabled(false);
		processButtonL.addActionListener(new ProcessorListener(this));
		
		processTextAreaL = new JTextArea();
		processTextAreaL.setEditable(false);
		
		//North part of loadPanel
		JPanel jPanelTopMostLSection = new JPanel(); 
		
		//North part of jPanelTopMostLSection
		JPanel jPanelTopLSection = new JPanel(); 
		
		//Process in north jPanelTopMostLSection
		JPanel jPanelTopLSectionProcessButton = new JPanel(); 
		
		//Division in north jPanelTopMostLSection; The line between info and process button
		JPanel jPanelTopLSectionDivision = new JPanel(); 
		
		//North part of jPanelTopLSection; contains text file
		JPanel jPanelTopNorthLSection = new JPanel(); 
		
		//Center part of jPanelTopLSection; contains text file type
		JPanel jPanelTopCenterLSection = new JPanel(); 
		
		//South part of jPanelTopLSection; contains title & author
		JPanel jPanelTopSouthLSection = new JPanel(); 
		
		loadPanel.setLayout(new BorderLayout());
		loadPanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
		
		jPanelTopMostLSection.setLayout(new BorderLayout());
		
		jPanelTopLSection.setLayout(new BorderLayout());
		
		jPanelTopLSectionProcessButton.setLayout(new BorderLayout());
		jPanelTopLSectionProcessButton.setBorder(BorderFactory.createEmptyBorder(0, 0, BORDER, PROCESSBUTTON_VALUE));
		
		jPanelTopLSectionDivision.setLayout(new BorderLayout());
		jPanelTopLSectionDivision.setBorder(BorderFactory.createEmptyBorder(BORDER, 0, BORDER, 0));
		
		//Top of load tab set to be left aligned
		jPanelTopNorthLSection.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		jPanelTopCenterLSection.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		jPanelTopSouthLSection.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//center part of loadPanel
		JPanel jPanelCenterLSection = new JPanel();
		jPanelCenterLSection.setLayout(new BorderLayout());
		
		//Adding all the buttons to the Loading Tab
		jPanelTopLSectionProcessButton.add(processButtonL, BorderLayout.WEST);
		jPanelTopLSectionDivision.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);
		
//		Box jPanelTopNorthBox = Box.createHorizontalBox();
		
		jPanelTopNorthLSection.add(textFileLabelL);
		jPanelTopNorthLSection.add(textFileFieldL);
		jPanelTopNorthLSection.add(browseButtonL);
		
		jPanelTopLSection.add(jPanelTopNorthLSection, BorderLayout.NORTH);
		
		jPanelTopCenterLSection.add(textFileTypeL);
		jPanelTopCenterLSection.add(textFileTypeComboBoxL);
		
		jPanelTopLSection.add(jPanelTopCenterLSection, BorderLayout.CENTER);
		
		jPanelTopSouthLSection.add(textTitleL);
		jPanelTopSouthLSection.add(textTitleFieldL);
		jPanelTopSouthLSection.add(textAuthorL);
		jPanelTopSouthLSection.add(textAuthorFieldL);
		
		jPanelTopLSection.add(jPanelTopSouthLSection, BorderLayout.SOUTH);
		
		jPanelTopMostLSection.add(jPanelTopLSection, BorderLayout.NORTH);
		jPanelTopMostLSection.add(jPanelTopLSectionDivision, BorderLayout.CENTER);
		jPanelTopMostLSection.add(jPanelTopLSectionProcessButton, BorderLayout.SOUTH);
		
		loadPanel.add(jPanelTopMostLSection, BorderLayout.NORTH);
		
		jPanelCenterLSection.add(processTextAreaL, BorderLayout.CENTER);
		
		loadPanel.add(jPanelCenterLSection, BorderLayout.CENTER);
		
		return loadPanel;
	}
	
//	private Box createLoadBox()
//	{
//		Box loadBoxMain = 
//		
//	}
}
