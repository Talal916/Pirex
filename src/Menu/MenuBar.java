package Menu;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//options menu item with Documents and sources buttons
public class MenuBar {

	JMenuBar menuBar;
	JMenu fileMenu, optionsMenu, helpMenu;
	JMenuItem item, aboutItem, indexItem;
	JFrame frame;

	/**
	 * Default constructor
	 */
	public MenuBar (JFrame frame) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frame = frame;
		
		menuBar = new JMenuBar();

		// The File menu
		fileMenu = new JMenu("File");
		
		
		//Add load query to the file menu
		item = new JMenuItem("Load Query");
		fileMenu.add(item);
		menuBar.add(fileMenu);
						
		//Add save query to the file menu
		item = new JMenuItem("Save Query");
		fileMenu.add(item);
		menuBar.add(fileMenu);

		//Add exit to the file menu
		item = new JMenuItem("Exit");
		fileMenu.add(item);
		menuBar.add(fileMenu);
        item.addActionListener(new exitApp());
		
		// The Options menu
		optionsMenu = new JMenu("Options");
		
		//Add Sources to the options menu
		item = new JMenuItem("Sources");
		optionsMenu.add(item);
		menuBar.add(optionsMenu);

		item = new JMenuItem("Documents");
		optionsMenu.add(item);
		menuBar.add(optionsMenu);
		
		// Help menu
		helpMenu = new JMenu("Help");
		indexItem = new JMenuItem("Index");
		aboutItem = new JMenuItem("About");
		
		//Add Index item to the help menu
		indexItem.addActionListener(new IndexDialog());
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
    class exitApp implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }

    class IndexDialog implements ActionListener{
    	String title = "Index",
    			description = "Load Query: Load previously saved search query\nSave Query: Save current search query\n";
    			
    					public IndexDialog() {
    				
    	    	}
    	    	
    			public void actionPerformed(ActionEvent e) {
    				// Create dialog box
    	    		JOptionPane.showMessageDialog(
    	    				null, 
    	    				description, 
    	    				title, 
    	    				JOptionPane.INFORMATION_MESSAGE
    	    				);
    			}
    			
    }
    
    class AboutDialog implements ActionListener {

    	ImageIcon icon;
    	String title = "About Pirex",
    			description = "Pirex Information Retrieval System ® 2018\nGroup 10 Section 5";
    	
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