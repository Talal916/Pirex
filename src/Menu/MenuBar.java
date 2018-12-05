package Menu;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

//options menu item with Documents and sources buttons
public class MenuBar {

	JMenuBar menuBar;
	JMenu fileMenu, optionsMenu, helpMenu;
	JMenuItem item, aboutItem, indexItem;
	private JMenuItem item_4;
	private JMenuItem item_3;
	private JMenuItem item_2;
	private JMenuItem item_1;
	JFrame frame;

	/**
	 * Default constructor
	 */
	
	public MenuBar (JFrame frame) {
		
		this.frame = frame;
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Calibri", Font.PLAIN, 22));

		// The File menu
		fileMenu = new JMenu("File");
		fileMenu.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		
		//Add load query to the file menu
		item = new JMenuItem("Load Query");
		item.setFont(new Font("Calibri", Font.PLAIN, 22));
		fileMenu.add(item);
		menuBar.add(fileMenu);
						
		//Add save query to the file menu
		item_1 = new JMenuItem("Save Query");
		item_1.setFont(new Font("Calibri", Font.PLAIN, 22));
		fileMenu.add(item_1);
		menuBar.add(fileMenu);

		//Add exit to the file menu
		item_2 = new JMenuItem("Exit");
		item_2.setFont(new Font("Calibri", Font.PLAIN, 22));
		fileMenu.add(item_2);
		menuBar.add(fileMenu);
        item_2.addActionListener(new ExitApp());
		
		// The Options menu
		optionsMenu = new JMenu("Options");
		optionsMenu.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		//Add Sources to the options menu
		item_3 = new JMenuItem("Sources");
		item_3.setFont(new Font("Calibri", Font.PLAIN, 22));
		optionsMenu.add(item_3);
		menuBar.add(optionsMenu);

		item_4 = new JMenuItem("Documents");
		item_4.setFont(new Font("Calibri", Font.PLAIN, 22));
		optionsMenu.add(item_4);
		menuBar.add(optionsMenu);
		
		// Help menu
		helpMenu = new JMenu("Help");
		helpMenu.setFont(new Font("Calibri", Font.PLAIN, 22));
		indexItem = new JMenuItem("Index");
		indexItem.setFont(new Font("Calibri", Font.PLAIN, 22));
		aboutItem = new JMenuItem("About");
		aboutItem.setFont(new Font("Calibri", Font.PLAIN, 22));
		
		//Add Index item to the help menu
		indexItem.addActionListener(new IndexDialog("res/pirex.png"));
		helpMenu.add(indexItem);
		menuBar.add(helpMenu);
		
		// About dialog window
		aboutItem.addActionListener(new AboutDialog("res/transparentPirex.png"));
        // Add to menu bar
		helpMenu.add(aboutItem);
		menuBar.add(helpMenu);
		

		// Add menu bar to frame
		frame.setJMenuBar(menuBar);
	}
}

class ExitApp implements ActionListener
{
	public void actionPerformed(ActionEvent e)
    {
		// Confirm before exiting
		String exitOptions[] = {"Yes","No"};
		JLabel exitPrompt = new JLabel("Are you sure you want to exit?");
		exitPrompt.setFont(new Font("Arial", Font.PLAIN, 24));
		int exitAnswer = JOptionPane.showOptionDialog(
				null,
				exitPrompt,
				"Pirex",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				exitOptions,
				exitOptions[1]
				);
		if(exitAnswer == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
    }
}

class IndexDialog implements ActionListener{
	ImageIcon icon;
	String title = "Index",
			description = "Load Query: Load previously saved search query\nSave Query: Save current search query\n";
			
					public IndexDialog(String filepath) {
						icon = new ImageIcon(filepath);
	    	}
	    	
			public void actionPerformed(ActionEvent e) {
				// Create dialog box
	    		JOptionPane.showMessageDialog(
	    				null, 
	    				description, 
	    				title, 
	    				JOptionPane.INFORMATION_MESSAGE,
	    				icon
	    				);
			}
			
}

class AboutDialog implements ActionListener {

	ImageIcon icon;
	String title = "About Pirex",
			description = "Pirex Information Retrieval System \u00a9 2018\nGroup 10 Section 5";
	
	public AboutDialog(String filepath) {
		icon = new ImageIcon(filepath);
	}
	
	public void actionPerformed(ActionEvent e) {
		// Create dialog box
		JOptionPane.showMessageDialog(
				null, 
				description, 
				title, 
				JOptionPane.INFORMATION_MESSAGE,
				icon
				);
	}
}