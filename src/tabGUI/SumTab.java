package tabGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class SumTab 
{
	private JTextArea textAreas;
	
	
	
	public JTextArea getTextAreas() 
	{
		return textAreas;
	}
	
	public JPanel sumPanelTab() 
	{
		JPanel sumPanel = new JPanel();
		
		Box TBBorders = Box.createHorizontalBox();
		TBBorders.add(Box.createRigidArea(new Dimension(Integer.MAX_VALUE, 10)));
		
		Box LRBorders = Box.createVerticalBox();
		LRBorders.add(Box.createRigidArea(new Dimension(10, Integer.MAX_VALUE)));
		
		textAreas = new JTextArea();
		textAreas.setEditable(false);
		
		JScrollPane scrollPanes = new JScrollPane(textAreas);
		
		sumPanel.setLayout(new BorderLayout());
		
		//Borders for sum tab
		//Currently only these two show up
		sumPanel.add(TBBorders, BorderLayout.SOUTH);
		sumPanel.add(LRBorders, BorderLayout.WEST);
		
		//Top and right don't show up in GUI
		sumPanel.add(TBBorders, BorderLayout.NORTH);
		sumPanel.add(LRBorders, BorderLayout.EAST);
		sumPanel.add(scrollPanes, BorderLayout.CENTER);
		
		return sumPanel;
	}

}
