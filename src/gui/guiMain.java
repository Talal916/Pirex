package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Container;

import tabGUI.LoadTab;
import tabGUI.SearchTab;

import javax.swing.JPanel;

public class guiMain {

	private JFrame frame;
	private LoadTab loadtab = new LoadTab();
	private SearchTab searchTab = new SearchTab();
	private Container contentPane;

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
		contentPane = frame.getContentPane();
		
		/*JPanel panel = new JPanel();
		panel.setBounds(51, 16, 1804, 713);
		frame.getContentPane().add(panel);
		panel.setLayout(null);*/
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(15, 16, 1608, 681);
		contentPane.add(tabbedPane);
		
		JPanel searchDocs = searchTab.searchPanelTab();
		tabbedPane.addTab("Search for Documents", null, searchDocs, null);
		//searchDocs.setLayout(null);
		
		JPanel loadDocs = loadtab.loadPanelTab();
		tabbedPane.addTab("Load Documents", null, loadDocs, null);
		
		
		JPanel sumDocs = new JPanel();
		tabbedPane.addTab("Summarize Documents", null, sumDocs, null);
	}

}
