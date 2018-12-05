package tabGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class SumTab 
{
	private JTextArea textAreas;
	final int BORDER_SIZE = 10;
	final Dimension LR_BORDERS = new Dimension(BORDER_SIZE, Integer.MAX_VALUE);
	final Dimension TB_BORDERS = new Dimension(Integer.MAX_VALUE, BORDER_SIZE);
	

	
	public JTextArea getTextAreas() 
	{
		return textAreas;
	}
	


	/**
	 * @wbp.parser.entryPoint
	 */
	public JPanel sumPanelTab() 
	{
		JPanel sumPanel = new JPanel();
		
		//Borders for top and bottom
		Box TBorder = Box.createHorizontalBox();
		Box BBorder = Box.createHorizontalBox();
		TBorder.add(Box.createRigidArea(TB_BORDERS));
		BBorder.add(Box.createRigidArea(TB_BORDERS));
		
		//Borders for side
		Box LBorder = Box.createVerticalBox();
		Box RBorder = Box.createVerticalBox();
		LBorder.add(Box.createRigidArea(LR_BORDERS));
		RBorder.add(Box.createRigidArea(LR_BORDERS));
		
		textAreas = new JTextArea();
		textAreas.setFont(new Font("Calibri", Font.BOLD, 22));
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
