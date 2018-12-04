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
	final int BORDER_SIZE = 10;
	
	
	public JTextArea getTextAreas() 
	{
		return textAreas;
	}
	
	public JPanel sumPanelTab() 
	{
		JPanel sumPanel = new JPanel();
		
		//Borders for top and bottom
		Box TBorder = Box.createHorizontalBox();
		Box BBorder = Box.createHorizontalBox();
		TBorder.add(Box.createRigidArea(new Dimension(Integer.MAX_VALUE, BORDER_SIZE)));
		BBorder.add(Box.createRigidArea(new Dimension(Integer.MAX_VALUE, BORDER_SIZE)));
		
		//Borders for side
		Box LBorder = Box.createVerticalBox();
		Box RBorder = Box.createVerticalBox();
		LBorder.add(Box.createRigidArea(new Dimension(BORDER_SIZE, Integer.MAX_VALUE)));
		RBorder.add(Box.createRigidArea(new Dimension(BORDER_SIZE, Integer.MAX_VALUE)));
		
		textAreas = new JTextArea();
		textAreas.setEditable(false);
		
		JScrollPane scrollPanes = new JScrollPane(textAreas);
		
		sumPanel.setLayout(new BorderLayout());
		
		//Add borders to sum tab
		sumPanel.add(TBorder, BorderLayout.NORTH);
		sumPanel.add(RBorder, BorderLayout.EAST);
		sumPanel.add(BBorder, BorderLayout.SOUTH);
		sumPanel.add(LBorder, BorderLayout.WEST);
		
		sumPanel.add(scrollPanes, BorderLayout.CENTER);
		
		return sumPanel;
	}

}
