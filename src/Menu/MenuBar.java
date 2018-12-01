package Menu;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//options menu item with Documents and sources buttons
public class MenuBar extends JFrame{

	
	JMenuBar menuBar;
	JMenu fileMenu, optionsMenu;
	JMenuItem item;

	/**
	 * Default constructor
	 */
	public MenuBar () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

		// The menu bar
		setJMenuBar(menuBar);
	}
}
    class exitApp implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
