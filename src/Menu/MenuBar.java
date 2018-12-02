package Menu;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//options menu item with Documents and sources buttons
public class MenuBar {

	
	JMenuBar menuBar;
	JMenu fileMenu, optionsMenu, helpMenu;
	JMenuItem item, aboutItem;
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

		item = new JMenuItem("Exit");
		fileMenu.add(item);
		menuBar.add(fileMenu);
        item.addActionListener(new exitApp());
		
		// The Options menu
		optionsMenu = new JMenu("Options");

		item = new JMenuItem("Sources");
		optionsMenu.add(item);
		menuBar.add(optionsMenu);

		item = new JMenuItem("Documents");
		optionsMenu.add(item);
		menuBar.add(optionsMenu);
		
		// Help menu
		helpMenu = new JMenu("Help");
		aboutItem = new JMenuItem("About");
		
		// About window
		
		item.addActionListener(new AboutDialog());
        // Add to menu bar
		helpMenu.add(aboutItem);
		menuBar.add(helpMenu);

		// The menu bar
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

    class AboutDialog implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
    		JOptionPane.showMessageDialog(
    				null, 
    				"About Pirex", 
    				"Pirex", 
    				JOptionPane.INFORMATION_MESSAGE
    				);
		}
    }