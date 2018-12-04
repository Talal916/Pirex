package tabGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
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


public class LoadTab {
	JFrame frame;
	JTextField textFileFieldL, textTitleFieldL, textAuthorFieldL;
	JTextArea processTextAreaL;
	JButton processButtonL;
	final JFileChooser FC = new JFileChooser();
	final int BORDER = 10;
	final int TEXTFILEFIELD_LVALUE = 43, LONGTEXTFIELD_VALUE = 40, SHORTTEXTFIELD_VALUE = 20, TEXTTITLEFIELD_LVALUE = 28, COMBOBOX_VALUE = 535, PROCESSBUTTON_VALUE = 600;
	final String BROWSE = "Browse";
	final String PROCESS = "Process";

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextFileFieldL() {
		return textFileFieldL;
	}

	public JTextField getTextTitleFieldL() {
		return textTitleFieldL;
	}

	public JTextField getTextAuthorFieldL() {
		return textAuthorFieldL;
	}

	public JTextArea getProcessTextAreaL() {
		return processTextAreaL;
	}

	public JButton getProcessButtonL() {
		return processButtonL;
	}

	public JFileChooser getFC() {
		return FC;
	}

	public String getBROWSE() {
		return BROWSE;
	}

	public String getPROCESS() {
		return PROCESS;
	}

	public JPanel loadPanelTab() {
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
		JPanel jPanelTopMostLSection = new JPanel(); //North part of loadPanel
		JPanel jPanelTopLSection = new JPanel(); //North part of jPanelTopMostLSection
		JPanel jPanelTopLSectionProcessButton = new JPanel(); //Process in north jPanelTopMostLSection
		JPanel jPanelTopLSectionDivision = new JPanel(); //Division in north jPanelTopMostLSection
		JPanel jPanelTopNorthLSection = new JPanel(); //North part of jPanelTopLSection
		JPanel jPanelTopCenterLSection = new JPanel(); //Center part of jPanelTopLSection
		JPanel jPanelTopSouthLSection = new JPanel(); //South part of jPanelTopLSection
		loadPanel.setLayout(new BorderLayout());
		loadPanel.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));
		jPanelTopMostLSection.setLayout(new BorderLayout());
		jPanelTopLSection.setLayout(new BorderLayout());
		jPanelTopLSectionProcessButton.setLayout(new BorderLayout());
		jPanelTopLSectionProcessButton.setBorder(BorderFactory.createEmptyBorder(0, 0, BORDER, PROCESSBUTTON_VALUE));
		jPanelTopLSectionDivision.setLayout(new BorderLayout());
		jPanelTopLSectionDivision.setBorder(BorderFactory.createEmptyBorder(BORDER, 0, BORDER, 0));
		jPanelTopNorthLSection.setLayout(new FlowLayout(FlowLayout.LEFT));
		jPanelTopCenterLSection.setLayout(new FlowLayout(FlowLayout.LEFT));
		jPanelTopSouthLSection.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel jPanelCenterLSection = new JPanel(); //Center part of loadPanel
		jPanelCenterLSection.setLayout(new BorderLayout());
		//Adding all the buttons to the Loading Tab
		jPanelTopLSectionProcessButton.add(processButtonL, BorderLayout.CENTER);
		jPanelTopLSectionDivision.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.CENTER);
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

}
