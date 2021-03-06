package gui;

import java.awt.EventQueue; 
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import Menu.MenuBar;

import java.awt.Container;
import java.awt.Dimension;

import tabGUI.LoadTab;
import tabGUI.SearchTab;
import tabGUI.SumTab;
import indexer.SumListener;

import javax.swing.JPanel;
import java.awt.event.WindowEvent;  
import java.awt.event.WindowListener;  
import java.awt.event.WindowAdapter;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public class guiMain extends Frame implements WindowListener
{
	private static final long serialVersionUID = 1L;
	private JFrame frmPirexDocumentRetrieval;
	private LoadTab loadtab = new LoadTab();
	private SearchTab searchTab = new SearchTab();
	private SumTab sumTab = new SumTab();
	private Container contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiMain window = new guiMain();
					window.frmPirexDocumentRetrieval.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiMain() 
	{
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		// Sets menu bar for macOS
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		
		frmPirexDocumentRetrieval = new JFrame();
		frmPirexDocumentRetrieval.setTitle("Pirex"); //set window title/
		frmPirexDocumentRetrieval.setBounds(0, 0, 700, 600);
		
		//Minimum size of window that looks reasonable 
		frmPirexDocumentRetrieval.setMinimumSize(new Dimension(1400, 600));
		frmPirexDocumentRetrieval.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane = frmPirexDocumentRetrieval.getContentPane();
		
		//close handling
		WindowAdapter windowCloseHandler = new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
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
		};
		
		// Set icon
		ImageIcon icon = new ImageIcon("res/transparentX.png");
		frmPirexDocumentRetrieval.setIconImage(icon.getImage());
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Calibri", Font.BOLD, 45));
		tabbedPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		tabbedPane.setBounds(15, 16, 1608, 681);
		contentPane.add(tabbedPane);
		
		JPanel searchDocs = searchTab.searchPanelTab();
		tabbedPane.addTab("Search for Documents", null, searchDocs, null);
		//searchDocs.setLayout(null);
		
		JPanel loadDocs = loadtab.loadPanelTab();
		tabbedPane.addTab("Load Documents", null, loadDocs, null);
		
		JPanel sumDocs = sumTab.sumPanelTab();
		tabbedPane.addTab("Summarize Documents", null, sumDocs, null);
		
		tabbedPane.addChangeListener(new SumListener(sumTab));
		
		// Add menu bar
		new MenuBar(frmPirexDocumentRetrieval);
		frmPirexDocumentRetrieval.addWindowListener(windowCloseHandler);
	}

	@Override
	public void windowActivated(WindowEvent e) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
