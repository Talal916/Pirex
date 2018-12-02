package tabGUI;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import textProcessor.*;

public class SumTabListener implements ChangeListener
{
	//private SumTab sum;
	//Doesn't really need a listener since the data we need to display is mostly stored in ProcessorListener
	//in the LinkedHashMap labelled books. As such we can simply call the hashmap and get the information from each entry in the map
	
	
	/**
	 * Called by the summary tab to be invoked whenever the load tab is used to load in a document
	 */
	public SumTabListener (/*SumTab sum*/) 
	{
		//this.sum = sum;
	}
	
	private void DisplayInfo (/*list containing info from load*/)
	{
		//print out info
		//'opus number': 'author' 'title' 'documents' 
		//'location'
		//LinkedHashMap <Integer, ProcessedBook> map = get map from processorListener
		/*for (Map.Entry <Integer, ProcessedBook> entry : map.entrySet())
		 * {
		 * int opusNum = entry.getKey();		
		 * ProcessedBook book = entry.getValue();
		 * System.out.printf("Opus %i: %s  %s  %i documents\n\t\t%s", opusNum, book.getAuthor(), book.getTitle(), numDocs, path);
		 * 
		 * 
		 * }
		 */
		
	/*
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
