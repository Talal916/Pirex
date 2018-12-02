package tabGUI;
import java.awt.*;
import javax.swing.*;

public class summTab extends JPanel{
	
	public summTab() {
		initializeGUI();
	}
	
	public static void frame() {
		JPanel panel = new summTab();
		panel.setOpaque(true);
		
        JFrame frame = new JFrame("Pirex");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                summTab.frame();
            }
        });
	}
	
	private void initializeGUI() {
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.add(new JLabel("Search for user docs dude"));

        // Add Tab
        tabbedPane.addTab("Summarize Documents", dashboardPanel);


        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 200));
        this.add(tabbedPane, BorderLayout.CENTER);
	}
}

		
