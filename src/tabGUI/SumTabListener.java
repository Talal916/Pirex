package tabGUI;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SumTabListener implements ChangeListener
{
	//private SumTab sum;
	
	
	public SumTabListener (/*SumTab sum*/) 
	{
		//this.sum = sum;
	}
	
	private void DisplayInfo (/*list containing info from load*/)
	{
		//print out info
		//'opus number': 'author' 'title' 'documents'
		//'location'
		
	/*
	 * for each item in the list
	 * System.out.printf("Opus %s: %s  %s  %i documents\n\t\t%s", opusNum, author, title, numDocs, path);
	 * 
	 * System.out.printf("Total index terms: %i", indexTerms);
	 * System.out.printf("Total postings: %i", postings);
	 * 
	 
	 */
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		//Listens to the load tab and activates once a document is loaded into pirex.
		//add info to a list, pass it into display info
		//DisplayInfo(ListOfInfo);
		
	}
}
