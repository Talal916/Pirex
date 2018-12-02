package tabGUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SumTab {
	private JTextArea textAreas;
	
	public JTextArea getTextAreas() {
		return textAreas;
	}
	
	public JPanel sumPanelTab() {
		JPanel sumPanel = new JPanel();
		textAreas = new JTextArea();
		textAreas.setEditable(false);
		JScrollPane scrollPanes = new JScrollPane(textAreas);
		sumPanel.setLayout(new BorderLayout());
		sumPanel.add(scrollPanes, BorderLayout.CENTER);
		return sumPanel;
	}

}
