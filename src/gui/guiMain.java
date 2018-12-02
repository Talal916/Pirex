package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class guiMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiMain window = new guiMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1983, 887);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(51, 16, 1804, 713);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(15, 16, 1608, 681);
		panel.add(tabbedPane);
		
		JPanel searchDocs = new JPanel();
		tabbedPane.addTab("Search for Documents", null, searchDocs, null);
		searchDocs.setLayout(null);
		
		JPanel loadDocs = new JPanel();
		tabbedPane.addTab("Load Documents", null, loadDocs, null);
		
		JPanel sumDocs = new JPanel();
		tabbedPane.addTab("Summarize Documents", null, sumDocs, null);
	}

}
